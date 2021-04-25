import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class gameLauncher implements ActionListener {

    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JTextField createUserText;
    private static JTextField createUserPassword;
    private static JTextField verify;
    private static JLabel results;

    public static void launchGames() {
        JFrame frame = new JFrame("350Games");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Games", new GamePlatform.GridPanel());


        frame.getContentPane().add(tp);

        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        /*Text Fields that we will be checking are userText &&
         * passwordText, createUserText && createUserPassword && verify*/
        String users = userText.getText();
        String usersPassword = passwordText.getText();
        String createUsers = createUserText.getText();
        String createPass = createUserPassword.getText();
        String verifyPass = verify.getText();
        boolean hasUserName=false;


        results.setText("Searching Credentials...");

        String path = "/Users/megtreiber/Documents/usernames.txt";

        String line = "";

        System.out.println(users);
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                //Create a map hashmap() to hold people in memory so I don't write over them.
                if(users.equals(values[0]) && usersPassword.equals(values[1])){
                    launchGames();
                    results.setText("Login Successful");
                }else if(createUsers.equals(values[0])){
                    hasUserName = true;
                    results.setText("User Already Exists");
                }else{
                    results.setText("TRY AGAIN");
                }

            }
            br.close();

        } catch (IOException g) {
            g.printStackTrace();
        }

        if(!hasUserName && createPass.equals(verifyPass) && !createUsers.isEmpty() && !verifyPass.isEmpty()){
            try (FileWriter writer = new FileWriter("/Users/megtreiber/Documents/usernames.txt", true);
                 BufferedWriter bw = new BufferedWriter(writer)) {

                bw.write("\n" + createUsers + "," + createPass);
                results.setText("UserName Created");
                launchGames();

            } catch (IOException l) {
                System.err.format("IOException: %s%n", l);
            }
        }else{
            results.setText("Invalid Entry!");
        }
    }
    //System.out.println("Button Clicked!");


    public static void main (String[]args){
        JPanel logPanel = new JPanel();
        JFrame logFrame = new JFrame();
        logFrame.setSize(400, 350);
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFrame.add(logPanel);

        logPanel.setLayout(null);

        //The label for the username text field
        JLabel logUser = new JLabel("Username:");
        logUser.setBounds(10, 20, 80, 25);
        logPanel.add(logUser);

        //The label for the password text field
        JLabel passwordLabel1 = new JLabel("Password:");
        passwordLabel1.setBounds(10, 50, 80, 25);
        logPanel.add(passwordLabel1);

        //The button that logs you in
        JButton login = new JButton("Login");
        login.setBounds(10, 80, 80, 25);
        login.addActionListener(new gameLauncher());
        logPanel.add(login);


        //The label for the username text field in create user
        JLabel createUser = new JLabel("Username:");
        createUser.setBounds(10, 110, 100, 25);
        logPanel.add(createUser);

        //The label for the username password to create a login
        JLabel createPassword = new JLabel("Enter Password:");
        createPassword.setBounds(10, 140, 120, 25);
        logPanel.add(createPassword);


        //The label to verify the passwor dof an account being created
        JLabel verifyLabel = new JLabel("Re-Enter Password:");
        verifyLabel.setBounds(10, 170, 140, 25);
        logPanel.add(verifyLabel);

        //The label for the game log in or create account buttons also where we launch gridbag layout
        results = new JLabel("");
        results.setBounds(10, 230, 250, 25);
        logPanel.add(results);

        //Where the existing user enters their information.
        userText = new JTextField();
        userText.setBounds(160, 20, 200, 25);
        logPanel.add(userText);

        //Where the existing user enters their password
        passwordText = new JPasswordField();
        passwordText.setBounds(160, 50, 200, 25);
        logPanel.add(passwordText);

        //Where the new user creates their account name
        createUserText = new JTextField();
        createUserText.setBounds(160, 110, 200, 25);
        logPanel.add(createUserText);

        //Where the new user enters their password
        createUserPassword = new JTextField();
        createUserPassword.setBounds(160, 140, 200, 25);
        logPanel.add(createUserPassword);

        verify = new JTextField();
        verify.setBounds(160, 170, 200, 25);
        logPanel.add(verify);

        JButton creates = new JButton("Create Account!");
        creates.setBounds(10, 200, 150, 25);
        creates.addActionListener(new gameLauncher());
        logPanel.add(creates);


        logFrame.setVisible(true);


    }
}