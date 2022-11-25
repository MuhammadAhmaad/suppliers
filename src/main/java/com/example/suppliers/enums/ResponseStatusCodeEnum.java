/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.suppliers.enums;


public enum ResponseStatusCodeEnum {

    SUCCESS(200),
    FAILED(-200);

    private final int Value;

    public int getValue() {
        return Value;
    }

    private ResponseStatusCodeEnum(int value) {
        this.Value = value;
    }
}
