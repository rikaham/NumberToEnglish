
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
    		return "zero";//数字が０の時
    	} else if (j == 0) {
    		return firstNumber[i];//数字が０以外の一桁の時
    	} else if (j == 1) {
    		return secondNumber[i];//数字が１０から１９の時
    	} else if(j >= 2 && j <= 9){
    		return thirdNumber[j - 2] + " " + firstNumber[i];//数字が２０から９９の時
    	} else if(j >= 10 && j <= 99){
    		if(j % 10 == 0){
    			return firstNumber[k] + "hundred "+firstNumber[i];//3桁の数字で１０の位が０の時
    		} else if(j % 10 == 1){
    			return firstNumber[k] + "hundred "+secondNumber[i];//３桁の数字で１０の位が１の時
    		} else {
    			return firstNumber[k] + "hundred "+thirdNumber[l / 10 - 2]+" "+firstNumber[i];//３桁の数字で１０の位が２から９の時
    		}
    	} else if (j >= 100) {
    		if(k % 10 == 0){
    			if (j % 10 == 0) {
        			return firstNumber[m] + "thousand " + firstNumber[i];//4桁の数字で１００の位と１０の位が０の時
        		} else if (j % 10 == 1) {
        			return firstNumber[m] + "thousand " + secondNumber[i];//４桁の数字で１００の位が０かつ１０の位が１の時
        		} else {
        			return firstNumber[m] + "thousand "+thirdNumber[l / 10 - 2]+" "+firstNumber[i];//４桁の数字で１００の位が０かつ１０の位が２から９の時
        		}
    			
    		} else {
    			if (m == 1) {
    				if(l / 10 == 0){
    					return secondNumber[k%10]+"hundred " + firstNumber[i];//４桁の数字で１０００の位が１で１０の位が０の時
    				} else if(l / 10 == 1){
    					return secondNumber[k%10]+"hundred " + secondNumber[i];//４桁の数字で１０００の位が１で１０の位が１の時
    				} else {
    					return secondNumber[k%10]+"hundred " + thirdNumber[l / 10 - 2] + " " + firstNumber[i];//４桁の数字で１０００の位が１で１０の位が２から９
    				}
    			} else {
    				if (j % 10 == 0) {
    					return thirdNumber[m - 2] + " " + firstNumber[k % 10] + "hundred " + firstNumber[i];//４桁の数字で１０００の位が２から９で１０の位が０の時
    				} else if (j % 10 == 1) {
    					return thirdNumber[m - 2] + " " + firstNumber[k % 10] + "hundred " + secondNumber[i];//４桁の数字で１０００の位が２から９で１０の位が1の時
    				} else {
    					return thirdNumber[m - 2] + " " + firstNumber[k % 10] + "hundred " + thirdNumber[l / 10 - 2] + " " + firstNumber[i];//４桁の数字で１０００の位が２から９で１０の位が２から９の時
    				}
    			}
    		}
    	}
    	return "";
    }
 }
    	


