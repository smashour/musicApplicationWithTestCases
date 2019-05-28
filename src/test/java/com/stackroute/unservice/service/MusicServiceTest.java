package com.stackroute.unservice.service;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.exceptions.MusicIdNotFoundException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.repository.MusicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MusicServiceTest {

    private Music music;
    //Create a mock for UserRepository
    @Mock
    private MusicRepository musicRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private MusicServiceImpl musicService;
    List<Music> list = null;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        music = new Music();
        music.setId(26);
        music.setName("kwab he thu");
        music.setComments("hindi");

        list = new ArrayList<>();
        list.add(music);

    }

    @Test
    public void saveUserTestSuccess() throws MusicAlreadyExistException {

        when(musicRepository.save((Music) any())).thenReturn(music);
        Music savedMusic = musicService.saveMusic(music);
        Assert.assertEquals(music, savedMusic);

        //verify here verifies that userRepository save method is only called once
        verify(musicRepository, times(1)).save(music);

    }

    @Test(expected = MusicAlreadyExistException.class)
    public void saveUserTestFailure() throws MusicAlreadyExistException {
        when(musicRepository.save((Music) any())).thenReturn(null);
        Music savedMusic = musicService.saveMusic(music);
        System.out.println("savedMusic" + savedMusic);
        Assert.assertEquals(music, savedMusic);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllMusics() {

        musicRepository.save(music);
        //stubbing the mock to return specific data
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> userlist = musicService.getAllMusics();
        Assert.assertEquals(list, userlist);
    }

    @Test
    public void getAllMusicsFailure() throws MusicNotFoundException{
        when(musicRepository.findAll()).thenReturn(null);
        List<Music> userlist = musicService.getAllMusics();
        Assert.assertEquals(null, userlist);

    }

    @Test
    public void updateComment() throws MusicIdNotFoundException {

        when(musicRepository.save((Music) any())).thenReturn(music);
            Music updateMusic = musicService.updateComment(music);

        verify(musicRepository,times(1)).save(music);

    }

    @Test
    public void deleteMusic() throws MusicIdNotFoundException{
        when(musicRepository.findAll()).thenReturn(null);
        musicService.deleteMusic(26);


    }


//
//    @Test(expected = MusicNotFoundException.class)
//    public void removeMuzixTestFailure() throws MusicNotFoundException {
//        //when(muzixRepository.existsById(muzix.getTrackId())).thenReturn(true);
//        musicRepository.deleteById(music.getId());
//        when(musicRepository.findAll()).thenReturn(null);
//        List <Music> removeMuzix = musicService.deletemusic.getId());
//        System.out.println("savedMuzix" + removeMuzix);
//        System.out.println(muzix);
//        Assert.assertEquals(list,removeMuzix);
//
//      /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
//      userService.saveUser(user);*/


    //}





}




