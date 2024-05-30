package com.nsv.examples.spring.boot.data.jdbc.ex.service;

import com.nsv.examples.spring.boot.data.jdbc.ex.data.entity.ClientQuoteEntity;
import com.nsv.examples.spring.boot.data.jdbc.ex.data.repository.ClientQuoteJdbcRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientQuoteDataService {

    private final ClientQuoteJdbcRepository clientQuoteJdbcRepository;

    @Transactional
    public void saveToDb(ClientQuoteEntity quote) {
        try {
            clientQuoteJdbcRepository.save(quote);
            log.trace("QuoteEntity {} has been saved to DB", quote);
        } catch (OptimisticLockingFailureException e) {
            // Обработка исключения
            throw new RuntimeException("Optimistic lock exception: " + e.getMessage());
        }

    }

}
