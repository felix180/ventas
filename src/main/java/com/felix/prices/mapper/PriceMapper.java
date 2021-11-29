package com.felix.prices.mapper;

import com.felix.prices.domain.FindResult;
import com.felix.prices.entity.Price;

public class PriceMapper {
    public static FindResult aply(Price price){
        FindResult findResult = new FindResult();
        findResult.setPrice(price.getPrice());
        findResult.setBrandId(price.getBrandId());
        findResult.setPriceList(price.getPriceList());
        findResult.setEndDate(price.getEndDate());
        findResult.setProductId(price.getProductId());
        findResult.setStartDate(price.getStartDate());
        return findResult;
    }
}
