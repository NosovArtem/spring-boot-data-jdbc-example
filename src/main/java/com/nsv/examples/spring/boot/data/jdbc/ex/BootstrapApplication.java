package com.nsv.examples.spring.boot.data.jdbc.ex;

import com.nsv.examples.spring.boot.data.jdbc.ex.data.entity.ClientQuoteEntity;
import com.nsv.examples.spring.boot.data.jdbc.ex.data.entity.PricePerVolumeEntity;
import com.nsv.examples.spring.boot.data.jdbc.ex.service.ClientQuoteDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class BootstrapApplication {
    @Autowired
    ClientQuoteDataService clientQuoteDataService;

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {

        PricePerVolumeEntity b1 = PricePerVolumeEntity.builder()
                .uuid(UUID.randomUUID().toString())
                .clientQuoteId("clientQuoteId")
                .bid(BigDecimal.valueOf(10))
                .ask(BigDecimal.valueOf(11))
                .minVolume(BigDecimal.valueOf(0))
                .maxVolume(BigDecimal.valueOf(1_000))
                .build();

        PricePerVolumeEntity b2 = PricePerVolumeEntity.builder()
                .uuid(UUID.randomUUID().toString())
                .clientQuoteId("clientQuoteId")
                .bid(BigDecimal.valueOf(100))
                .ask(BigDecimal.valueOf(110))
                .minVolume(BigDecimal.valueOf(1_000))
                .maxVolume(BigDecimal.valueOf(1_000_000))
                .build();

        ClientQuoteEntity a = ClientQuoteEntity.builder()
                .uuid("clientQuoteId")
                .marketQuoteId("marketQuoteId")
                .tradeRuleId("tradeRuleId")
                .symbol("USD/RUB")
                .pricePerVolumeList(Arrays.asList(b1, b2))
                .dateTime(OffsetDateTime.now())
                .build();

        System.out.println();
        clientQuoteDataService.saveToDb(a);
    }

}
