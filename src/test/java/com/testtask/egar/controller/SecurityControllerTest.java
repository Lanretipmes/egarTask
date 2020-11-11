package com.testtask.egar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testtask.egar.entity.Security;
import com.testtask.egar.repository.SecurityRepository;
import com.testtask.egar.service.SecurityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class SecurityControllerTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void A_findAllOK() throws Exception {

        mockMvc.perform(get("/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(7)))
                .andExpect(jsonPath("$[0].id", is(0)))
                .andExpect(jsonPath("$[0].name", is("Gazprom")))
                .andExpect(jsonPath("$[0].cost", is(10000)))
                .andExpect(jsonPath("$[6].id", is(6)))
                .andExpect(jsonPath("$[6].name", is("Gazprom")))
                .andExpect(jsonPath("$[6].cost", is(8750)));

    }

    @Test
    public void B_addSecurityOK() throws Exception {

        Security newSecurity = new Security(7L, LocalDate.parse("2020-10-10"), "Test", 1000);

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        mockMvc.perform(post("/add")
                .content(mapper.writeValueAsString(newSecurity))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                /*.andDo(print())*/
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(7)))
                .andExpect(jsonPath("$[0].name", is("Test")))
                .andExpect(jsonPath("$[0].cost", is(1000)));

                mockMvc.perform(delete("/delete")
                .content(mapper.writeValueAsString(newSecurity))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON));

    }

    @Test
    public void C_updateSecurityOK() throws Exception {

        Security newSecurity = new Security(3L, LocalDate.parse("2020-11-03"), "Hey, I'm updated", 12321);

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        mockMvc.perform(put("/update")
                .content(mapper.writeValueAsString(newSecurity))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                /*.andDo(print())*/
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[3].id", is(3)))
                .andExpect(jsonPath("$[3].name", is("Hey, I'm updated")))
                .andExpect(jsonPath("$[3].cost", is(12321)));

    }

    @Test
    public void D_deleteSecurityOK() throws Exception {

        Security security = new Security(4L, LocalDate.parse("2020-11-03"), "Gazprom", 11000);

        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


        mockMvc.perform(delete("/delete")
                .content(mapper.writeValueAsString(security))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                /*.andDo(print())*/
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)));

    }


}
