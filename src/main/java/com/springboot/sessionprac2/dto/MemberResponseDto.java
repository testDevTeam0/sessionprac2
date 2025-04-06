package com.springboot.sessionprac2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberResponseDto {

    private String name;
    private String email;
    private int age;
    private String address;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public MemberResponseDto(String name, String email, int age, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}




