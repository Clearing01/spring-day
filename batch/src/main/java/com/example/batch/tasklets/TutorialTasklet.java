package com.example.batch.tasklets;

import com.example.batch.entity.UserEntity;
import com.example.batch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;


@Slf4j
@RequiredArgsConstructor
public class TutorialTasklet implements Tasklet {


    final UserRepository userRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("executed tasklet !!");

        insertUser();

        return RepeatStatus.FINISHED;
    }

    public void insertUser(){
        UserEntity user = new UserEntity();
        user.setPw("1234");
        user.setName("1111");

        System.out.println(user);
        System.out.println(userRepository);

        userRepository.save(user);
    }
}
