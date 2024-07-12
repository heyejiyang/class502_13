package org.choongang.member.controllers;

import lombok.Data;

@Data
public class Address {
    private String zipCode; //우편번호
    private String address; //주소1
    private String addressSub; //주소2
}
