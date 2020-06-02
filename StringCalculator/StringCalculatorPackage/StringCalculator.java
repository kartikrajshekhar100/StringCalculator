package StringCalculatorPackage;

public class StringCalculator {
    public int add(String input) {
    	if (input.isEmpty()) {
            return 0;
        } 
    	else if (input.contains(",")) {
    		String[] nums=input.split(",");
    		return Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
    	}
    	else {
            return Integer.parseInt(input);
        }
    }
}
