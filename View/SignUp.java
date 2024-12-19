package View;

import DAO.UserDAO;
import Model.User;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {
    private JTextField textFieldUserID;
    private JTextField textFieldFullName;
    private JButton backButton;
    private JButton signUpButton;
    private JLabel LabelUserID;
    private JLabel LabelFullName;
    private JPasswordField passwordField1;
    private JPasswordField ConfirmpasswordField2;
    private JPanel panelView;
    private JPanel leTren1;
    private JPanel leTren2;
    private JPanel leTren3;
    private JPanel leTren4;
    private JPanel leTren0;
    private JLabel tittle;
    private JLabel LabelPass;
    private JLabel LabelCon;

    public SignUp(){
        addActionEvent();
        this.setTitle("Sign Up");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelView);

        createUIComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
}

    public static void main(String[] args) {
        EventQueue.invokeLater(SignUp ::new);
    }

    private void addActionEvent() {
        signUpButton.addActionListener(even ->{
            var userID = textFieldUserID.getText().strip();
            var fullName = textFieldFullName.getText().strip();
            var password = String.valueOf(passwordField1.getPassword()).strip();
            var passwordAgain = String.valueOf(ConfirmpasswordField2.getPassword()).strip();
            if ( userID.isEmpty() || fullName.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()){
                JOptionPane.showMessageDialog(
                        this,
                        "Information cannot be left blank!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                textFieldUserID.setText("");
                passwordField1.setText("");
                ConfirmpasswordField2.setText("");
            }else if ( verifyAccountNoExits(userID)){
                var user = new User(userID, fullName, password, false);
                var isSuccess = UserDAO.insert(user);
                if ( isSuccess){
                    JOptionPane.showMessageDialog(
                            this,
                            "Sign up Success",
                            "Notice",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }else {
                    JOptionPane.showMessageDialog(
                            this,
                            " Account Sign-up failed. Please try again!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                resetAll();
            }else{
                JOptionPane.showMessageDialog(
                        this,
                        "UserID already exists, try again with another UserID!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                passwordField1.setText("");
                ConfirmpasswordField2.setText("");
            }
        });
        backButton.addActionListener(event ->{
            this.dispose();
            new Login();
        });
    }
    private boolean verifyAccountNoExits( String usetID){
        var user = UserDAO.selectByID(usetID);
        return user == null;
    }

    private void resetAll() {
        textFieldUserID.setText("");
        textFieldFullName.setText("");
        passwordField1.setText("");
        ConfirmpasswordField2.setText("");
    }
    private void createUIComponents(){
        tittle.setOpaque(true);
        tittle.setBackground(new Color(0x76A4A6));

        // Tạo EmptyBorder cho lề của nền
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Tạo LineBorder đen cho viền
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);

        // Tạo CompoundBorder kết hợp EmptyBorder và LineBorder
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);

        // Thiết lập viền và lề cho tittle
        tittle.setBorder(compoundBorder);

        leTren1.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren2.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren3.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren4.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren0.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

        // Chỉnh lề cho LabelUserID
        LabelUserID.setBorder(new EmptyBorder(0, 25, 0, 0));
        LabelFullName.setBorder(new EmptyBorder(0, 25, 0, 0));
        LabelPass.setBorder(new EmptyBorder(0, 25, 0, 0));
        LabelCon.setBorder(new EmptyBorder(0, 25, 0, 0));


        Color backgroundColor = new Color(0, 0, 0);

        textFieldUserID.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
        textFieldFullName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
        passwordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
        ConfirmpasswordField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
    }
}
