package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	//Testum tóman streng
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	//Testum hvort add fallið sé að skila réttu með einni tölu
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(5, Calculator.add("5"));
	}

	@Test
	//Testum hvort add fallið sé að skila réttu með tveimur tölu
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(8, Calculator.add("4,4"));
	}	
	@Test
	//Testum hvort add fallið sé að skila réttu með fleiri en tveimur tölum
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    	assertEquals(15, Calculator.add("1,2,3,4,5"));
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    //Prófum add fallið með 7 tölum
	public void testSevenNumbers() {
		assertEquals(174, Calculator.add("2,8,7,9,3,22,123"));
	}

	@Test
	//Breytum add fallinu þannig það ráði við new line
	//Ræður við new lines milli talna í staðin fyrir kommur
	//“1\n2,3” á að skila 6
		public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
		assertEquals(10, Calculator.add("1,2\n3\n4"));
	}	
	@Test
	//Prófum add fallið með 7 tölum
	public void testMultipleNewLine() {
		assertEquals(37, Calculator.add("1\n6\n4\n9\n3\n1,5\n8"));
	}
	@Test
	//Breytum add fallinu þannig það ráði við delimiter
	public void testHashtagDelimiter() {
		assertEquals(6, Calculator.add("//#\n2#4"));
	}

	@Test
	//Athugum að delimiter virki eins og það á að gera
	public void testDelimiter(){
		assertEquals(13, Calculator.add("//;\n1;2;6\n4"));
	}

	@Test
	//Einnig fyrir Semi kommur
	//“//;\n1;2” á að skila 3 (Þar sem delimiter er ;) 
	public void testSemiCommaDelimiter(){
		assertEquals(16, Calculator.add("//;;5,5;5,1"));
	}

	@Test
	//Breytum þannig að neikvæðar tölur eru ekki leyfðar
	//“2,-4,3,-5” á að henda villu “Negatives not allowed: -4,-5”
	//Verðum að búa til try/catch block til að grípa error-exeption sem er hent
	public void testNegativeNumbers() {
		try {
			Calculator.add("-56,6");
		} 
		catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	//Tölur stærri en 1000 hunsum við
	//“1001,2” á til dæmis að skila 2
	public void testLargeInts() {
		assertEquals(2, Calculator.add("1001,2"));
		assertEquals(4, Calculator.add("2001,4"));
		assertEquals(8, Calculator.add("3001,8"));
	}


}
