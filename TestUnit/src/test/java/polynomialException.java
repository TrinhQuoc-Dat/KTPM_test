
import com.tqd.testunit.Polynomial;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
public class polynomialException {
    
    @ParameterizedTest
    @CsvFileSource(resources = "polynomialException.csv", numLinesToSkip = 1)
    public void testException(int n, String cef, int x){
        List<Integer> cefs;
        cefs = Arrays.stream(cef.split("#"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Assertions.assertThrows(ArrayStoreException.class, () ->{
            Polynomial p = new Polynomial(n, cefs);
            p.cal(x);
                });
    }
}
