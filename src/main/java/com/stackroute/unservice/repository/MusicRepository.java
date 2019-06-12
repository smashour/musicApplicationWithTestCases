package com.stackroute.unservice.repository;

import com.stackroute.unservice.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface MusicRepository extends MongoRepository<Music,Integer> {

}
