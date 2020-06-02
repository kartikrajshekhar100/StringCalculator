package StringCalculatorPackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public int add(String input) {
    	if (input.isEmpty()) {
            return 0;
        } 
    	else  {
    		String[] nums= manupulate(input);  
    		return getSummation(nums);
    	
        }
    }
   
   
    private static String[] manupulate(String input) {
   
        if(input.startsWith("//")) {
            Matcher x=Pattern.compile("//(.)\n(.*)").matcher(input);
            x.matches();
            String deleminatorgiven =x.group(1);
            String numbers=x.group(2);
            return numbers.split(deleminatorgiven);
       }
       String[] nums= input.split(",|\n");
       return nums;
    }
   
   
    private int getSummation(String[] nums) {
        int sum = 0;
        for (String currentNumber:nums) {
            sum += Integer.parseInt(currentNumber);
        }
        return sum;
    }
   
   
}