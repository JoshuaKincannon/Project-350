import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Creates and starts the game where it keeps track of the players and the decks.
 * @author Jhoseph
 */
public class Game {

    //Keeps track of whose turn it is
    private int currentPlayer;

    //String array of names of the players
    private String[] playerIds;
    
    //The deck that the players are playing with
    private UnoDeck deck;

    //Every player's hands are track within this arraylist of arraylist of players hands
    private ArrayList<ArrayList<UnoCard>> playerHand;

    //Stockpile for when players put down cards 
    private ArrayList<UnoCard> stockpile;

    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    //Clockwise or either counter clockwise
    boolean gameDirection;

    public int score;

    /**
     * Creates the game
     * @param pids 
     */
    public Game(String[] pids) {
        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList<UnoCard>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;
        
        playerHand = new ArrayList<ArrayList<UnoCard>>();

        //Fill up each hand with Uno cards
        for(int i = 0; i < pids.length; i++) {
            
            //Creates a hand and fills it with the deck class with 7 cards
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));

            //Once created, add that hand to all the players hands tracker
            playerHand.add(hand);
        }
    }

    /**
     * Void method that takes in a game and starts it
     * @param game 
     */
    public void start(Game game) {

        //Draw a card start the game
        UnoCard card = deck.drawCard();

        //Finds out what color can be play next
        validColor = card.getColor();

        //Finds out what value is
        validValue = card.getValue();

        if(card.getValue() == UnoCard.Value.Wild) {
            start(game);
        }

        if(card.getValue() == UnoCard.Value.Wild_Four || card.getValue() == UnoCard.Value.DrawTwo) {
            start(game);
        }

        if(card.getValue() == UnoCard.Value.Skip) {
            JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            if(gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }
            else if (gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if(currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
        }
        if(card.getValue() == UnoCard.Value.Reverse) {
            JLabel message = new JLabel(playerIds[currentPlayer] + " The game direction changed!");
            message.setFont(new Font("Arial", Font.BOLD, 48));
            JOptionPane.showMessageDialog(null, message);

            //^= means XOR operand. Flips game direction to the opposite value. If true becomes false, if false becomes true. 
            gameDirection ^= true;
            currentPlayer = playerIds.length - 1;
        }
        stockpile.add(card);
    }

    /**
     * Turns top card with a valid color and value
     * @return UnoCard
     */
    public UnoCard getTopCard() {
        return new UnoCard(validColor, validValue);
    }

    /**
     * Returns the card image
     * @return 
     */
    public ImageIcon getTopCardImage() {
        return new ImageIcon(validColor + "_" + validValue + ".png");
    }

    /**
     * Checks if game is over
     * @return true or false
     */
    public boolean isGameOver() {
        for (String player : this.playerIds) {

            //If player has an empty card
            if(hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the current player
     * @return playerIds
     */
    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }

    /**
     * Gets previous player
     * @param i
     * @return playerIds
     */
    public String getPreviousPlayer(int i) {
        int index = this.currentPlayer - i;
        if(index == -1) {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }

    /**
     * Returns all the players
     * @return playerIds
     */
    public String[] getPlayers() {
        return playerIds;
    }

    /**
     * Returns player's hand
     * @param pid
     * @return playerHand
     */
    public ArrayList<UnoCard> getPlayerHand(String pid) {
        int index = Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }

    /**
     * Find the size of a player's hand
     * @param pid
     * @return size
     */
    public int getPlayerHandSize(String pid) {
        return getPlayerHand(pid).size();
    }

    /**
     * Finds a particular hand in a player's hand
     * @param pid
     * @param choice
     * @return hand
     */
    public UnoCard getPlayerCard(String pid, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(pid);
        return hand.get(choice);
    }

    /**
     * Checks if hand is empty
     * @param pid
     * @return true or false
     */
    public boolean hasEmptyHand(String pid) {
        return getPlayerHand(pid).isEmpty();
    }

    /**
     * Checks if card is a valid play
     * @param card
     * @return true or false
     */
    public boolean validCardPlay(UnoCard card) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    /**
     * Check if the current player is the correct player's turn
     * @param pid
     * @throws InvalidPlayerTurnException 
     */
    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if(this.playerIds[this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("It is not " + pid + " 's turn", pid);
        }
    }

    /**
     * Submits draw depending if the deck is empty or player's hand
     * @param pid
     * @throws InvalidPlayerTurnException 
     */
    public void submitDraw(String pid) throws InvalidPlayerTurnException {
        checkPlayerTurn(pid);
        if(deck.isEmpty()) {
            deck.replaceDeckWith(stockpile);
            deck.shuffle();
        }

        getPlayerHand(pid).add(deck.drawCard());
        if(gameDirection == false) {
            currentPlayer = (currentPlayer + 1) % playerIds.length;
        }
        else if(gameDirection == true) {
            currentPlayer = (currentPlayer - 1) % playerIds.length;
            if(currentPlayer == -1) {
                currentPlayer = playerIds.length - 1;
            }
        }
    }

    /**
     * Sets card color
     * @param color 
     */
    public void setCardColor(UnoCard.Color color) {
        validColor = color;
    }

    /**
     * Submits player card
     * @param pid
     * @param card
     * @param declaredColor
     * @throws InvalidColorSubmissionException
     * @throws InvalidValueSubmissionException
     * @throws InvalidPlayerTurnException 
     */
    public void submitPlayerCard(String pid, UnoCard card, UnoCard.Color declaredColor) 
        throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
            checkPlayerTurn(pid);

            ArrayList<UnoCard> pHand = getPlayerHand(pid);
            if(!validCardPlay(card)) {
                //If it is a wild card
                if(card.getColor() == UnoCard.Color.Wild) {
                    validColor = card.getColor();
                    validValue = card.getValue();
                }

                //set actual = card.getColor();


                if(card.getColor() != validColor) {
                    JLabel message = new JLabel("Invalid player move, expected color: " + validColor + ", but got color: " + card.getColor());
                    message.setFont(new Font("Arial", Font.BOLD, 24));
                    JOptionPane.showMessageDialog(null, message);
                    throw new InvalidColorSubmissionException("Invalid player move, expected color: " + validColor + " but got color: " + card.getColor(), card.getColor(), validColor);
                }
                else if(card.getValue() != validValue) {
                    JLabel message2 = new JLabel("Invalid player move, expected value: " + validValue + ", but got value " + card.getValue());
                    message2.setFont(new Font("Arial", Font.BOLD, 24));
                    JOptionPane.showMessageDialog(null, message2);
                    throw new InvalidValueSubmissionException("Invalid player move, expected value: " + validValue + ", but got value: " + card.getValue(), card.getValue(), validValue);
                }
            }

            pHand.remove(card);
            if(hasEmptyHand(this.playerIds[currentPlayer])) {
                String winnerName = this.playerIds[currentPlayer];
                
                JLabel message2 = new JLabel(winnerName + " won the game! Thank you for playing!");
                message2.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message2);
                System.exit(0);  
            }

            validColor = card.getColor();
            validValue = card.getValue();
            stockpile.add(card);

            if(gameDirection == false) {
                currentPlayer = (currentPlayer + 1) % playerIds.length;
            }
            else if(gameDirection == true) {
                currentPlayer = (currentPlayer - 1) % playerIds.length;
                if(currentPlayer == -1) {
                    currentPlayer = playerIds.length - 1;
                }
            }
            if(card.getColor() == UnoCard.Color.Wild) {
                validColor = declaredColor;
            }
            if(card.getValue() == UnoCard.Value.DrawTwo) {
                pid = playerIds[currentPlayer];
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                JLabel message = new JLabel(pid + " drew 2 cards!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
            }
            if(card.getValue() == UnoCard.Value.Wild_Four) {
                pid = playerIds[currentPlayer];
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                JLabel message = new JLabel(pid + " drew 4 cards!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
            }
            if(card.getValue() == UnoCard.Value.Skip) {
                JLabel message = new JLabel(playerIds[currentPlayer] + " was skipped!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);
                if(gameDirection ==false) {
                    currentPlayer = (currentPlayer + 1) % playerIds.length;
                }

                else if(gameDirection == true) {
                    currentPlayer = (currentPlayer - 1) % playerIds.length;
                    if(currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                }
            }
            if(card.getValue() == UnoCard.Value.Reverse) {
                JLabel message = new JLabel(pid + " changed the game direction!");
                message.setFont(new Font("Arial", Font.BOLD, 48));
                JOptionPane.showMessageDialog(null, message);

                gameDirection ^= true;
                if(gameDirection == true) {
                    currentPlayer = currentPlayer - 2 % playerIds.length;
                    if(currentPlayer == -1) {
                        currentPlayer = playerIds.length - 1;
                    }
                    if(currentPlayer == -2) {
                        currentPlayer = playerIds.length - 2;
                    }
                }
                else if(gameDirection == false) {
                    currentPlayer = (currentPlayer + 2) % playerIds.length;
                }
            }

    }

    private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/**
 * Handles Invalid Player Turn
 * @author Jhoseph
 */
class InvalidPlayerTurnException extends Exception {
    String playerId;
    
    public InvalidPlayerTurnException(String message, String pid) {
        super(message);
        playerId = pid;
    }
    public String getPid() {
        return playerId;
    }
}

/**
 * Handles Invalid Color Submission
 * @author Jhoseph
 */
class InvalidColorSubmissionException extends Exception {
    private UnoCard.Color expected;
    private UnoCard.Color actual;

    public InvalidColorSubmissionException(String message, UnoCard.Color actual, UnoCard.Color expected) {
        this.actual = actual;
        this.expected = expected;
    }
}

/**
 * Handles InvalidValueSumbission
 * @author Jhoseph
 */
class InvalidValueSubmissionException extends Exception {
    private UnoCard.Value expected;
    private UnoCard.Value actual;

    public InvalidValueSubmissionException(String message, UnoCard.Value actual, UnoCard.Value expected) {
        this.actual = actual;
        this.expected = expected;
    }
}


