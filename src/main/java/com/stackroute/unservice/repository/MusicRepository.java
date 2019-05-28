package com.stackroute.unservice.repository;

import com.stackroute.unservice.domain.Music;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music,Integer> {
//    @Query(value = "select * from music where name = ?", nativeQuery = true)
//    public List<Music> getMusicByName(String name);
}
