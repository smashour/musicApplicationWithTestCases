package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.repository.MusicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component

public class CommandLineRunnerApp implements CommandLineRunner {
    private static final Logger logger= LoggerFactory.getLogger(CommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("app started in command line",Arrays.toString(args));


    }
    @Bean
    public CommandLineRunner demoData(MusicRepository musicRepo) {

      Music music= new Music(3,"Raja","Ed Sheeran");
        Music music1 = new Music(4,"Wakka","Shakeera");

        return args -> {
            musicRepo.save(music);
            musicRepo.save(music1);
        };
    }
}
