
import org.junit.Test;

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//
//public class UnoTest {
//
//    @Test
//    //Checks if Uno game displays the AddPlayers panel when the user presses the Start Game button
//    void requirement35Test() {
//        Menu menu = new Menu();
//        ActionEvent event = new ActionEvent(menu.getBtnStartGame(), ActionEvent.ACTION_PERFORMED,"");
//        menu.btnStartGameActionPerformed(event);
//        assertTrue(menu.addPlayerObj.isShowingPanel());
//    }
//
//    @Test
//    //Checks if Uno game saved user names when the Save button is pressed
//    void requirement37Test() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        assertTrue(addPlayerNames.getPlayerIds().size() > 0);
//    }
//
//    @Test
//    //Checks if Uno game displays the GameStage panel when the Done button is pressed.
//    void requirement38Test() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//        assertTrue(addPlayerNames.gameStage.isShowingPanel());
//    }
//
//    @Test
//        //Checks if Uno game displays the GameStage panel when the wrong number of players are entered when the Done button is pressed.
//    void requirement38Test2() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//        stringList.add("Ari");
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//        assertTrue(addPlayerNames.gameStage.isShowingPanel());
//    }
//
//    @Test
//    //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test1() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton1(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton1ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//        //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test2() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton2(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton2ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//    //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test3() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton3(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton3ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//        //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test4() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton4(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton4ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//        //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test5() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton5(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton5ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//        //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test6() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton6(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton6ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//        //Checks if Uno game displays the PopUp panel when any of first 7 active card buttons are pressed within the GameStage panel.
//    void requirement39Test7() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getjButton7(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton7ActionPerformed(event3);
//
//        assertTrue(gameStage.window.isShowing());
//    }
//
//    @Test
//    //Checks if Uno game closed the PopUp window when the Cancel button was pressed
//    void requirement41Test() {
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event = new ActionEvent(gameStage.getjButton1(), ActionEvent.ACTION_PERFORMED,"");
//        gameStage.jButton1ActionPerformed(event);
//
//        ActionEvent event2 = new ActionEvent(gameStage.window.getCancelButton(), ActionEvent.ACTION_PERFORMED, "");
//        gameStage.window.cancelButtonActionPerformed(event2);
//
//        assertFalse(gameStage.window.isShowingPanel());
//    }
//
//    @Test
//    //Checks if Uno game quits to menu when the Quit to Menu button is pressed.
//    void requirement45() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        ActionEvent event2 = new ActionEvent(addPlayerNames.getDoneButton(), ActionEvent.ACTION_PERFORMED, "");
//        ArrayList<String> stringList = new ArrayList<String>();
//        stringList.add("Jhoseph");
//        stringList.add("Maka");
//        stringList.add("Ari");
//        stringList.add("Josh");
//
//        addPlayerNames.setPlayerIds(stringList);
//        addPlayerNames.saveButtonActionPerformed(event);
//        addPlayerNames.doneButtonActionPerformed(event2);
//
//        GameStage gameStage = new GameStage(stringList);
//        ActionEvent event3 = new ActionEvent(gameStage.getBtnBackToMainMenu(), ActionEvent.ACTION_PERFORMED, "");
//        gameStage.btnBackToMainMenuActionPerformed(event3);
//
//        assertFalse(gameStage.isShowingPanel());
//    }
//
//    @Test
//    //Checks if user pressed Save button without entering any names
//    void isNameTextFieldEmptyTest() {
//        AddPlayerNames addPlayerNames = new AddPlayerNames();
//        ActionEvent event = new ActionEvent(addPlayerNames.getSaveButton(), ActionEvent.ACTION_PERFORMED, "");
//        addPlayerNames.saveButtonActionPerformed(event);
//        assertEquals(false,addPlayerNames.getPlayerIds().size() > 0);
//    }
//
//    @Test
//    //Checks if pids array is being return properly
//    void getPidsTest() {
//        AddPlayerNames playerNames = new AddPlayerNames();
//        String[] Pids = playerNames.getPids();
//        int flag = 0;
//        if(Pids != null)
//            flag = 1;
//        assertEquals(1,flag);
//    }
//
//    @Test
//    //Checks if player name is not null
//    void getplayerIdsNamesTest() {
//        String[] Pids = {"Jhoseph, Sov, Ari"};
//        Game game = new Game(Pids);
//        String names = game.getCurrentPlayer();
//        int flag = 0;
//        if(names != null)
//            flag = 1;
//        assertEquals(1,flag);
//    }
//
//    @Test
//    //Checks if game is over
//    void isGameOverTest() {
//        String[] Pids = {"Jhoe, Sov, Ari"};
//        Game game = new Game(Pids);
//        ArrayList<ArrayList<UnoCard>> playerHands = new ArrayList<ArrayList<UnoCard>>();
//        boolean flag = playerHands.isEmpty();
//        assertEquals(true, flag);
//    }
//
//    @Test
//    //Checks if getColor returns proper color
//    public void getColorTest() {
//        UnoCard unoCard = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One);
//        assertEquals(UnoCard.Color.Red, unoCard.getColor());
//    }
//
//    @Test
//    //Checks if getValue returns proper value
//    public void getValueTest() {
//        UnoCard unoCard = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One);
//        assertEquals(UnoCard.Value.One, unoCard.getValue());
//    }
//
//    @Test
//    //Checks if UnoCard returns color and value as a string
//    public void toStringTest() {
//        UnoCard unoCard = new UnoCard(UnoCard.Color.Red, UnoCard.Value.One);
//        String result = unoCard.toString();
//        assertEquals("Red_One", result);
//    }
//
//    @Test
//    //Checks if deck is not empty
//    public void isEmptyTest() {
//        UnoDeck unoDeck = new UnoDeck();
//        assertEquals(false, unoDeck.isEmpty());
//    }
//
//    @Test
//    //Checks if there are 108 card in the deck
//    public void isCardInDeckTest() {
//        UnoDeck unoDeck = new UnoDeck();
//        assertEquals(108, unoDeck.cardInDeckGetter());
//    }
//
//}
