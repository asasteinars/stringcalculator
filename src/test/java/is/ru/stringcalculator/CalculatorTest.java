package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(8, Calculator.add("4,4"));
	}	
	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(15, Calculator.add("1,2,3,4,5"));
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
	public void testSevenNumbers() {
		assertEquals(174, Calculator.add("2,8,7,9,3,22,123"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
		assertEquals(10, Calculator.add("1,2\n3\n4"));
	}	
	@Test
	public void testMultipleNewLine() {
		assertEquals(37, Calculator.add("1\n6\n4\n9\n3\n1,5\n8"));
	}
	@Test
	public void testHashtagDelimiter() {
		assertEquals(6, Calculator.add("//#\n2#4"));
	}

}