package com.scrapbook.controller;

import com.scrapbook.documents.Account;
import com.scrapbook.repository.AccountsRepository;
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

import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class EsController {

    @Autowired
    AccountsRepository accountsRepository;

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Account>> getAccounts(@PageableDefault (size = 10, page = 0) Pageable page) {
        return ResponseEntity.ok(accountsRepository.findAll(page));
    }

    @GetMapping(value = "/account/{account_number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Account>> getAccount(@PathVariable("account_number") Long account_number) {
        return ResponseEntity.ok(accountsRepository.findById(account_number));
    }



}
