//package linkedLists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class CardGame {

    private static LinkList cardList = new LinkList();  // make list

    // Method to draw a card and add it to the player's hand
    public static void drawCard(Card[] playerHand, LinkList cardList, int index) {
        // Get the first card in the deck and remove it from the deck
        Card drawnCard = cardList.getFirst();  // Draw the first card from the deck
        playerHand[index] = drawnCard;         // Add the drawn card to the player's hand at the given index
        System.out.println("Player draws: " + drawnCard);  // Display the card drawn
    }

    // Method to shuffle the deck
    public static void shuffleDeck(LinkList cardList) {
        ArrayList<Card> cardArray = new ArrayList<>();
        
        // Move all the cards from the linked list to the array list
        Link current = cardList.getFirstLink();  // Use getFirstLink() here to access the first link
        while (current != null) {
            cardArray.add(current.cardLink);
            current = current.next;
        }
        
        // Shuffle the array list
        Collections.shuffle(cardArray);

        // Clear the current deck and reinsert shuffled cards
        cardList.clear();  // Fixed: manually clear the list (set first to null)
        for (Card card : cardArray) {
            cardList.add(card);
        }
    }

    // Method to calculate the total value of the player's hand
    public static int calculateHandValue(Card[] playerHand) {
        int totalValue = 0;  // Variable to store the total value of the hand
        for (Card card : playerHand) {
            if (card != null) {
                totalValue += card.getCardValue();  // Add the value of each card to the total
            }
        }
        return totalValue;  // Return the total value of the hand
    }

    public static void main(String[] args) {
        // File name to read the cards from
        String fileName = "cards.txt";  // Ensure the file is in the working directory or provide the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");  //  Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();  
                    String name = details[1].trim(); 
                    int value = Integer.parseInt(details[2].trim());  
                    String pic = details[3].trim();  

                    // Create a new Card object 
                    Card card = new Card(suit, name, value, pic);

                    // Add the card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);  
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());  
        }

        // Shuffle the deck before dealing cards
        shuffleDeck(cardList);

        // Print the loaded cards (initial deck after shuffling)
        System.out.println("Cards loaded and shuffled:");
        //cardList.displayList();

        // Create an array to hold the player's hand
        Card[] playerHand = new Card[5];  // Assuming the player draws 5 cards

        // Draw 5 cards for the player, ensuring each card is unique
        for (int i = 0; i < playerHand.length; i++) {
            drawCard(playerHand, cardList, i);  // Draw a card and add it to the player's hand
        }

        // Display the player's hand
       // System.out.println("\nPlayer's hand:");
       // for (int i = 0; i < playerHand.length; i++) {
       //     System.out.println(playerHand[i]);  // Print the card in the player's hand
        //}

        // Calculate the total value of the player's hand
        int totalValue = calculateHandValue(playerHand);

        // Display the total value of the hand
        System.out.println("\nTotal value of player's hand: " + totalValue);

        // Display the remaining deck (after drawing cards)
        //System.out.println("\nRemaining deck:");
        //cardList.displayList();
    }
}
