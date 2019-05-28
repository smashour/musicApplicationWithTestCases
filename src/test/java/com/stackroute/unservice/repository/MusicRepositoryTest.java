package com.stackroute.unservice.repository;


import com.stackroute.unservice.MusicServiceApplication;
import com.stackroute.unservice.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class MusicRepositoryTest {
    @Autowired
    private MusicRepository musicRepository;
    private Music music;

    @Before
    public void setUp()
    {
        music = new Music();
        music.setId(26);
        music.setName("kwab he thu");
        music.setComments("hindi");

    }

    @After
    public void tearDown(){

        musicRepository.deleteAll();
    }


    @Test
    public void testSaveMusic(){
        musicRepository.save(music);
        Music fetchmusic = musicRepository.findById(music.getId()).get();
        Assert.assertEquals(26,fetchmusic.getId());

    }

    @Test
    public void testSavemusicFailure(){
        Music testmusic = new Music(22,"mani","hindi");
        musicRepository.save(music);
        Music fetchmusic = musicRepository.findById(music.getId()).get();
        Assert.assertNotSame(testmusic,music);
    }

    @Test
    public void testGetAllMusics(){
        Music u = new Music(10,"Parayuvan","Malayalam");
        Music u1 = new Music(11,"Ishq Sufiyana","Hindi");
        musicRepository.save(u);
        musicRepository.save(u1);

        List<Music> list = musicRepository.findAll();
        Assert.assertEquals("Parayuvan",list.get(0).getName());

    }

    @Test
    public void updateComment(){
        Music m1=new Music(26,"rAJ","MALYA");
        musicRepository.save(m1);

    }

    @Test
    public void deleteMusic(){
        Music m1=new Music(8,"hello","tamil");
        musicRepository.delete(m1);
    }
}
