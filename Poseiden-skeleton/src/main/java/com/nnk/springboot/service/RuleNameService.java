package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RuleNameService {
    @Autowired
    private RuleNameRepository ruleNameRepository;

    public List<RuleName> getRuleName(){
        return ruleNameRepository.findAll();
    }
    public void addRuleName(RuleName ruleName){
        log.info("Adding ruleName");
        ruleNameRepository.save(ruleName);
    }
    public void updateRuleName(RuleName ruleName){
        log.info("Updating ruleName");
        ruleNameRepository.save(ruleName);
    }
    public void deleteRuleName(Integer id){
        log.info("Deleting ruleName");
        ruleNameRepository.deleteById(id);
    }
}
