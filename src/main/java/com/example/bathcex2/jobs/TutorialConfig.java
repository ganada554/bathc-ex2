package com.example.bathcex2.jobs;

import com.example.bathcex2.TutorialProcessor;
import com.example.bathcex2.TutorialReader;
import com.example.bathcex2.TutorialWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class TutorialConfig  {
    @Autowired
    private final JobBuilderFactory jobBuilderFactory; //Job 빌더 생성
    @Autowired
    private final StepBuilderFactory stepBuilderFactory; //Step 빌더 생성


    //JobBuilderFactory를 통해 tutorialJob 생성
    @Bean
    public Job tutorialJob(Step tutorialStep){
        return jobBuilderFactory.get("tutorialJob")
                .incrementer(new RunIdIncrementer())
                //.flow(processLines())
                //.end()
                .start(processLines())
                .build();
    }

    @Bean
    public Step processLines(){
        return stepBuilderFactory.get("processLines")
                .<String, String>chunk(6)
                .reader(new TutorialReader()) //import org.springframework.batch.item.ItemReader;
                .processor((new TutorialProcessor())
                .writer(new TutorialWriter())
                .build();
    }


/*    //StepBuilderFactory를 통해 tutorialStep 생성
    @Bean
    public Step tutorialStep(){
        return stepBuilderFactory.get("tutoralStep")
                .tasklet(new TutorialTasklet()) //Tasklet 설정
                .build();
    }*/

}
