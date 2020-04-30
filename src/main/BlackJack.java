import java.util.*;

public class BlackJack
{
	public static List<Integer> deck = new ArrayList<Integer>();

	public static void main (String [] args)
    {
    	new BlackJack().play();
	}

   private void play()
   {
    	boolean keepPlaying = true;

		System.out.println("Welcome to Blackjack!");
	    
	    while (keepPlaying)
	    {
	    	deck.clear();
	    	for (int i = 0; i < 52; i++){
	    		deck.add(i, i%13 + 1);
			}

			int cardId1 = deal();	//card id (1-13)
			int cardId2 = deal();
			int cardId3 = deal();
			int cardId4 = deal();

			System.out.printf("Your cards are %s and %s. The dealer's cards are %s and %s.\n",faceValue(a),faceValue(b),faceValue(c),faceValue(d));
			int playerCards = cardValue(cardId1) + cardValue(cardId2);
			int dealerCards = cardValue(cardId3) + cardValue(cardId4);
			
			playerCards = computePlayerCards(playerCards);
			if (playerCards <= 21) 
				dealerCards = computeDealerCards(dealerCards);
			
			winner(playerCards, dealerCards);
			keepPlaying = playAgain();
		}   	
   }

   private static boolean playAgain()
   {
   		Scanner console = new Scanner(System.in);
		boolean play = true;
		boolean invalidAnswer = true;

		while (invalidAnswer)
		{
			System.out.println("Do you want to play again? (Y/N)");
	   		String n = console.nextLine();

	   		if (n.equalsIgnoreCase("y"))
	   		{
	   			play = true;
	   			invalidAnswer = false;
	   		}
	   		else if (n.equalsIgnoreCase("n"))
	   		{
	   			play = false;
	   			invalidAnswer = false;
	   		}
	   	}

	   	return play;
   	}

   	//winner determines who won
   	private static void winner(int playerCards, int dealerCards)
   	{
   		if (playerCards > 21)
			System.out.println("You busted!\nDealer Wins!");
		else if (dealerCards > 21 || playerCards > dealerCards)
			System.out.println("You Win!");
		else // (dealerCards >= playerCards)
			System.out.println("Dealer Wins!");
   	}

   	//returns the index of a card in the deck
   	private static int deal()
    {
   		return deck.remove((int)(Math.random()*deck.size()));
    }
   
   	//dealer logic for when to hit or stand
   	//returns the sum of the dealers cards at the end of his turn
   	private static int computeDealerCards(int dealerCards)
   	{
		boolean play = true;

		while (play)
		{
			if (dealerCards < 17)
			{
				int e = 1 + (int)(Math.random()*13);
				System.out.printf("Dealer Hits. Dealer draws a %s.\n",faceValue(e));
				dealerCards += cardValue(e);
				play=true;
			}
			else if (dealerCards > 21) {
				System.out.println("Dealer Busted!");
				play=false;
			}
			else
			{
				System.out.println("Dealer Stands");
				play=false;
			}
		}
		return dealerCards;
   	}

   	private static int computePlayerCards(int playerCards)
   	{
   		boolean play = true;
        Scanner console = new Scanner(System.in);

		while(play)
		{
			System.out.println("Hit or Stand? (h/s)");
			String n = console.nextLine();

			if (n.equalsIgnoreCase("H"))
			{
				int e= 1 + (int)(Math.random()*13);
				System.out.printf("Your card is %s.\n",faceValue(e));
				playerCards += cardValue(e);
				play=true;
			}
			else if (n.equalsIgnoreCase("S"))
				play=false; 
			else
			{
				System.out.println("Invalid Answer. Try Again.");
				play=true;
			}

			if (playerCards > 21) {
				return playerCards;
			}
		}

		return playerCards;
	}
   
   public static String faceValue(int n)
   {
   	if (n==1)
		return "A";
	if (n>1 && n<=10)
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
