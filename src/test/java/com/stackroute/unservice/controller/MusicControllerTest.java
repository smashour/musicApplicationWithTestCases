package com.stackroute.unservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.service.MusicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MusicControllerTest{


    @Autowired
    private MockMvc mockMvc;
    private Music music;
    @MockBean
    private MusicService musicService;
    @InjectMocks
    private MusicController musicController;

    private List<Music> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();
       music = new Music();
        music.setId(26);
        music.setName("kwab he thu");
        music.setComments("hindi");
        list = new ArrayList();
        list.add(music);
    }

    @Test
    public void saveMusic() throws Exception {
        when(musicService.saveMusic(any())).thenReturn(music);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void saveMusicFailure() throws Exception {
        when(musicService.saveMusic(any())).thenThrow(MusicAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllMusics() throws Exception {
        when(musicService.getAllMusics()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void updateComment() throws Exception {
        when(musicService.updateTrack(any())).thenReturn(music);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void deleteMusic() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/user",1)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getMusicByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user",1)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(music)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }








}
