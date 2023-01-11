package com.nnk.springboot.controller;

import com.nnk.springboot.controllers.CurveController;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.service.CurvePointService;
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
@WebMvcTest(CurveController.class)
@WithMockUser
public class CurveControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CurvePointService curvePointService;

    @Test
    public void home() throws Exception {
        mvc.perform(get("/curvePoint/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("curvePoint/list"))
                .andExpect(model().attributeExists("curvePointList"));
    }
    @Test
    public void addCurveForm() throws Exception {
        mvc.perform(get("/curvePoint/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("curvePoint/add"))
                .andExpect(model().attributeExists("curvePoint"));
    }
    @Test
    public void validate() throws Exception {
        mvc.perform(post("/curvePoint/validate").with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content("curveId=1&term=10&value=10")
                .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/curvePoint/list"));
    }
    @Test
    public void showUpdateForm() throws Exception {
        CurvePoint curvePoint = new CurvePoint(1, 10d, 10d);
        curvePoint.setId(1);
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
        mvc.perform(get("/curvePoint/update/1").with(csrf()))
                .andExpect(status().isOk())
                .andExpect(view().name("curvePoint/update"))
                .andExpect(model().attributeExists("curvePoint"));
    }
    @Test
    public void updateCurve() throws Exception {
        CurvePoint curvePoint = new CurvePoint(1, 10d, 10d);
        curvePoint.setId(1);
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
        mvc.perform(post("/curvePoint/update/1").with(csrf())
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .content("curveId=1&term=10&value=10")
                .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/curvePoint/list"));
    }
    @Test
    public void deleteCurve() throws Exception {
        CurvePoint curvePoint = new CurvePoint(1, 10d, 10d);
        curvePoint.setId(1);
        when(curvePointService.getCurvePointById(1)).thenReturn(Optional.of(curvePoint));
        mvc.perform(get("/curvePoint/delete/1").with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/curvePoint/list"));
    }
}
