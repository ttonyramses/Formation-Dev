package palindrome;

public class EssaiPalindrome {

	public static void main(String[] args) {
		
		String s=args[0];
		System.out.println("l'inverse de "+s+" est "+Palindrome.inverse(s));
		if(Palindrome.isPalindrome(s)){
			System.out.println(s+" est un palindrome");
		}else{
			System.out.println(s+" n'est pas un palindrome");
		}

	}

}
