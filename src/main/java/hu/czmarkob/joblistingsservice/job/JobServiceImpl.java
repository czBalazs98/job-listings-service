package hu.czmarkob.joblistingsservice.job;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;

	private final JobDtoMapper mapper = Mappers.getMapper(JobDtoMapper.class);

	@Override
	public List<JobDto> findJobs() {
		return jobRepository.findAll().stream()
							.map(mapper::toDto)
							.toList();
	}

	@Override
	public List<JobDto> findJobs(List<String> keywords) {
		List<Job> jobs;
		if ( keywords.isEmpty() ) {
			jobs = jobRepository.findAll();
		} else {
			Specification<Job> searchSpecification = createSearchSpecification(keywords);
			jobs = jobRepository.findAll(searchSpecification);
		}

		return jobs.stream().map(mapper::toDto).toList();
	}

	private Specification<Job> createSearchSpecification(List<String> keywords) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			keywords.forEach(keyword -> predicates.add(createPredicateForKeyword(criteriaBuilder, root, "%" + keyword + "%")));
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}

	private Predicate createPredicateForKeyword(CriteriaBuilder criteriaBuilder, Root<Job> root, String searchKeyword) {
		return criteriaBuilder.or(criteriaBuilder.like(root.get(Job_.company), searchKeyword), criteriaBuilder.like(root.get(Job_.position), searchKeyword),
				criteriaBuilder.like(root.get(Job_.location), searchKeyword), criteriaBuilder.like(root.join(Job_.tools), searchKeyword),
				criteriaBuilder.like(root.get(Job_.jobType).as(String.class), searchKeyword.replaceAll("\\s", "")));
	}

	@Override
	public JobDto createJob(JobDto jobDto) {
		Job job = jobRepository.save(mapper.fromDto(jobDto));
		return mapper.toDto(job);
	}
}
