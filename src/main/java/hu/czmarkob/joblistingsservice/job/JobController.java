package hu.czmarkob.joblistingsservice.job;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

	private final JobService jobService;

	@GetMapping
	public List<JobDto> findJobs() {
		return jobService.findJobs();
	}

	@GetMapping("/filter")
	public List<JobDto> findJobsByCriteria(@RequestParam @Nullable List<String> keywords) {
		return jobService.findJobs(keywords);
	}

	@PostMapping
	public JobDto createJob(@RequestBody JobDto jobDto) {
		return jobService.createJob(jobDto);
	}
}
