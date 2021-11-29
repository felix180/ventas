package com.felix.prices.service;

import com.felix.prices.domain.FindResult;
import com.felix.prices.entity.Price;
import com.felix.prices.mapper.PriceMapper;
import com.felix.prices.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {
  @Autowired private PricesRepository pricesRepository;

  @Override
  public FindResult findByQuery(OffsetDateTime dateTime, Long productId, Long brandId) {

    ZoneOffset offset = OffsetDateTime.now().getOffset();
    OffsetDateTime offsetDateTime = dateTime.withOffsetSameLocal(offset);
    List<Price> prices = pricesRepository.findPriceByQuery(brandId, productId, offsetDateTime);
    Price price = prices.stream().max(Comparator.comparing(Price::getPriority)).orElse(new Price());

    return PriceMapper.aply(price);
  }
}
