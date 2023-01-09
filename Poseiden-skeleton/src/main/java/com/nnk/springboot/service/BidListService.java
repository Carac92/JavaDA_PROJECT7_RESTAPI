package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class BidListService {
    @Autowired
    private BidListRepository bidListRepository;

    public List<BidList> getBidList() {
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
}
