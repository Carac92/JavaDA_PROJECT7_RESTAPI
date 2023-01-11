package com.nnk.springboot.controller;

import com.nnk.springboot.controllers.BidListController;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.service.BidListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BidListController.class)
@WithMockUser(username = "admin", password = "mdp123")
public class BidListControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private BidListService bidListService;



    @Test
    public void home() throws Exception {
        mvc.perform(get("/bidList/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("bidList/list"))
                .andExpect(model().attributeExists("bidList"));
    }
    @Test
    public void addBidForm() throws Exception {
        mvc.perform(get("/bidList/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("bidList/add"))
                .andExpect(model().attributeExists("bidList"));
    }
    @Test
    public void validate() throws Exception {
        BidList bidList = new BidList("account", "type", 10.0);
        mvc.perform(post("/bidList/validate").with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content("account=account&type=type&bidQuantity=10.0")
                .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/bidList/list"));
    }
    @Test
    public void showUpdateForm() throws Exception {
        BidList bidList = new BidList("account", "type", 10d);
        when(bidListService.getBidListById(1)).thenReturn(Optional.of(bidList));
        mvc.perform(get("/bidList/update/1").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("bidList/update"))
                .andExpect(model().attributeExists("bid"));
    }
    @Test
    public void updateBid() throws Exception {
        BidList bidList = new BidList("account", "type", 10d);
        mvc.perform(post("/bidList/update/1").with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bidList.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/bidList/update/{id}"));
    }
    @Test
    public void deleteBid() throws Exception {
        mvc.perform(get("/bidList/delete/1").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/bidList/list"));
    }
}

