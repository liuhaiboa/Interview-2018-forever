package javabase;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author haibo
 * @date 19-9-20
 */
public class BigDecimalTest {
    private BigDecimal num1=new BigDecimal(0.005);
    private BigDecimal str1=new BigDecimal("0.005");
    private BigDecimal num2=new BigDecimal(1000000);
    private BigDecimal str2=new BigDecimal("1000000");
    @Test
    public void test(){
        BigDecimal addNum = num1.add(num2);
        BigDecimal addStr = str1.add(str2);
        BigDecimal subNum = num1.subtract(num2);
        BigDecimal subStr = str1.subtract(str2);
        System.out.println("addNum::::::"+addNum);
        System.out.println("addStr::::::"+addStr);
        System.out.println("subNum::::::"+subNum);
        System.out.println("subStr::::::"+subStr);
        //除法
        BigDecimal result = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
        BigDecimal resultS = str2.divide(str1,20,BigDecimal.ROUND_HALF_UP);
        System.out.println("result:::::"+result);
        System.out.println("resultS::::"+resultS);
    }
}
