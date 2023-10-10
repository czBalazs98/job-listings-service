package hu.czmarkob.joblistingsservice.job;

import java.util.List;

public interface JobService {

	List<JobDto> findJobs();

	List<JobDto> findJobs(List<String> keywords);

	JobDto createJob(JobDto jobDto);
}
