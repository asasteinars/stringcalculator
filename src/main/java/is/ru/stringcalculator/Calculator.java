package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){

		String delimiter = "(,)|(\n)";
		String newDelimiter = "//";
		if(text.isEmpty()){ return 0; } //Ef strengurinn er tómur
		if(text.length() == 1){ return toInt(text); } //Ef strengurinn er ein tala/Án delimiter
		if(text.startsWith(";") || text.startsWith("\n")){//Fjarlægjum delimiter ef hann er fremst í strengnum
			text = text.substring(1);
		}
		else if(text.startsWith(newDelimiter)){ //Finna í hvaða sæti delimiterinn er
			delimiter = "(,)|(\n)" + "|";//Skeyta honum við upprunarlega
			delimiter = delimiter + text.substring(text.indexOf(newDelimiter) + 2, text.indexOf(newDelimiter) + 3);
			text = text.substring((text.indexOf(newDelimiter) + 4));
		}
		return sum(splitNumbers(text, delimiter));
	}

	private static int toInt(String number){

		int newNumber = Integer.parseInt(number);
		if(newNumber <= 1000) { //Leyfum ekki tölur yfir 1000. 
				return newNumber; //Hunsum þær og skilum minni tölunni
		}
		else if(newNumber < 0) { //Leyfum ekki mínustölur
			negativeNumber(newNumber);//Ef þetta er mínustala hendum við villu
		} 
		return 0;//Annars skilum við bara tölunni
	}

	private static int negativeNumber(int number) {
		throw new RuntimeException("Negatives not allowed!: " + number); //prentar villuskilaboð ásamt neikvæðu tölunni
	}

	private static String[] splitNumbers(String text, String delimiter){
		return text.split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}