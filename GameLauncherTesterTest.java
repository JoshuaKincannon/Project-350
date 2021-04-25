package com.company.GameP;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class GameLauncherTest {

    gameLauncher gl;
    String filename = "passwordsTest.txt";

    /**
     * Requirement 1:
     * The Gaming platform shall
     * prompt a user to login or
     * create an account when launched.
     */
    @Test
    public void requirement1(){
        gl = new gameLauncher(filename);
        Assert.assertTrue(gl.isShowing());
        new File(filename).delete();
    }

    /**
     * Requirement 2:
     * The gaming platform shall
     * check user information when
     * a user clicks the login button.
     */
    @Test
    public void requirement2Invalid(){
        gl = new gameLauncher(filename);
        JButton login = gl.login;

        //INVALID USERNAME AND PASS
        String userName = "arijaye";
        String userPass = "arijaye123";

        gl.getUserText().setText(userName);
        gl.getPasswordText().setText(userPass);

        gl.actionPerformed(new ActionEvent(login,ActionEvent.ACTION_PERFORMED,""));

        //Invalid
        Assert.assertEquals(gl.getResults().getText(),"Invalid Entry!");
        new File(filename).delete();
    }

    /**
     * Requirement 2:
     * The gaming platform shall
     * check user information when
     * a user clicks the login button.
     */
    @Test
    public void requirement2Valid(){
        gl = new gameLauncher(filename);
        JButton login = gl.login;

        //VALID CREATE USERNAME AND PASS
        String userName = "arijaye";
        String userPass = "arijaye123";

        gl.getCreateUserText().setText(userName);
        gl.getCreateUserPassword().setText(userPass);
        gl.getVerify().setText(userPass);

        gl.actionPerformed(new ActionEvent(gl.creates,ActionEvent.ACTION_PERFORMED,""));

        boolean present = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
            String line = br.readLine();
            while(line != null) {
                if (line.contains(userName) && line.contains(userPass))
                    present = true;
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //CREATES USERNAME
        Assert.assertTrue(present);
        Assert.assertEquals(gl.getResults().getText(),"UserName Created");
        new File(filename).delete();
    }

    /**
     * Requirement 3:
     * The gaming platform shall
     * display game options to
     * select from when the user signs in.
     */
    @Test
    public void requirement3(){
        gl = new gameLauncher(filename);

        String userName = "arijaye";
        String userPass = "arijaye123";

        //CREATE ACCOUNT
        gl.getCreateUserText().setText(userName);
        gl.getCreateUserPassword().setText(userPass);
        gl.getVerify().setText(userPass);

        gl.actionPerformed(new ActionEvent(gl.login,ActionEvent.ACTION_PERFORMED,""));

        gameLauncher gp = new gameLauncher(filename);

        //LOGIN TO CREATED ACCOUNT
        gp.getUserText().setText(userName);
        gp.getPasswordText().setText(userPass);

        gp.actionPerformed(new ActionEvent(gp.login,ActionEvent.ACTION_PERFORMED,""));

        //ASSERT THAT THE GAMEPLATFORM IS VISIBLE TO USER
        Assert.assertTrue(new GamePlatform().isShowing());
        new File(filename).delete();
    }

    /**
     * Requirement 4:
     * The gaming platform shall launch
     * a game when the user selects
     * a game (button).
     */
    @Test
    public void requirement4(){
        gl = new gameLauncher(filename);

        String userName = "arijaye";
        String userPass = "arijaye123";

        //CREATE ACCOUNT
        gl.getCreateUserText().setText(userName);
        gl.getCreateUserPassword().setText(userPass);
        gl.getVerify().setText(userPass);

        gl.actionPerformed(new ActionEvent(gl.login,ActionEvent.ACTION_PERFORMED,""));

        gameLauncher gp = new gameLauncher(filename);

        //LOGIN TO CREATED ACCOUNT
        gp.getUserText().setText(userName);
        gp.getPasswordText().setText(userPass);

        gp.actionPerformed(new ActionEvent(gp.login,ActionEvent.ACTION_PERFORMED,""));

        //ASSERT THAT THE GAMEPLATFORM IS VISIBLE TO USER
        Assert.assertTrue(new GamePlatform().isShowing());
        new File(filename).delete();
    }
}
