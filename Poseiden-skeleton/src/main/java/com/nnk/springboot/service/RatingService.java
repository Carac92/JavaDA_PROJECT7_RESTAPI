package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getRating(){
        return ratingRepository.findAll();
    }
    public void addRating(Rating rating){
        log.info("Adding rating");
        ratingRepository.save(rating);
    }
    public void updateRating(Rating rating){
        log.info("Updating rating");
        ratingRepository.save(rating);
    }
    public void deleteRating(Integer id){
        log.info("Deleting rating");
        ratingRepository.deleteById(id);
    }
}
