package hu.czmarkob.joblistingsservice.config;

import hu.czmarkob.joblistingsservice.auth.AuthenticationService;
import hu.czmarkob.joblistingsservice.job.JobRepository;
import hu.czmarkob.joblistingsservice.job.JobService;
import hu.czmarkob.joblistingsservice.job.JobServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@Configuration
public class ApplicationConfig {

	@Bean
	JobService jobService(JobRepository jobRepository) {
		return new JobServiceImpl(jobRepository);
	}
}
