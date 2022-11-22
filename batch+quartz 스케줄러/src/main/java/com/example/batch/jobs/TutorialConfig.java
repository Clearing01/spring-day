package com.example.batch.jobs;

import com.example.batch.entity.UserEntity;
import com.example.batch.repository.UserRepository;
import com.example.batch.tasklets.TutorialTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional
public class TutorialConfig {

    @Autowired
    @Qualifier("JpaUserRepository")
    UserRepository userRepository;

    private final JobBuilderFactory jobBuilderFactory; // Job 빌더 생성용
    private final StepBuilderFactory stepBuilderFactory; // Step 빌더 생성용

    // JobBuilderFactory를 통해서 tutorialJob을 생성
    @Bean
    public Job tutorialJob() {
        return jobBuilderFactory.get("tutorialJob")
                .start(tutorialStep())  // Step 설정
                .build();
    }

    // StepBuilderFactory를 통해서 tutorialStep을 생성
    @Bean
    public Step tutorialStep() {

        UserEntity user = new UserEntity();
        user.setPw("1234");
        user.setName("1111");

        System.out.println(user);
        System.out.println(userRepository);

        userRepository.save(user);

        return stepBuilderFactory.get("tutorialStep")
                .tasklet(new TutorialTasklet()) // Tasklet 설정
                .build();
    }
}