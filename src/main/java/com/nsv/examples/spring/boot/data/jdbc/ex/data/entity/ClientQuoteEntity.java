package com.nsv.examples.spring.boot.data.jdbc.ex.data.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "CLIENT_QUOTES")
public class ClientQuoteEntity {
    @Version
    @Column("VERSION")
    private Integer version;
    @Id
    @Column("UUID")
    private String uuid;
    @Column("TRADE_RULE_ID")
    private String tradeRuleId;
    @Column("MARKET_QUOTE_ID")
    private String marketQuoteId;
    @Column("SYMBOL")
    private String symbol;
    @Column("DATE_TIME")
    private OffsetDateTime dateTime;
    @MappedCollection(idColumn = "CLIENT_QUOTE_ID", keyColumn = "UUID")
    private List<PricePerVolumeEntity> pricePerVolumeList;

}
