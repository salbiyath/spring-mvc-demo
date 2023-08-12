package com.salbiyath.springmvcdemo.util;

public class RandomNumber {

    public static Long getRandom(long min, long max){
        return min + (long) (Math.random() * (max-min));
    }

}
