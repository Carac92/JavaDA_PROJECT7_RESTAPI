package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Curve point repository extends JpaRepository for CRUD methods.
 */
@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
