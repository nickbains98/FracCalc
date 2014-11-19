import java.util.Scanner;

public class FracCalc {	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		p("I'm FracCalc, type expressions with fractions and I will evaluate them.");
		p("\"quit\" to exit.");
		while(true){
			String input = scanner.nextLine();
			if(input.toLowerCase().contains("quit")){
				p("Thanks for using FracCalc!");
				break;
			}else{
				String operator = input.substring(input.indexOf(" ")+1, input.indexOf(" ")+2);
				
				String firstPart = input.substring(0 , input.indexOf(" "));
				
				String secondPart = input.substring(input.indexOf(operator)+2, input.length());
				
				
				//converts Parts from Mixed Numbers to an improper Fractions
				String firstPartNotMixed = mixedNumberToImproper(firstPart);
				String secondPartNotMixed = mixedNumberToImproper(secondPart);				
				
				//checks which operator the user inputed and completes equation
				String product = "";
				if (operator.equals("+")){
					 product = addition(firstPartNotMixed, secondPartNotMixed);					
					 
				}
				System.out.println(product);
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
			return s + "/1";
		}
	}
	
	public static String addition(String a, String b){
		String firstDenominatorString = a.substring(a.indexOf("/")+1 , a.length());
		int firstDenominator = Integer.parseInt(firstDenominatorString);
		
		String secondDenominatorString = b.substring(b.indexOf("/")+1 , b.length());
		int secondDenominator = Integer.parseInt(secondDenominatorString);
		
		int newDenominator = firstDenominator * secondDenominator;
		
		String firstNumeratorString = a.substring(0, a.indexOf("/"));
		int firstNumerator = Integer.parseInt(firstNumeratorString);
		
		String secondNumeratorString = b.substring(0, b.indexOf("/"));
		int secondNumerator = Integer.parseInt(secondNumeratorString);
		
		int newFirstNumerator = firstNumerator*secondDenominator;
		int newSecondNumerator = secondNumerator*firstDenominator;
		
		int newFinalNumerator= newSecondNumerator + newFirstNumerator;
		
		return "" + newFinalNumerator + "/" + newDenominator;
	}
	
}
