import java.util.*;
public class BlackJack
{
    public static void main (String [] args)
    {
        Scanner console = new Scanner(System.in);
        boolean play = true;
	String n = "";

	while (play)
	{	
		System.out.println("Welcome to Blackjack! \nWant to play? (Y / N)");
        	n = console.nextLine();
	
		if (n.equals("Y") || n.equals("y"))
			play=false;
		else if (n.equals("N") || n.equals("n"))
		{
			System.out.println("Goodbye");
			play=false;
		}
		else
		{
			System.out.println("Invalid Answer. Try again.");
			play=true;
		}
	}

	int a= (int)(Math.random()*13) + 1;
	int b= (int)(Math.random()*13) + 1;
	int c= (int)(Math.random()*13) + 1;
	int d= (int)(Math.random()*13) + 1;
	int e=0;

	System.out.printf("Your cards are %s and %s. The dealer's card are %s and %s.",faceValue(a),faceValue(b),faceValue(c),faceValue(d));
	int yourCards = cardValue(a)+cardValue(b);
	int myCards = cardValue(c)+cardValue(d);
	play=true;
	
	while(play)
	{
		System.out.println(" Hit or Stand?");
		n = console.nextLine();

		if (n.equals("Hit") || n.equals("hit"))
		{
			e= 1 + (int)(Math.random()*13);
			System.out.printf("Your card is %s.",faceValue(e));
			yourCards += cardValue(e);
			play=true;
		}
		else if (n.equals("Stand") || n.equals("stand"))
			play=false; 
		else
		{
			System.out.println("Invalid Answer. Try Again.");
			play=true;
		}
	}
	play=true;
	while (play)
	{
		if (myCards < 16)
		{
			e = 1 + (int)(Math.random()*13);
			System.out.printf("Dealer Hits. Dealer draws a %s. ",faceValue(e));
			myCards += cardValue(e);
			play=true;
		}
		if (myCards > 21)
			System.out.print("Dealer Busted!");
		else
		{
			System.out.println("Dealer Stands");
			play=false;
		}
	}
	
	if (yourCards > 21)
		System.out.println("You busted! Dealer Wins!");
	else if (myCards > 21 || yourCards > myCards)
		System.out.println("You Win!");
	else if (myCards > yourCards)
		System.out.println("Dealer Wins!");
	else
		System.out.println("It's a tie!");
   }
   public static String faceValue(int n)
   {
   	if (n==1)
		return "A";
	if (n>1 & n<=10)
		return Integer.toString(n);
	if (n==11)
		return "J";
	if (n==12)
		return "Q";
	else // (n==13)
		return "K";
   }
   public static int cardValue(int n)
   {
   	if (n<=10)
	return n;
	else
	return 10;
   }
}
