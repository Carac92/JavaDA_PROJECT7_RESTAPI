package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getTrade(){
        return tradeRepository.findAll();
    }
    public void addTrade(Trade trade){
        log.info("Adding trade");
        tradeRepository.save(trade);
    }
    public void updateTrade(Trade trade){
        log.info("Updating trade");
        tradeRepository.save(trade);
    }
    public void deleteTrade(Integer id){
        log.info("Deleting trade");
        tradeRepository.deleteById(id);
    }
}
