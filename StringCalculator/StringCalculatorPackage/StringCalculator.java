package StringCalculatorPackage;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	public int add(String input) {
    	if (input.isEmpty()) {
            return 0;
        } 
    	else  {
    		String[] nums= manupulate(input);  
    		ArrayList<Integer> negative = getNegative(nums);
            if(negative.size()>0)
            {
                 throw new RuntimeException("Negatives found: "+negative);
            }
    		return getSummation(nums);
    	
        }
    }
   
   
    private static String[] manupulate(String input) {
   
        if(input.startsWith("//")) {
        	
        	if(input.startsWith("//["))
        	{
        		int ClosingBracketIndex=input.indexOf(']');
        		String deleminatorgiven = input.substring(3,ClosingBracketIndex );
        		String numbers=input.substring(ClosingBracketIndex+2);
        		return numbers.split(Pattern.quote(deleminatorgiven));
        	}
        	
            Matcher x=Pattern.compile("//(.)\n(.*)").matcher(input);
            x.matches();
            String deleminatorgiven =x.group(1);
            String numbers=x.group(2);
            return numbers.split(deleminatorgiven);
       }
       String[] nums= input.split(",|\n");
       return nums;
    }
    
    private ArrayList<Integer> getNegative(String[] nums) {
        ArrayList<Integer> negative = new ArrayList<Integer>();
           
            for (String x:nums) {
               
                if(Integer.parseInt(x)<0)
                {
                negative.add(Integer.parseInt(x));
                }
               
            }
            return negative;
        }
   
   
    private int getSummation(String[] nums) {
        int sum = 0;
        for (String currentNumber:nums) {
        	if(Integer.parseInt(currentNumber)>1000)continue;
            sum += Integer.parseInt(currentNumber);
        }
        return sum;
    }
   
   
}