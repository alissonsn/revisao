package br.jus.tjrn.esb.scheduled.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTasks {
	
	@Autowired
	private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
    	String str = restTemplate.getForObject("http://localhost:5555/api/users", String.class);
        log.info("The time is now {}", dateFormat.format(new Date()));
        log.info("Content: " + str);
    }
}