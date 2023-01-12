package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * The type Bid list service. Autowired BidListRepository.
 * Implements CRUD methods.
 * log each request with log4j2.
 */
@Log4j2
@Service
public class BidListService {
    @Autowired
    private BidListRepository bidListRepository;

    public List<BidList> getAllBidList() {
        return bidListRepository.findAll();
    }

    @Transactional
    public void addBidList(BidList bid){
        log.info("Adding bidList");
        bidListRepository.save(bid);
    }

    @Transactional
    public void updateBidList(BidList bidList){
        log.info("Updating bidList");
        bidListRepository.save(bidList);
    }

    @Transactional
    public void deleteBidList(Integer id){
        log.info("Deleting bidList");
        bidListRepository.deleteById(id);
    }

    public Optional<BidList> getBidListById(Integer id) {
        return bidListRepository.findById(id);
    }
}
