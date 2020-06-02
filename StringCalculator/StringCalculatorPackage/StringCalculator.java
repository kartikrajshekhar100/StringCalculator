package StringCalculatorPackage;

public class StringCalculator {
    public int add(String input) {
    	if (input.isEmpty()) {
            return 0;
        } 
    	else if (input.contains(",")) {
    		String[] nums=input.split(",");
    		return getSummation(nums);
    	}
    	else {
            return Integer.parseInt(input);
        }
    }
    
    private int getSummation(String[] nums) {
        int sum = 0;
        for (String currentNumber:nums) {
            sum += Integer.parseInt(currentNumber);
        }
        return sum;
    }
}