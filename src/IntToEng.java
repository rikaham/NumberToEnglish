
import java.util.Scanner;

public class IntToEng {

	static String[] firstNumber = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
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
    	int k = n / 100;
    	int l = n % 100;
    	int m = n / 1000;
    	
    	if (n == 0) {
    		return "zero";
    	} else if (j == 0) {
    		return firstNumber[i];
    	} else if (j == 1) {
    		return secondNumber[i];
    	} else if(j >= 2 && j <= 9){
    		return thirdNumber[j - 2] + " " + firstNumber[i];
    	} else if(j >= 10 && j <= 99){
    		if(j % 10 == 0){
    			return firstNumber[k] + "hundred "+firstNumber[i];
    		} else if(j % 10 == 1){
    			return firstNumber[k] + "hundred "+secondNumber[i];
    		} else {
    			return firstNumber[k] + "hundred "+thirdNumber[l / 10 - 2]+" "+firstNumber[i];
    		}
    	} else if (j >= 100) {
    		/*if (j % 10 == 0) {
    			return firstNumber[m] + "thousand " + firstNumber[i];
    		} else if (j % 10 == 1) {
    			return firstNumber[m] + "thousand " + secondNumber[i];
    		} else if(j % 10 == 0){
    			return firstNumber[k] + "hundred "+firstNumber[i];
    		} else if(j % 10 == 1){
    			return firstNumber[k] + "hundred "+secondNumber[i];
    		} else {
    			return firstNumber[k] + "hundred "+thirdNumber[l / 10 - 2]+" "+firstNumber[i];
    		}*/
    		if(k % 10 == 0){
    			if (j % 10 == 0) {
        			return firstNumber[m] + "thousand " + firstNumber[i];
        		} else if (j % 10 == 1) {
        			return firstNumber[m] + "thousand " + secondNumber[i];
        		} else {
        			return firstNumber[m] + "thousand "+thirdNumber[l / 10 - 2]+" "+firstNumber[i];
        		}//100の位が０の時
    			
    		} else {
    			if (m == 1) {
    				if(l / 10 == 0){
    					return secondNumber[k%10]+"hundred " + firstNumber[i];
    				} else if(l / 10 == 1){
    					return secondNumber[k%10]+"hundred " + secondNumber[i];
    				} else {
    					return secondNumber[k%10]+"hundred " + secondNumber[i];//ここ変える
    				}
    			} else if(m >= 2 && m <= 9){
    				return thirdNumber[m - 2] + "hundred " + firstNumber[k];
    			}
    		}
    		 
    	}
    	
    	return "";
	}

}
