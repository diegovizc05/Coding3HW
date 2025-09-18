package driver;
import java.util.HashSet; 

public class Main {

	public static void main(String[] args)
	{
		String str = "The football team lost the game against a better team";
		System.out.println(checkUnique(str));
		String text= "The train, the car, the house";
		System.out.println("Occurence of 'the': " + numberOfOccurences(text, "the"));
	}
		
		public static boolean checkUnique(String str)
		{
			HashSet<Character> isUnique = new HashSet<>();
			
			for(int i = 0; i < str.length(); i++)
			{
				char c = str.charAt(i);
				if(!isUnique.add(c))
				{
					return false;
				}
			}
			return true;
		}
		
		public static int numberOfOccurences(String text, String word)
		{
			if(text == null || word == null || text.isEmpty())
			{
				return 0;
			}
			String[] words = text.split("\\s+");
			int count = 0;
			
			for(String w : words)
			{
				if(word.equals(w))
				{
					count++;
				}
			}
			return count;
		}

	
}

