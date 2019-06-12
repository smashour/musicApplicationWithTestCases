package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.exceptions.MusicIdNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;

import java.util.List;

public interface MusicService {

    public Music saveMusic(Music music) throws MusicAlreadyExistException;

    public List<Music> getAllMusics();

    public MusicRepository deleteMusic(int id) throws MusicIdNotFoundException;

    Music updateTrack(Music music) throws MusicIdNotFoundException;



    public void seedData(Music music);
}
