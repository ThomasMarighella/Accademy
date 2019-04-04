package com.company;

public class SpaceExeededException extends Exception {
    private String msg;
    public SpaceExeededException(String msg){
        this.msg=msg;
    }
    public String toString (){
        return "Space exeeded: "+msg;
    }
}
