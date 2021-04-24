import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class gameLauncher implements ActionListener {

    /** JTextField for username */
    private JTextField userText;

    /** JPasswordField for password */
    private JTextField passwordText;

    /** JTextField for create username */
    private JTextField createUserText;

    /** JPasswordField for create password */
    private JTextField createUserPassword;


    private JTextField verify;
    private JLabel results;

    /** Path of the file that stores password info */
    private String path;

    /** Boolean to verify if username exists */
    protected boolean hasUserName;

    /** Password file */
    public File passwords;

    /** JPanel for login **/
    JPanel logPanel;

    /** JFrame for login **/
    JFrame logFrame;

    /** JLabel for login user **/
    JLabel logUser;

    /** JLabel for login password **/
    JLabel passwordLabel1;

    /** JButton to login **/
    JButton login;

    /** JLabel to create user **/
    JLabel createUser;

    /** JLabel to create password **/
    JLabel createPassword;

    /** JLabel to verify password **/
    JLabel verifyLabel;

    /** JButton to create account **/
    JButton creates;

    /**
     * Constructor that initializes
     * the gameLauncher and login
     * details
     */
    public gameLauncher(){
        logPanel = new JPanel();
        logFrame = new JFrame();
        logUser = new JLabel("Username:");
        passwordLabel1 = new JLabel("Password:");
        login = new JButton("Login");
        createUser = new JLabel("Username:");
        createPassword = new JLabel("Enter Password:");
        verifyLabel = new JLabel("Re-Enter Password:");
        creates = new JButton("Create Account!");

        //Initialize jFrame
        logFrame.setSize(400, 350);
        logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logFrame.add(logPanel);

        logPanel.setLayout(null);

        //The label for the username text field
        logUser.setBounds(10, 20, 80, 25);
        logPanel.add(logUser);

        //The label for the password text field
        passwordLabel1.setBounds(10, 50, 80, 25);
        logPanel.add(passwordLabel1);

        //The button that logs you in
        login.setBounds(10, 80, 80, 25);
        login.addActionListener(this);
        logPanel.add(login);

        //The label for the username text field in create user
        createUser.setBounds(10, 110, 100, 25);
        logPanel.add(createUser);

        //The label for the username password to create a login
        createPassword.setBounds(10, 140, 120, 25);
        logPanel.add(createPassword);

        //The label to verify the passwor dof an account being created
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

        creates.setBounds(10, 200, 150, 25);
        creates.addActionListener(this);
        logPanel.add(creates);

        logFrame.setVisible(true);
    }

    /**
     * Function to the launch
     * the JFrame containing
     * the buttons to launch the games
     */
    public static void launchGames() {
        JFrame frame = new JFrame("350Games");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Games", new GamePlatform.GridPanel());

        frame.getContentPane().add(tp);

        frame.setVisible(true);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object pressed = e.getSource();
        passwords = new File("Launch/usernames.csv");
        /*Text Fields that we will be checking are userText &&
         * passwordText, createUserText && createUserPassword && verify*/
        String users = userText.getText();
        String usersPassword = passwordText.getText();
        String createUsers = createUserText.getText();
        String createPass = createUserPassword.getText();
        String verifyPass = verify.getText();
        hasUserName = false;
        path = passwords.getAbsolutePath();
        String line = "";

        results.setText("Searching Credentials...");

        //launchGames();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
            while (line != null) {
                System.out.println(line);

                String[] values = line.split(",");

                //
                if(users.equals(values[0]) && usersPassword.equals(values[1])){
                    launchGames();
                    results.setText("Login Successful");
                } else if(createUsers.equals(values[0])){
                    hasUserName = true;
                    results.setText("User Already Exists");
                } else {
                    results.setText("TRY AGAIN");
                }
                line = br.readLine();
            }
            br.close();

        } catch (IOException g) {
            g.printStackTrace();
        }

        //User name doesn't exist, verify and create password are the same, username and password fields are not empty
        if(!hasUserName && createPass.equals(verifyPass) && !createUsers.isEmpty() && !verifyPass.isEmpty()){
            try {
                FileWriter writer = new FileWriter(path, true);
                BufferedWriter bw = new BufferedWriter(writer);
                bw.write("\n" + createUsers + "," + createPass);
                results.setText("UserName Created");
                launchGames();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            results.setText("Invalid Entry!");
        }
    }

    public static void main (String[]args){
        new gameLauncher();
    }
}