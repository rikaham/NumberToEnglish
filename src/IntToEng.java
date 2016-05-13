
import java.util.Scanner;

public class IntToEng {

	static String[] firstNumber = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] secondNumber = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] thirdNumber = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(translateEng(input));

    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	
    	int i = n % 10;
    	int j = n / 10;
    	
    	if (n == 0) {
    		return "zero";
    	} else if (j == 0) {
    		return firstNumber[i -1];
    	} else if (j == 1) {
    		return secondNumber[i];
    	} else if (i == 0) {
    		return thirdNumber[j - 2];
    	} else {
    		return thirdNumber[j - 2] + " " + firstNumber[i - 1];
    	}

	}

}
