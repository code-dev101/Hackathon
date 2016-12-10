package com.example.randolph.hackathon;

/**
 * Created by Conan on 10/12/2016.
 */

import java.util.HashMap;

public class Expenses {
    private String category;
    private double salary, total;
    private int _percentage;

    public void initializedCompute(String ctg, int _percent){
        HashMap <String, Integer> hm = new HashMap<>();
        hm.put("food",20);
    }
    public void compute(){
        total = (double)(salary - (salary * _percentage));
    }
}
