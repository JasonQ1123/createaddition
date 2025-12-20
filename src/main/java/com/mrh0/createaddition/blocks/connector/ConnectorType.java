package com.mrh0.createaddition.blocks.connector;


public enum ConnectorType {
    Small("small"),
    Superconducting("superconducting"),
    Large("large");

    public final String name;

    ConnectorType(String name) {
        this.name = name;
    }
}
