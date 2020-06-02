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
        	input=input.substring(2);
        	
        	if(input.charAt(0)=='[')
        	{
        		int ClosingBracketIndex;
        		String deleminatorgiven;
        		int part=input.indexOf('\n');
        		String numbers=input.substring(part+1);
        		while(input.charAt(0)!='\n')
        		{
        			ClosingBracketIndex=input.indexOf(']');
        			deleminatorgiven = input.substring(1,ClosingBracketIndex);
        			numbers=numbers.replaceAll(deleminatorgiven , ",");
        			input=input.substring(ClosingBracketIndex+1);
        			
        		}
        		String[] nums=numbers.split(",");
        		return nums;
        	}
        	
            Matcher x=Pattern.compile("(.*)\n(.*)").matcher(input);
            x.matches();
            String deleminatorgiven =x.group(1);
            String numbers=x.group(2);
            return numbers.split(Pattern.quote(deleminatorgiven));
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
