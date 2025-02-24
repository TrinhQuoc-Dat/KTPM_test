
import com.tqd.testunit.DemoTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class TestSuite01 {
    
    @Test
    public void testEvenNumber(){
        Assertions.assertTrue(DemoTest.isSoNT(2));
    }
    
    
    @Test
    public void testOddNumber(){
        Assertions.assertFalse(DemoTest.isSoNT(4));
    }
    
    @Test
    public void testException(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            DemoTest.isSoNT(-7);
        });
    }
    
    
    
    
    
}
