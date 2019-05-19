package com.scrapbook.controller;

import com.scrapbook.documents.Account;
import com.scrapbook.repository.AccountsRepository;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

import static org.springframework.util.StringUtils.commaDelimitedListToStringArray;

@RestController
@RequestMapping("/bank")
public class EsController {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    RestHighLevelClient client;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Account>> getAccounts(@PageableDefault(size = 10, page = 0) Pageable page) {
        return ResponseEntity.ok(accountsRepository.findAll(page));
    }

    @GetMapping(value = "/account/{account_number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable("account_number") Long account_number) {
        return ResponseEntity.ok(accountsRepository.findById(account_number));
    }

    @GetMapping(value = "/accounts/search/{param}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MultiSearchResponse> getMultimatchResults(@PageableDefault(size = 10, page = 0) Pageable page,
                                                                    @PathVariable("param") Long param) throws IOException {

        MultiSearchRequest multiSearchRequest = new MultiSearchRequest();
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(param, commaDelimitedListToStringArray("age,account_number,balance")));
        searchRequest.source(searchSourceBuilder);
        multiSearchRequest.add(searchRequest);

        return ResponseEntity.ok(client.msearch(multiSearchRequest, RequestOptions.DEFAULT));
    }
}
