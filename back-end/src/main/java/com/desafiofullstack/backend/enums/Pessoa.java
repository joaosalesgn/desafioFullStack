package com.desafiofullstack.backend.enums;

public enum Pessoa {
    FISICA("Fisica"), JURIDICA("Juridica");

    private String value;

    private Pessoa(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
