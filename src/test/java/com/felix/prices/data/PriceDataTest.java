package com.felix.prices.data;

import org.junit.jupiter.api.Disabled;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Disabled
public class PriceDataTest {

  public static OffsetDateTime get10H_14D() {
    OffsetDateTime date =
        OffsetDateTime.parse("2020-06-14T10:00:00Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    return date;
  }

  public static OffsetDateTime get16H_14D() {
    OffsetDateTime date =
        OffsetDateTime.parse("2020-06-14T16:00:00Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    return date;
  }

  public static OffsetDateTime get21H_14D() {
    OffsetDateTime date =
        OffsetDateTime.parse("2020-06-14T21:00:00Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    return date;
  }

  public static OffsetDateTime get10H_15D() {
    OffsetDateTime date =
        OffsetDateTime.parse("2020-06-15T10:00:00Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    return date;
  }

  public static OffsetDateTime get21H_16D() {
    OffsetDateTime date =
        OffsetDateTime.parse("2020-06-16T21:00:00Z", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    return date;
  }
}
