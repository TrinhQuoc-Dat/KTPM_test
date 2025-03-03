
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
public class TestRadix {
    
    @ParameterizedTest
    @CsvFileSource(resources = "radix.csv", numLinesToSkip = 1)
    public void testRadix(int n, int radix, String expected){
        Radix r = new Radix(n);
        Assertions.assertEquals(expected, r.ConvertDecimalToAnother(radix));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "radixException.csv", numLinesToSkip = 1)
    public void testRadixException(int n, int radix){
        Assertions.assertThrows(ArithmeticException.class, () ->{ 
            Radix r = new Radix(n);
            r.ConvertDecimalToAnother(radix);
            });
        
    }
}
