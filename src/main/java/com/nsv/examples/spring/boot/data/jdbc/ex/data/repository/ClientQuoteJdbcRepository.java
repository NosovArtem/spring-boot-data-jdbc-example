package com.nsv.examples.spring.boot.data.jdbc.ex.data.repository;

import com.nsv.examples.spring.boot.data.jdbc.ex.data.entity.ClientQuoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientQuoteJdbcRepository extends CrudRepository<ClientQuoteEntity, String> {

}
