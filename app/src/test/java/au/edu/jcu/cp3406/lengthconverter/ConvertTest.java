package au.edu.jcu.cp3406.lengthconverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConvertTest {
    @Test
    public void testCalculation(){
      String fromUnit = "Centimeter";
      String toUnit = "Millimeter";
      double amount = 1.0;

      double result = Convert.calculation(fromUnit, toUnit, amount);
      assertEquals(10.0, result, 1);
  }
}
