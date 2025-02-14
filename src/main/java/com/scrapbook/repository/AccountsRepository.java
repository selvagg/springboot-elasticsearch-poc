package com.scrapbook.repository;

import com.scrapbook.documents.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends ElasticsearchRepository<Account, Long> {
}
