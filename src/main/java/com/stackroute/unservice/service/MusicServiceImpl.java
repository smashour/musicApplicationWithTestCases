package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.exceptions.MusicIdNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MusicServiceImpl implements MusicService {

    MusicRepository musicRepository;
    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository){
        this.musicRepository=musicRepository;
    }


    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistException {
        if(musicRepository.existsById(music.getId())){
            throw new MusicAlreadyExistException("music already exists");
        }
        Music savedMusic=musicRepository.save(music);
        if (savedMusic==null){
            throw new MusicAlreadyExistException("music already exists");
        }
        return savedMusic;
    }

    @Override
    public List<Music> getAllMusics() {
        return musicRepository.findAll();


    }

    @Override
    public MusicRepository deleteMusic(int id) {
       musicRepository.deleteById(id);
       return musicRepository;
    }



    @Override
    public Music updateTrack(Music music) throws MusicIdNotFoundException {
        Music savedMusic=musicRepository.save(music);
        if(savedMusic==null)
        {
            throw new MusicIdNotFoundException("music not found");
        }
        return savedMusic;
    }



   // @Override
//    public List<Music> getMusicByName(String name) throws MusicNotFoundException {
//        List<Music> listOfTracks = null;
//        listOfTracks = musicRepository.getMusicByName(name);
//        if (listOfTracks.equals(null))
//        {
//            throw new MusicNotFoundException("Track not found exception");
//        }
//        return listOfTracks;
//    }

    @Override
    public void seedData(Music music) {
        if(!musicRepository.existsById(music.getId())){
            musicRepository.save(music);
        }
    }


}