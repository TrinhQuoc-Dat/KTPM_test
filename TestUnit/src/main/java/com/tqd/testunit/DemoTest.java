/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.testunit;

import java.time.Duration;

/**
 *
 * @author admin
 */
public class DemoTest {
    public static boolean isSoNT(int n) {
        if (n <= 0 ) throw new ArithmeticException();
        if(n < 2) return false;
        for (int i = 2; i<= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
