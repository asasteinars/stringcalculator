package is.ru.stringcalculator;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		
		String delimiter = ",|\n";
		if(text.isEmpty()){ return 0; }
		if(text.length() == 1){ return toInt(text); }
		if(text.startsWith(";") || text.startsWith("\n")){
			text = text.substring(1);
		}
		else if(text.startsWith("//")){
			delimiter = ",|\n" + "|";
			delimiter = delimiter + text.substring(text.indexOf("//") + 2, text.indexOf("//") + 3);
			text = text.substring((text.indexOf("//") + 4));
		}
		return sum(splitNumbers(text, delimiter));
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
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