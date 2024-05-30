package com.nsv.examples.spring.boot.data.jdbc.ex.data.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@Table("PRICE_PER_VOLUME_ITEMS")
public class PricePerVolumeEntity {

    @Id
    @Column("UUID")
    private String uuid;
    @Column("CLIENT_QUOTE_ID")
    private String clientQuoteId;
    @Column("MIN_VOLUME")
    private BigDecimal minVolume;
    @Column("MAX_VOLUME")
    private BigDecimal maxVolume;
    @Column("BID")
    private BigDecimal bid;
    @Column("ASK")
    private BigDecimal ask;

}
