package com.springboot.sessionprac2.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
    private String name;
    private int age;
    private String email;
    private String address;
    @JsonProperty("phone_number")
    private String phoneNumber;


    public Member(String name, int age, String email, String address, String phone_number) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phoneNumber = phone_number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
