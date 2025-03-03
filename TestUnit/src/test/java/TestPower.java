
import com.tqd.testunit.Power;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PHAT
 */
public class TestPower {
    
    @ParameterizedTest
    @CsvFileSource(resources = "power.csv", numLinesToSkip = 1)
    public void testPower(double x, int n, double expected){
        double actual = Power.power(x, n);
        Assertions.assertEquals(actual, expected);
    }
}
