package palindrome;


import java.util.Scanner;
public class EssaiPalindromeBis {

	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		try{
			System.out.print("Veuillez entrer votre chaine de caractère : ");
			String s=sc.nextLine();
			String sTr=s.replace(" ", "");
			
			System.out.println("\""+sTr+"\"");
			
			if(Palindrome.isPalindrome(sTr)){
				System.out.println("\""+s+"\" est un palindrome");
			}else{
				System.out.println("\""+s+"\" n'est pas un palindrome");
			}
		}
		finally
		{
			sc.close();
		}
		

	}

}
