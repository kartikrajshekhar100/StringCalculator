package StringCalculatorPackage;

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