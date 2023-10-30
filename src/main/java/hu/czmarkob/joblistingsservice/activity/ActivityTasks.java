package hu.czmarkob.joblistingsservice.activity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActivityTasks {

	@Scheduled(fixedRate = 840000)
	public void stayActive() {
		log.info("Keeping application active...");
	}
}
