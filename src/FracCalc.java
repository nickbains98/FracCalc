
import java.util.Scanner;

public class FracCalc {	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		p("HEY, me frekcalc. you human... probably. gimmie an input boss.");
		while(true){
			String input = scanner.next();
			if(input.equals("quit")){
				p("ok bye");
				break;
			}else{
				p("nope. stahp. give me a number, even though I can only quit");
			}
		}
	}
	
	public static void p(String s){
		System.out.println(s);
	}
}
