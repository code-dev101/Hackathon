package com.example.randolph.hackathon;

/**
 * Created by Conan on 10/12/2016.
 */

import java.util.HashMap;
public class Expenses {
    private String category;
    private double salary;
    private float _percentage;

    public void initializedCompute(String ctg, float _percent){
        HashMap <String, Float>hashMap = new HashMap<String, Float>();
        this.category =ctg;
        this._percentage = _percent;
        category = "food";
        _percentage = (float) .40;
        setSalary(4000.00);
        hashMap.put(category, _percentage);
    }

    public void compute(){
        float total = (float) (salary - (salary * _percentage));
        System.out.println(total);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float get_percentage() {
        return _percentage;
    }

    public void set_percentage(float _percentage) {
        this._percentage = _percentage;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
