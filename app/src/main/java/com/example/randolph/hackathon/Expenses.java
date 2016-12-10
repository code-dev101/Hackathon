package com.example.randolph.hackathon;

/**
 * Created by Conan on 10/12/2016.
 */

import java.util.HashMap;
public class Expenses {
    private String category;
    private float salary;
    private float _percentage;

    public void initializedCompute(String ctg, float _percent){
        HashMap <String, Float>hashMap = new HashMap<String, Float>;
        this.category =ctg;
        this._percentage = _percent;
        hashMap.put(category, _percentage);
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

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float get_percentage() {
        return _percentage;
    }

    public void set_percentage(float _percentage) {
        this._percentage = _percentage;
    }
}
