import java.util.Scanner;
import java.lang.NumberFormatException;

public class FigureInWords {
	
	public static final String[] mutiples = {" "," hundred", " thousand", " million",
	    " billion"," trillion", " quadrillion", " quintillion"
	};

	public static final String[] tens = { " ", " ten", " twenty"," thirty"," forty"," fifty",
	    " sixty"," seventy"," eighty"," ninety"
	};
	
	public static final String[] units = {" "," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten",
	    " eleven", " twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"
	};

	public static String sayBillion(int numberBillion){
		int million = numberBillion % 1000000000;
		int billion = (int)(numberBillion/1000000000);
		if (numberBillion >= 1000000000)
		 	return sayHundred(billion)  + "" +mutiples[4]+ " " +sayMillion(million);
		else
			return sayThousand(million);
	}

	public static String sayMillion(int numberMillion){
		int thousand = numberMillion % 1000000;
		int million = (int)(numberMillion/1000000);
		if (numberMillion >= 1000000)
		 	return sayHundred(million)  + "" +mutiples[3]+ " " +sayThousand(thousand);
		else
			return sayThousand(thousand);
	}


	public static String sayThousand(int numberThousand){
		int hundred = numberThousand % 1000;
		int thousand = (int)(numberThousand / 1000);
		if (numberThousand >= 1000)
		 	return sayHundred(thousand) + "" + mutiples[2] + " " +sayHundred(hundred);
		else
			return sayHundred(hundred);
    }

	public static String sayHundred(int numberHundred) {
		int ten = numberHundred % 100;
		int hundred = (int)(numberHundred / 100);
		if (numberHundred >= 100)
		 	return sayUnit(hundred)+ "" + mutiples[1] + " and " + sayTen(ten);
		else
			return  sayTen(ten);
    }

	public static String sayTen(int numberTen) {
		if (numberTen >= 10 && numberTen < 20){
			return sayUnit(numberTen);
		}
		else {
			int unit = numberTen % 10;
			int ten = (int)(numberTen / 10);
			return tens[ten] + " " + sayUnit(unit);
		}

	}
	
	public static String sayUnit(int numberUnit) {
		return units[numberUnit];
	}
	
 	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	boolean condition = true;

		while(condition){
			System.out.print("Enter a number to convert to words (or 'done' to quit): ");
	 		String numEntered = in.nextLine();

	 		// this will test if pure Number was entered or alphanumeric
	 		if (numEntered.matches("[0-9]+")){
	 			try{
	 			   int numberToInteger = Integer.parseInt(numEntered);
	 			   System.out.println(sayMillion(numberToInteger)); 
				}
	 			catch(NumberFormatException e){
	 				 System.out.println("number not within Integer range"); 
	 			}
	 		}
	 		else if (numEntered.matches("\\-([0-9]+)")){
	 			try{
	 			   numEntered = numEntered.replaceAll("\\-([0-9]+)","$1" );
	 				int numberToInteger = Integer.parseInt(numEntered);
	 				System.out.println("negative "+ sayMillion(numberToInteger)); 
				}
				catch(NumberFormatException e){
	 				 System.out.println("number not within Integer range"); 
	 			}
	 			
	 		}
	 		else if(numEntered.equals("done")){
	 			System.out.println("Thank you for using our service"); 
	 			condition = false;
	 		}
	 		else{
	 			System.out.println("You entered a wrong value"); 
	 			condition = false;
	 		}
	 	}
		
  	}
	

}
