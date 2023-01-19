package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Bid list repository extends JpaRepository for CRUD methods.
 */
@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
