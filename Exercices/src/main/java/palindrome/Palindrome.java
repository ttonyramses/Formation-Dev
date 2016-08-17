package palindrome;

public class Palindrome {

	public static String inverse(String s){
		StringBuffer sr=new StringBuffer();
		for(int i=s.length()-1;i>=0;i--){
			sr=sr.append(s.charAt(i));
		}
		
		return sr.toString();
	}
	
	public static boolean isPalindrome(String s){
		return s.equals(inverse(s));
	}
}
