
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;
    //java 폴더에 CustomCalculator를 테스트 하기위해 인스턴스를 선언

    //더하기 테스트
    @Test
    public void addTest() {
        customCalculator = new CustomCalculator();
        //테스트함수를 독립적으로 실행하기에 함수 내부에서 인스턴스를 객체화 시켜줘야함.
        int result = customCalculator.add(10, 15);
        assertTrue(result == 25);
        System.out.println("result :: " + result);
    }

    //빼기 테스트
    @Test
    public void subTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23, 10);
        assertTrue(result == 13);
        System.out.println("result :: " + result);
    }

    //곱하기 테스트
    @Test
    public void mulTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5, 9);
        assertTrue(result == 45);
        System.out.println("result :: " + result);
    }

    //나누기 테스트
    @Test
    public void divTest() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25, 5);
        assertTrue(result == 5);
        System.out.println("result :: " + result);
    }
}