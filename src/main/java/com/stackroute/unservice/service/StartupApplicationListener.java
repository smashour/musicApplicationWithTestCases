package com.stackroute.unservice.service;


import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.jboss.logging.Logger;

//import java.util.logging.Logger;

@Component
@PropertySource("classpath:application.properties")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logs = Logger.getLogger(StartupApplicationListener.class);
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