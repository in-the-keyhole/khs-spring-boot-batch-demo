package khs.example.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class JobLauncherController {
 
	@Autowired
	JobLauncher jobLauncher;
 
	@Autowired
	@Qualifier("helloworldjob")
	Job job;
	
	@Autowired
	@Qualifier("stockticker")
	Job stockTickerJob;
	
 
	@RequestMapping("/launchhelloworld")
	public String handle() throws Exception {
 
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
 
		return "Job Done, check console...";
	}
	
	
	@RequestMapping("/launchstockticker")
	public String stockticker() throws Exception {
 
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(stockTickerJob, jobParameters);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
 
		return "Job Done, check console...";
	}
	
	
			
}