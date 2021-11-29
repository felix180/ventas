package com.felix.prices.repository;

import com.felix.prices.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

  @Query(
      "SELECT h FROM Price h WHERE h.brandId =:brandId  AND h.productId=:productId " +
              "AND :date BETWEEN h.startDate AND h.endDate ")
  List<Price> findPriceByQuery(
          @Param("brandId") Long brandId,
      @Param("productId") Long productId,
      @Param("date") OffsetDateTime date);
}
