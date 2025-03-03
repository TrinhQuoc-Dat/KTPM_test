/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.testunit;

import java.util.List;

/**
 *
 * @author PHAT
 */
public class Polynomial {

    private int n;
    private List<Integer> a;

    public Polynomial(int n, List<Integer> a) {
        if (a.size() != n + 1) {
            throw new ArrayStoreException("Invalid Data");
        }
        this.n = n;
        this.a = a;
    }

    public int cal(double x) {
        int result = 0;
        for (int i = 0; i <= this.n; i++) {
            result += (int)(a.get(i) * Math.pow(x, i));
        }
        return result;
    }

   
}
