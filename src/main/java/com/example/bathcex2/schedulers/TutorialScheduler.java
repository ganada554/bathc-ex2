package com.example.bathcex2.schedulers;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TutorialScheduler {
    private final Job job; //tutorial job
    private final JobLauncher jobLauncher;

    //5초마다 실행
    @Scheduled(fixedDelay = 5*1000L)
    public void executeJob(){
        try {
            jobLauncher.run( //job, Job Parameter를 매개변수로 받음
                    job,
                    new JobParametersBuilder() //반복해서 실행할 Job의 유일한 ID
                            .addString("datetime", LocalDateTime.now().toString())
                            .toJobParameters() //job Parameter 설정
            );
        } catch (JobExecutionException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
