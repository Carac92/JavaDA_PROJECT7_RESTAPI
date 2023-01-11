package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class BidListServiceTest {

    @InjectMocks
    private BidListService bidListService;

    @Mock
    private BidListRepository bidListRepository;

    @Test
    public void saveBidListTest() {
        //GIVEN
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        //WHEN
        bidListService.addBidList(bid);
        //THEN
        verify(bidListRepository,times(1)).save(bid);
    }
    @Test
    public void FindByIdBidListTest() {
        //GIVEN
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        bid.setId(1);
        Integer id = bid.getId();
        //WHEN
        when(bidListRepository.findById(id)).thenReturn(java.util.Optional.of(bid));
        Optional<BidList> bidList = bidListService.getBidListById(id);
        //THEN
        assertThat(bidList.get().getId()).isEqualTo(id);
        assertThat(bidList.get().getAccount()).isEqualTo(bid.getAccount());
        assertThat(bidList.get().getType()).isEqualTo(bid.getType());
    }
    @Test
    public void UpdateBidListTest(){
        //GIVEN
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        bidListService.addBidList(bid);
        bid.setBidQuantity(20d);
        //WHEN
        bidListService.updateBidList(bid);
        //THEN
        verify(bidListRepository,times(2)).save(bid);
    }
    @Test
    public void DeleteByIdBidListTest(){
        // GIVEN
        BidList bid = new BidList("Account Test", "Type Test", 10d);
        bid.setId(1);
        Integer id = bid.getId();
        // WHEN
        bidListService.deleteBidList(id);
        // THEN
        verify(bidListRepository,times(1)).deleteById(id);
    }

}
