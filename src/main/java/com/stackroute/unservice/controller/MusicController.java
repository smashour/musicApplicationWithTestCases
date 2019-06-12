package com.stackroute.unservice.controller;
import com.stackroute.unservice.domain.Music;
import com.stackroute.unservice.exceptions.MusicAlreadyExistException;
import com.stackroute.unservice.exceptions.MusicIdNotFoundException;
import com.stackroute.unservice.exceptions.MusicNotFoundException;
import com.stackroute.unservice.service.MusicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "api/v1/")
public class MusicController {

    MusicService musicService;
    @Autowired
    public MusicController(MusicService musicService){
        this.musicService=musicService;
    }
    private String appTitle;
    @GetMapping("/value")
    public String getValue()
    {
        return appTitle;
    }
    @PostMapping("/user")

    public ResponseEntity<?> saveMusic(@RequestBody Music music) throws MusicAlreadyExistException{
        ResponseEntity responseEntity;
        try {
            musicService.saveMusic(music);
            responseEntity = new ResponseEntity<String>("succesfully created", HttpStatus.CREATED);
        } catch (MusicAlreadyExistException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();


        }
        return responseEntity; // represents complete http request including response body,status code and header
    }


    @GetMapping("/user")
    public ResponseEntity<?> getAlMusics(){
        return new ResponseEntity<List<Music>>(musicService.getAllMusics(),HttpStatus.OK);
    }


    @PutMapping("/user")
    public ResponseEntity<Music> updateMusic(@RequestBody Music music) throws MusicIdNotFoundException {
        ResponseEntity responseEntity;

        try {

            Music music1=musicService.updateTrack(music);
            return new ResponseEntity<Music>(music1, HttpStatus.OK);
        }catch (MusicIdNotFoundException ex)
        {
            throw ex;
        }

    }

    @GetMapping("/user/{name}")




    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteMusic(@PathVariable int id) {
        try {
            musicService.deleteMusic(id);
        } catch (MusicIdNotFoundException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("succesfully deleted", HttpStatus.OK);

    }
}



