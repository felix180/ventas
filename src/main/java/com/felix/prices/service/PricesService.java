package com.felix.prices.service;

import com.felix.prices.domain.FindResult;

import java.time.OffsetDateTime;

public interface PricesService {

    FindResult findByQuery(OffsetDateTime dateTime, Long productId, Long brandId);
}
