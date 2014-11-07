import java.util.Scanner;

public class FracCalc {	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		p("I'm FracCalc, Give me an input");
		while(true){
			String input = scanner.nextLine();
			if(input.equals("quit")){
				p("ok bye");
				break;
			}else{
				String operator = input.substring(input.indexOf(" "), input.indexOf(" ")+2);
				String firstPart = input.substring(0 , input.indexOf(" "));
				String secondPart = input.substring(input.indexOf(operator)+3, input.length());
				
				//converts firstPart from a Mixed Number to an improper Fraction
				String firstPartNotMixed = mixedNumberToImproper(firstPart);
				String secondPartNotMixed = mixedNumberToImproper(secondPart);
				
				System.out.println("You asked me to calculate " + firstPartNotMixed + operator + " " + secondPartNotMixed);
			}
		}
	}

	public static void p(String s){
		System.out.println(s);
	}
	
	//converts firstPart from a Mixed Number to an improper Fraction
	public static String mixedNumberToImproper(String s){
		if (s.contains("_")){
			int firstUnderscorePosition = s.indexOf("_");
			
			//first number before fraction
			String firstMixedNumberString = s.substring(0 , firstUnderscorePosition);
			int firstMixedNumber = Integer.parseInt(firstMixedNumberString);
			
			//numerator for first number
			String firstNumeratorString = s.substring(firstUnderscorePosition + 1, s.indexOf("/"));
			int firstNumerator = Integer.parseInt(firstNumeratorString);
			
			//denominator for first number
			String firstDenominatorString = s.substring(s.indexOf("/")+1 , s.length());
			int firstDenominator = Integer.parseInt(firstDenominatorString);
			
			//Multiplies the whole number portion by the denominator and changes the "firstPart" so it is an improper fraction 
			firstNumerator = ((firstMixedNumber * firstDenominator) + firstNumerator);
			s = (firstNumerator + "/" + firstDenominator);
			return s;
		}else{
			return s;
		}
	}
}