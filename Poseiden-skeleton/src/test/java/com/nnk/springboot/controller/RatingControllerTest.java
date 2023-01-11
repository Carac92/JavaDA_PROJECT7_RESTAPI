package com.nnk.springboot.controller;

import com.nnk.springboot.controllers.RatingController;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.service.RatingService;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@WebMvcTest(RatingController.class)
@WithMockUser
public class RatingControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RatingService ratingService;

    @Test
    public void home() throws Exception {
        mvc.perform(get("/rating/list").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("rating/list"))
                .andExpect(model().attributeExists("ratings"));
    }
    @Test
    public void addRatingForm() throws Exception {
        mvc.perform(get("/rating/add").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("rating/add"))
                .andExpect(model().attributeExists("rating"));
    }
    @Test
    public void validate() throws Exception {
        mvc.perform(post("/rating/validate").with(csrf())
                        .accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content("moodysRating=1&sandPRating=10&fitchRating=10&orderNumber=1")
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/rating/list"));
    }
    @Test
    public void showUpdateForm() throws Exception {
        Rating rating = new Rating("moodysRating", "sandPRating", "fitchRating", 1);
        when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
        mvc.perform(get("/rating/update/1").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("rating/update"))
                .andExpect(model().attributeExists("rating"));
    }
    @Test
    public void updateRating() throws Exception {
        Rating rating = new Rating("moodysRating", "sandPRating", "fitchRating", 1);
        when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
        mvc.perform(post("/rating/update/1").with(csrf())
                        .accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content("moodysRating=1&sandPRating=10&fitchRating=10&orderNumber=1")
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/rating/list"));
    }
    @Test
    public void deleteRating() throws Exception {
        Rating rating = new Rating("moodysRating", "sandPRating", "fitchRating", 1);
        when(ratingService.getRatingById(1)).thenReturn(Optional.of(rating));
        mvc.perform(get("/rating/delete/1").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/rating/list"));
    }
}
