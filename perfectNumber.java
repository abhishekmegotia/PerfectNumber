import java.util.Scanner;
 class perfectNumber {

	public static void main(String[] args) {

		System.out.println("Please Enter the low range : ");
		int low = new Scanner(System.in).nextInt();
		System.out.println("Please Enter the high range : ");
		int high = new Scanner(System.in).nextInt();
	String num;	
	        while(low<high)
	        	{
	        	num=(nextSmallestPalindrom(low));
	        	int number=Integer.parseInt(num);
	        	if (isSquareRootPalindrome(number)) {
					System.out.println(number);
				}
			low=number;}
		}
	
	 



	private static String nextSmallestPalindrom(int numberToProcess) {

		String num="";
	    int i, j,z;
	    String temp = Integer.toString(numberToProcess);
	    int[] number = new int[temp.length()];
	    for ( z = 0; z < temp.length(); z++)
	    {
	    	number[z] = temp.charAt(z) - '0';
	    }
	    
	    
	    boolean all9 = true;
	    for (int k = 0; k < z; k++) {
	        if (number[k] != 9) {
	            all9 = false;
	            break;
	        }
	    }
	   
	    if (all9) {
	        num=whenAll9(z);
	        return num;
	    }

	    int mid = z / 2;
	    if (z % 2 == 0) {
	        i = mid - 1;
	        j = mid;
	    } else {
	        i = mid - 1;
	        j = mid + 1;
	    }

	    while (i >= 0 && number[i] == number[j]) {
	        i--;
	        j++;
	    }
	   
	    if (i == -1) {
	        if (z % 2 == 0) {
	            i = mid - 1;
	            j = mid;
	        } else {
	            i = mid;
	            j = i;
	        }
	        num=addOneToMiddleWithCarry(number, i, j, true);

	    } else {
	        if (number[i] > number[j]) { 

	            while (i >= 0) {
	                number[j] = number[i];
	                i--;
	                j++;
	            }
	            for (int k = 0; k < number.length; k++)
	            	 num=num.concat(String.valueOf(number[k]));
	        } else {
	            if (z % 2 == 0) {
	                i = mid - 1;
	                j = mid;
	            } else {
	                i = mid;
	                j = i;
	            }
	            num=addOneToMiddleWithCarry(number, i, j, false);
	        }
	    }
	    return num;
	}

	@SuppressWarnings("static-access")
	private static String whenAll9(int length) {
		String num="";
		int a;
	    for (int i = 0; i <= length; i++) {
	        num=num.concat("9");
	    }
	        a=Integer.parseInt(num);
	        a+=2;
	        num=num.valueOf(a);
	    return num;	
	   	}

	private static String addOneToMiddleWithCarry(int[] number, int i,
	        int j, boolean palindrom) {
	    String num="";
		number[i]++;
	    number[j] = number[i];
	    while (number[i] == 10) {
	        number[i] = 0;
	        number[j] = number[i];
	        i--;
	        j++;
	        number[i]++;
	        number[j] = number[i];
	    }

	    if (!palindrom)
	       while (i >= 0) {
	            number[j] = number[i];
	            i--;
	            j++;
	        }

	    for (int k = 0; k < number.length; k++)
	        num=num.concat(String.valueOf(number[k]));
	    return num;
	}
	public static boolean isPalindrome(double number) {
		int palindrome = (int)number; 
		int reverse = 0;

		while (palindrome != 0) {
			int remainder = palindrome % 10;
			reverse = reverse * 10 + remainder;
			palindrome = palindrome / 10;
		}

		if (number == reverse) {
			return true;
		}
		return false;
	}

	public static boolean isSquareRootPalindrome(int number) {

		double num =  Math.sqrt(number);
		if (isPalindrome(num)) {
			return true;
		}
		return false;

	}
}