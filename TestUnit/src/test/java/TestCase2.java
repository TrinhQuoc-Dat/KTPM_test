
import com.tqd.testunit.DemoTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author admin
 */
public class TestCase2 {

    @BeforeAll
    public static void setUpClass() {
        System.out.print("Before Test");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.print("AfterAll Test");
    }

    @BeforeEach
    public void setUp() {
        System.out.print("Before Each Test");

    }

    @AfterEach
    public void tearDown() {
        System.out.print("After Each Test");

    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10, 250})
    public void testEven(int n) {
        Assertions.assertFalse(DemoTest.isSoNT(n));
    }

    @ParameterizedTest
    @CsvSource({"5,5", "10,A", "15,F", "1,1"})
    public void testRadix1(int n, String expected) {
        Radix r = new Radix(16);
        Assertions.assertEquals(expected, r.ConvertDecimalToAnother(n));
    }

    @ParameterizedTest
    @CsvSource({"5,'101'", "10,'1010'", "15,'1111'", "1,'1'"})
    public void testRadix2(int n, String expected) {
        Radix r = new Radix(2);
        Assertions.assertEquals(expected, r.ConvertDecimalToAnother(n));
    }
}
