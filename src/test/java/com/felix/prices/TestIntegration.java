package com.felix.prices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felix.prices.data.PriceDataTest;
import com.felix.prices.domain.FindResult;
import com.felix.prices.entity.Price;
import com.felix.prices.repository.PricesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PricesApplication.class)
@AutoConfigureMockMvc
public class TestIntegration {

  @Autowired private MockMvc mvc;

  @Autowired private PricesRepository repository;

  @Autowired private ObjectMapper objectMapper;


    @Test
    void testValue1() throws Exception {
        BigDecimal expectedPrice = new BigDecimal("35.50");
        MvcResult resultActions =
                mvc.perform(
                        get("/find"+"?brandId=1&productId=35455&date="+ PriceDataTest.get10H_14D())
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        FindResult result = parseResponse(resultActions, FindResult.class);

        Assertions.assertEquals( expectedPrice,result.getPrice());

    }




    @Test
    void testValue2() throws Exception {
        BigDecimal expectedPrice = new BigDecimal("25.45");
        MvcResult resultActions =
                mvc.perform(
                        get("/find"+"?brandId=1&productId=35455&date="+ PriceDataTest.get16H_14D())
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        FindResult result = parseResponse(resultActions, FindResult.class);

        Assertions.assertEquals( expectedPrice,result.getPrice());


    }

    @Test
    void testValue3() throws Exception {
        BigDecimal expectedPrice = new BigDecimal("35.50");
        MvcResult resultActions =
                mvc.perform(
                        get("/find"+"?brandId=1&productId=35455&date="+ PriceDataTest.get21H_14D())
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        FindResult result = parseResponse(resultActions, FindResult.class);

        Assertions.assertEquals( expectedPrice,result.getPrice());

    }

    @Test
    void testValue4() throws Exception {
        BigDecimal expectedPrice = new BigDecimal("30.50");
        MvcResult resultActions =
                mvc.perform(
                        get("/find"+"?brandId=1&productId=35455&date="+ PriceDataTest.get10H_15D())
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        FindResult result = parseResponse(resultActions, FindResult.class);

        Assertions.assertEquals( expectedPrice,result.getPrice());

    }

    @Test
    void testValue5() throws Exception {
        BigDecimal expectedPrice = new BigDecimal("38.95");
        MvcResult resultActions =
                mvc.perform(
                        get("/find"+"?brandId=1&productId=35455&date="+ PriceDataTest.get21H_16D())
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        FindResult result = parseResponse(resultActions, FindResult.class);

        Assertions.assertEquals( expectedPrice,result.getPrice());

    }

  private <T> T parseResponse(MvcResult result, Class<T> responseClass) {
    try {
      String contentAsString = result.getResponse().getContentAsString();
      return objectMapper.readValue(contentAsString, responseClass);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
