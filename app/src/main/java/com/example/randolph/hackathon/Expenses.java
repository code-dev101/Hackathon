package com.example.randolph.hackathon;

/**
 * Created by Conan on 10/12/2016.
 */

import java.util.HashMap;

public class Expenses {
    private String category;
<<<<<<< HEAD
    private float salary;
    private float _percentage;

    public void initializedCompute(String ctg, float _percent){
//        HashMap <String, Float>hashMap = new HashMap<String, Float>;
        this.category =ctg;
        this._percentage = _percent;
//        hashMap.put(category, _percentage);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getSalary() {
        return salary;
    }
=======
    private double salary, total;
    private int _percentage;
>>>>>>> 7822bc4af474315ec5a9b60e970ae7a6e401d440

    public void initializedCompute(String ctg, int _percent){
        HashMap <String, Integer> hm = new HashMap<>();
        hm.put("food",20);
    }
    public void compute(){
        total = (double)(salary - (salary * _percentage));
    }
}
