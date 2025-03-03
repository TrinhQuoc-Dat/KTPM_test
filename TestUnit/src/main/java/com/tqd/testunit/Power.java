/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.testunit;

/**
 *
 * @author PHAT
 */
public class Power {
    public static double power(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n > 0) {
            return x * Math.pow(x, n - 1);
        } else {
            return Math.pow(x, n + 1) / x;
        }
    }
}
