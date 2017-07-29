package com.example.adam.calculator;

/**
 * Created by adam on 29.07.17.
 */

enum Operation {

    NONE(""), ADD("+"), SUBSTRACT("-");

    private final String key;

    private Operation(String key) {

        this.key = key;
    }

    public static Operation operationFromKey(String key) {

        for (Operation operation : values()) {
            if(operation.key.equals(key)) {
                return operation;
            }
        }

        return NONE;

    }

}
