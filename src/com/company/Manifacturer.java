package com.company;

public enum Manifacturer {
    FIAT("car"),
    DUCATI("bike"),
    IVECO("truck"),
    RALLY("rally car");
    private String category;

    public String getCat(){
        return category;
    }

    Manifacturer(String s) {
        this.category=s;
    }

}
