package com.stackroute.unservice.controller;

import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.exceptions.MusicIdNotFoundException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.service.MusicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/")
public class MusicController {

    MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService){
        this.musicService=musicService;
    }

   // @Value("${app.title}")
    private String appTitle;
    @GetMapping("/value")
    public String getValue()
    {
        return appTitle;
    }

    //@ApiOperation(value = "save a track")
    @PostMapping("/user")

    public ResponseEntity<?> saveMusic(@RequestBody Music music) throws MusicAlreadyExistException{
        ResponseEntity responseEntity;
        try {
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("succesfully created", HttpStatus.CREATED);
        } catch (MusicAlreadyExistException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
            //throw ex;

        }
        return responseEntity; // represents complete http request including response body,status code and header
    }

  //

  //  @ApiOperation(value = "Get list of all tracks")
    @GetMapping("/user")
    public ResponseEntity<?> getAlMusics(){
        return new ResponseEntity<List<Music>>(musicService.getAllMusics(),HttpStatus.OK);
    }


    //@ApiOperation(value = "update a track")
    @PutMapping("/user")
    public ResponseEntity<Music> updateMusic(@RequestBody Music music) throws MusicIdNotFoundException {
        ResponseEntity responseEntity;

        try {

            Music music1=musicService.updateTrack(music);
            return new ResponseEntity<Music>(music1, HttpStatus.OK);
        }catch (MusicIdNotFoundException ex)
        {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//            ex.printStackTrace();
            throw ex;
        }
        //return responseEntity;

    }
  //  @ApiOperation(value = "search a track")
    @GetMapping("/user/{name}")
//    public ResponseEntity<List<Music>> getMusicByName(@PathVariable String name) throws MusicNotFoundException {
//        ResponseEntity responseEntity = null;
//
//        try {
//            List<Music> trackOne = musicService.getMusicByName(name);
//            return new ResponseEntity<List<Music>>(trackOne, HttpStatus.OK);
//        }catch (MusicNotFoundException ex) {
////            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
////            e.printStackTrace();}
////        return responseEntity;
//            throw ex;
//        }
//
//}


   // @ApiOperation(value = "delete a track")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable int id) {
        musicService.deleteMusic(id);
        return new ResponseEntity<String>("succesfully deleted", HttpStatus.OK);

    }
}



