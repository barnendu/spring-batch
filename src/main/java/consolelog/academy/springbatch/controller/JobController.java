package consolelog.academy.springbatch.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JobController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    Job job;
    @GetMapping("/load")
    public BatchStatus loadFile() throws JobRestartException, JobParametersInvalidException, JobExecutionAlreadyRunningException,JobInstanceAlreadyCompleteException{
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(jobParameterMap);
            JobExecution jobExecution = jobLauncher.run(job, parameters);
            System.out.println("Batch job started...");
            while(jobExecution.isRunning()){
                System.out.println("Job is still runing...");
            }
            return jobExecution.getStatus();
    }
}
