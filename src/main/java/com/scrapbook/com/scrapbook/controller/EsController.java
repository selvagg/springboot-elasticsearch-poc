package com.scrapbook.com.scrapbook.controller;

import com.scrapbook.com.scrapbook.documents.Account;
import com.scrapbook.com.scrapbook.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EsController {

    @Autowired
    AccountsRepository  accountsRepository;

    @GetMapping(name = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Account>> test(){
       return ResponseEntity.ok(accountsRepository.findAll(PageRequest.of(0,5)));
    }
}
