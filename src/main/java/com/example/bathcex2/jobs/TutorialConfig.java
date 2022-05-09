package com.example.bathcex2.jobs;

import com.example.bathcex2.chunk.TutorialReader;
import com.example.bathcex2.tasklets.TutorialTasklet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.batch.api.chunk.ItemReader;

@Configuration
@RequiredArgsConstructor
public class TutorialConfig  {
    private final JobBuilderFactory jobBuilderFactory; //Job 빌더 생성
    private final StepBuilderFactory stepBuilderFactory; //Step 빌더 생성

    //reader 생성
    @Bean
    public ItemReader itemReader(){
        return new TutorialReader();
    }


    //JobBuilderFactory를 통해 tutorialJob 생성
    @Bean
    public Job tutorialJob(){
        return jobBuilderFactory.get("tutorialJob")
                .start(tutorialStep()) //Step 설정
                .build();
    }

    //StepBuilderFactory를 통해 tutorialStep 생성
    @Bean
    public Step tutorialStep(){
        return stepBuilderFactory.get("tutoralStep")
                .tasklet(new TutorialTasklet()) //Tasklet 설정
                .build();
    }

}
