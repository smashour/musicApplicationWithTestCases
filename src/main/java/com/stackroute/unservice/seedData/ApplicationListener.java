package com.stackroute.unservice.seedData;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.repository.MusicRepository;
import com.stackroute.unservice.service.MusicService;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(ApplicationListener.class);
    private MusicRepository musicRepository;

    @Autowired
    MusicService musicService;
    Music track2;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        track2 = new Music(3,"walkthroughfire","Singer : alanwalker");
        musicService.seedData(track2);
        logs.info("data successfully inserted");
    }
}
