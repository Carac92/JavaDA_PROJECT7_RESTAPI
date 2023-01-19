package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Curve point service. Autowired CurvePointRepository.
 * Implements CRUD methods.
 * log each request with log4j2.
 */
@Log4j2
@Service
public class CurvePointService {
    @Autowired
    private CurvePointRepository curvePointRepository;

    public List<CurvePoint> getAllCurvePoint(){
        return curvePointRepository.findAll();
    }

    public void addCurvePoint(CurvePoint curvePoint){
        log.info("Adding curvePoint");
        curvePointRepository.save(curvePoint);
    }

    public void updateCurvePoint(CurvePoint curvePoint){
        log.info("Updating curvePoint");
        curvePointRepository.save(curvePoint);
    }

    public void deleteCurvePoint(Integer id){
        log.info("Deleting curvePoint");
        curvePointRepository.deleteById(id);
    }

    public Optional<CurvePoint> getCurvePointById(Integer id) {
        return curvePointRepository.findById(id);
    }
}
