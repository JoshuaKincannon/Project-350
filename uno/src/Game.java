import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Game {

    //Keeps track of whose turn it is
    private int currentPlayer;

    //String array of names of the players
    private String[] playerIds;
    
    //The deck that the players are playing with
    private UnoDeck deck;

    //Every player's hands are truck within this arraylist of arraylist of players hands
    private ArrayList<ArrayList<UnoCard>> playerHand;

    //Stockpile for when players put down cards 
    private ArrayList<UnoCard> stockpile;

    private UnoCard.Color validColor;
    private UnoCard.Value validValue;

    //Clockwise or either counter clockwise
    boolean gameDirection;

    //Creates the game
    public Game(String[] pids) {
        deck = new UnoDeck();
        deck.shuffle();
        stockpile = new ArrayList<UnoCard>();

        playerIds = pids;
        currentPlayer = 0;
        gameDirection = false;
        
        playerHand = new ArrayList<ArrayList<UnoCard>>();

        for(int i = 0; i < pids.length; i++) {
            
            //Creates a hand and fills it with the deck class with 7 cards
            ArrayList<UnoCard> hand = new ArrayList<UnoCard>(Arrays.asList(deck.drawCard(7)));

            //Once created, add that hand to all the players hands tracker
            playerHand.add(hand);
        }
    }

    //Void method that takes in the game
    public void start(Game game) {

        //Draw a card
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

    //Turns top card with a valid color and value
    public UnoCard getTopCard() {
        return new UnoCard(validColor, validValue);
    }

    //Returns the card image
    public ImageIcon getTopCardImage() {
        return new ImageIcon(validColor + "-" + validValue + ".png");
    }

    //Checks if game is over
    public boolean isGameOver() {
        for (String player : this.playerIds) {

            //If player has an empty card
            if(hasEmptyHand(player)) {
                return true;
            }
        }
        return false;
    }

    //Gets the current player
    public String getCurrentPlayer() {
        return this.playerIds[this.currentPlayer];
    }

    //Gets previous player
    public String getPreviousPlayer(int i) {
        int index = this.currentPlayer - i;
        if(index == -1) {
            index = playerIds.length - 1;
        }
        return this.playerIds[index];
    }

    //Returns all the players
    public String[] getPlayers() {
        return playerIds;
    }

    //Returns player's hand
    public ArrayList<UnoCard> getPlayerHand(String pid) {
        int index = Arrays.asList(playerIds).indexOf(pid);
        return playerHand.get(index);
    }

    //Find the size of a player's hand
    public int getPlayerHandSize(String pid) {
        return getPlayerHand(pid).size();
    }

    //Finds a particular hand in a player's hand
    public UnoCard getPlayerCard(String pid, int choice) {
        ArrayList<UnoCard> hand = getPlayerHand(pid);
        return hand.get(choice);
    }

    //Checks if hand is empty
    public boolean hasEmptyHand(String pid) {
        return getPlayerHand(pid).isEmpty();
    }

    //Checks if card is a valid play
    public boolean validCardPlay(UnoCard card) {
        return card.getColor() == validColor || card.getValue() == validValue;
    }

    //Check if the current player is the correct player's turn
    public void checkPlayerTurn(String pid) throws InvalidPlayerTurnException {
        if(this.playerIds[this.currentPlayer] != pid) {
            throw new InvalidPlayerTurnException("It is not " + pid + " 's turn", pid);
        }
    }

    //
    public void submitDraws(String pid) throws InvalidPlayerTurnException {
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

    //Sets card color
    public void setCardColor(UnoCard.Color color) {
        validColor = color;
    }

    //Submits player card
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
                    JLabel message = new JLabel("Invalid player move, expected color: " + validColor + " but got color " + card.getColor());
                    message.setFont(new Font("Arial", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message);
                    throw new InvalidColorSubmissionException("Invalid player move, expected color: " + validColor + " but got color " + card.getColor(), card.getColor(), validColor);
                }
                else if(card.getValue() != validValue) {
                    JLabel message2 = new JLabel("Invalid player move, expected value: " + validValue + " but got value " + card.getValue());
                    message2.setFont(new Font("Arial", Font.BOLD, 48));
                    JOptionPane.showMessageDialog(null, message2);
                    throw new InvalidValueSubmissionException("Invalid player move, expected value: " + validValue + " but got value " + card.getValue(), card.getValue(), validValue);
                }
            }

            pHand.remove(card);
            if(hasEmptyHand(this.playerIds[currentPlayer])) {
                JLabel message2 = new JLabel(this.playerIds[currentPlayer] + " won the game! Thank you for playing!");
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
            }
            if(card.getValue() == UnoCard.Value.Wild_Four) {
                pid = playerIds[currentPlayer];
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                getPlayerHand(pid).add(deck.drawCard());
                JLabel message = new JLabel(pid + " drew 4 cards!");
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
}

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

class InvalidColorSubmissionException extends Exception {
    private UnoCard.Color expected;
    private UnoCard.Color actual;

    public InvalidColorSubmissionException(String message, UnoCard.Color actual, UnoCard.Color expected) {
        this.actual = actual;
        this.expected = expected;
    }
}

class InvalidValueSubmissionException extends Exception {
    private UnoCard.Value expected;
    private UnoCard.Value actual;

    public InvalidValueSubmissionException(String message, UnoCard.Value actual, UnoCard.Value expected) {
        this.actual = actual;
        this.expected = expected;
    }
}

