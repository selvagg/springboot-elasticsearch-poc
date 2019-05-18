package com.scrapbook.documents;

import com.scrapbook.enums.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "bank", type = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long account_number;
    private Double balance;
    private String firstname;
    private String lastname;
    private Integer age;
    private Gender gender;
    private String address;
    private String employer;
    private String email;
    private String city;
    private String state;

    public Long getAccount_number() {
        return account_number;
    }

    public Account setAccount_number(Long account_number) {
        this.account_number = account_number;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public Account setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Account setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Account setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Account setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Account setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Account setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmployer() {
        return employer;
    }

    public Account setEmployer(String employer) {
        this.employer = employer;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Account setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Account setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Account setState(String state) {
        this.state = state;
        return this;
    }


}
