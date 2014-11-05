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
			}else if(){
				String firstPart = input.substring(0 , input.indexOf(" "));
				String secondPart = input.substring(input.indexOf(" "), input.length());
				int firstNumber = firstPart.nextInt();
				System.out.println(firstPart + " + " + secondPart);
			}else{
				p("Give me a number.");
			}
		}
	}
	
	public static void p(String s){
		System.out.println(s);
	}
}
