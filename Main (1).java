/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
	public static void main(String[] args) 
	{
	    String[] salesmen = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack", "Karen", "Leo", "Mona", "Nina", "Oscar", "Paul", "Quinn", "Rita", "Steve", "Tina"};
	    Random random = new Random();
	    Map<String, Integer> salesmenRevenue = new HashMap<>();
	    
	    for(String salesman : salesmen)
	    {
	        salesmenRevenue.put(salesman, random.nextInt(1001));
	    }
	    
	    System.out.println("These are the salesmen, and their revenue, for this company");
	    
	    for(String salesman : salesmen)
	    {
	        System.out.println(salesman + ": " + salesmenRevenue.get(salesman));
	    }
	    
	    List<String> sortedSalesmen = new ArrayList<>(Arrays.asList(salesmen));
	    sortedSalesmen.sort((s1, s2) -> salesmenRevenue.get(s2) - salesmenRevenue.get(s1));
	    
	    System.out.println("The top 5 salesmen are: ");
	    for(int i =0; i<5 && i<sortedSalesmen.size(); i++)
	    {
	        String salesman = sortedSalesmen.get(i);
	        System.out.println(salesman + ": " + salesmenRevenue.get(salesman));
	    }
	    
	} 
}
