package com.example.bathcex2.schedulers;

import lombok.RequiredArgsConstructor;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class TutorialScheduler extends QuartzJobBean {
    @Autowired
    private Job job; //tutorial job
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobExplorer jobExplore;

/*    //5초마다 실행
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
    }*/

    @Override //스케줄링 된 이벤트가 발생할 때마다 1번씩 호출
    protected void executeInternal(JobExecutionContext context) throws org.quartz.JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder(this.jobExplore)
                .getNextJobParameters(this.job)
                .toJobParameters();

        try {
            this.jobLauncher.run(this.job, jobParameters);

        } catch (JobExecutionException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
}
