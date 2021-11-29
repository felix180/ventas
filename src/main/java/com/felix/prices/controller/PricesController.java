package com.felix.prices.controller;

import com.felix.prices.domain.FindResult;
import com.felix.prices.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;

@RestController("price")
public class PricesController {

  @Autowired private PricesService pricesService;

  @GetMapping("/find")
  public @ResponseBody
  FindResult findByQuery(
      @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime dateTime,
      @RequestParam("productId") Long productId,
      @RequestParam("brandId") Long brandId) {
    return pricesService.findByQuery(dateTime, productId, brandId);
  }

  @RequestMapping(value = "/")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }
}
