import java.util.Scanner;

public class FracCalc {	
	
	public static int productNumerator = 0;
	public static int productDenominator = 0;
	public static int productWholePart = 0;
	public static boolean error = false;
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		p("I'm FracCalc, type expressions with fractions and I will evaluate them.");
		p("\"quit\" to exit.");
		while(true){
			error = false;
			String input = scanner.nextLine();
			if(input.toLowerCase().contains("quit")){
				p("Thanks for using FracCalc!");
				scanner.close();
				break;
			}else{
				String operator = "";
				String firstPart = "";
				String secondPart = "";
				if(input.indexOf(" ") != -1){
					operator = input.substring(input.indexOf(" ")+1, input.indexOf(" ")+2);
					
					firstPart = input.substring(0 , input.indexOf(" "));
					
					secondPart = input.substring(input.indexOf(" ")+3, input.length());
				}else{
					error = true;				
				}
				int firstNumerator = 0;
				int firstDenominator = 0;
				int secondNumerator = 0;
				int secondDenominator = 0;
				
				
				//Finds parts of an inputed mixed number
				if (firstPart.contains("_")){
					//finds first number before underscore
					int firstUnderscorePosition = firstPart.indexOf("_");				
					int firstWholeNumber = firstMixedNumber(firstPart, firstUnderscorePosition);
					
					//finds first denominator
					firstDenominator = denominator(firstPart);
					
					//finds first numerator
					firstNumerator = numerator(firstPart, firstUnderscorePosition, firstWholeNumber, firstDenominator);
					
					//(below) if firstPart does not contain a whole number part, but still is a fraction
				}else if(firstPart.contains("/")){
					
					//finds first numerator
					firstNumerator = fractionNumerator(firstPart);
					
					//finds first Denominator
					firstDenominator = fractionDenominator(firstPart);
				}else {
					
					firstNumerator = parsing(firstPart);
					firstDenominator = 1;
				}
				
				//does same as above, but with second part
				if (secondPart.contains("_")){
					int secondUnderscorePosition = secondPart.indexOf("_");
					//---------------------------------------------finds values of secondPart
					int secondWholeNumber = firstMixedNumber(secondPart, secondUnderscorePosition);				
					
					//finds second denominator
					secondDenominator = denominator(secondPart);
					
					//finds second numerator
					secondNumerator = numerator(secondPart, secondUnderscorePosition, secondWholeNumber, secondDenominator);
					//---------------------------------------------finds values of secondPart
					
					secondPart = mixedNumberToImproperFraction(secondWholeNumber, secondNumerator, secondDenominator);
					
				}else if(secondPart.contains("/")){
					
					//finds second numerator
					secondNumerator = fractionNumerator(secondPart);
					
					//finds second Denominator
					secondDenominator = fractionDenominator(secondPart);
				}else {
					
					secondNumerator = parsing(secondPart);
					secondDenominator = 1;
				}
				
				//checks which operator the user inputed and completes equation
				
				if (operator.equals("+")){
					addition(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
					
				}else if(operator.equals("-")){
					subtraction(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
					
				}else if(operator.equals("*")){
					multiplication(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
					
				}else if(operator.equals("/")){
					division(firstNumerator, firstDenominator, secondNumerator, secondDenominator);
					
				}else{
					p("not a valid operator");					
				}
				reduce();
			}
		}
	} 
	
	//easy println method
	public static void p(String s){
		System.out.println(s);
	}
	
	//-----------------------------------------------------------------------------------------Mixed Number Pieces
	//finds whole number before underscore for either first or second part
	public static int firstMixedNumber(String s, int UnderscorePosition){
		String MixedNumberString = s.substring(0 , UnderscorePosition);
		int MixedNumber = parsing(MixedNumberString);
		return MixedNumber;
	}
	
	//finds numerator
	public static int numerator(String s, int underscorePosition, int wholeNumber, int denominator){
		String firstNumeratorString = s.substring(underscorePosition + 1, s.indexOf("/"));
		int firstNumerator = parsing(firstNumeratorString);
		
		int x = denominator * wholeNumber;
		
		firstNumerator += x;
		return firstNumerator;
	}
	
	//finds denominator
	public static int denominator(String s){
		String denominatorString = s.substring(s.indexOf("/")+1 , s.length());
		int denominator = parsing(denominatorString);
		return denominator;
	}
	//-----------------------------------------------------------------------------------------Mixed Number Pieces
	
	//=========================================================================================Fraction Pieces
	//finds numerator
	public static int fractionNumerator(String fraction){
		String numeratorString = fraction.substring(0, fraction.indexOf("/"));
		int numeratorInt = parsing(numeratorString);
		return numeratorInt;
	}
	
	public static int fractionDenominator(String fraction){
		String denominatorString = fraction.substring(fraction.indexOf("/")+1, fraction.length());
		int denominatorInt = parsing(denominatorString);
		return denominatorInt;
	}
	
	
	//=========================================================================================Fraction Pieces

	public static String mixedNumberToImproperFraction(int wholeNumber, int numerator, int denominator){
		int x = wholeNumber*denominator;
		numerator = numerator + x;
		String improperFraction = numerator + "/" + denominator;
		return improperFraction;
	}
	
	//checks to see if Input is parseable, then parses it if so.
	public static int parsing(String s){
		Scanner parser = new Scanner(s);
		
		if (parser.hasNextInt()){
			
			return parser.nextInt();
			
		}
		
		error = true;
		
		return 1;
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Operations
	//it adds bro
	public static void addition(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator){		
		int newFirstNumerator = firstNumerator * secondDenominator;
		int newSecondNumerator = secondNumerator * firstDenominator;
		
		productDenominator = firstDenominator * secondDenominator;
		productNumerator = newFirstNumerator + newSecondNumerator;
	}
	
	public static void subtraction(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator){
		int newFirstNumerator = firstNumerator * secondDenominator;
		int newSecondNumerator = secondNumerator * firstDenominator;
		
		productDenominator = firstDenominator * secondDenominator;
		productNumerator = newFirstNumerator - newSecondNumerator;		
	}
	
	public static void multiplication(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator){
		productDenominator = firstDenominator * secondDenominator;
		productNumerator = firstNumerator * secondNumerator;	
	}
	
	public static void division(int firstNumerator, int firstDenominator, int secondNumerator, int secondDenominator){
		productDenominator = firstDenominator * secondNumerator;
		productNumerator = firstNumerator * secondDenominator;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Operations
	
	
	public static void reduce(){
		
		int gcdizzle = gcd(productNumerator, productDenominator);
		if (!error){
			productNumerator /= gcdizzle;
			productDenominator /= gcdizzle;
		}
		if(productDenominator != 0){
			productWholePart = productNumerator / productDenominator;
			productNumerator %= productDenominator;
		}else{
			error = true;
			
		}
		
		
		if(productDenominator < 0 && productWholePart == 0){
			productDenominator *= -1;
			
			productNumerator *= -1;
		}else if (productDenominator < 0){
			
			productDenominator *= -1;
			
			productNumerator = Math.abs(productNumerator);
		}
			
		if (!error){
			if(productWholePart == 0 && productNumerator == 0){
				System.out.println("= 0");
			}else if(productWholePart == 0){
				System.out.println("= " + productNumerator + "/" + productDenominator);
			}else if(productNumerator == 0){		
				System.out.println("= " + productWholePart);
			}else{
				System.out.println("= " + productWholePart + "_" + productNumerator + "/" + productDenominator);		
			}
		}else{
			p("There was totes an error");
			
		}
	}
	
	public static int gcd(int a, int b){
		int t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;			
		}
		return a;
	}
}
