package View;

import DAO.UserDAO;
import Model.User;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;


public class Login extends JFrame {
    private JTextField textFieldUserName;
    private JCheckBox showPasswordCheckBox;
    private JButton exitButton;
    private JButton logInButton;
    private JButton signUpButton;
    private JPasswordField passwordField1;
    private JPanel panelView;
    private JLabel tittle;
    private JLabel nhan_ten;
    private JLabel nhan_mat_khau;
    private JPanel leTren1;
    private JPanel leTren2;
    private JPanel leTren3;
    private JPanel leTren4;
    private JPanel leTren5;
    private JPanel leTren6;
    private JLabel anh;
    private static final String username_admin = "admin";
    private static final String password_admin = "admin";


    public Login(){
        addActionEvent();
        this.setTitle("Log in");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelView);

        createUIComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Login::new);
    }

    private void addActionEvent() {
        logInButton.addActionListener(event ->{
            var username = textFieldUserName.getText().strip();
            var password = String.valueOf(passwordField1.getPassword()).strip();
            if ( username.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(
                        this,
                        "Information cannot be left blank!",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }else {
                if (username.equals(username_admin) && password.equals(password_admin)) {
                    var admin = new User(username_admin, username_admin, password_admin, true);
                    this.dispose();
                    new MenuAdmin(admin);
                } else {
                    var password_encrypted = UserDAO.encryptPassword(password);
                    var loginUser = UserDAO.selectByAccount(username, password_encrypted);
                    if (loginUser != null) {
                        var checkHost = loginUser.isHost();
                        if (checkHost) {
                            new MenuExaminationSetter(loginUser);
                        } else {
                            new MenuExaminee(loginUser);
                        }
                    }else{
                            JOptionPane.showMessageDialog(
                                    this,
                                    "Wrong login name or password",
                                    "Warning",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            passwordField1.setText("");
                        }
                    }
                }
            });
                    signUpButton.addActionListener(even ->{
                        this.dispose();
                        new SignUp();
                });
                    showPasswordCheckBox.addActionListener(event ->{
                    if ( showPasswordCheckBox.isSelected()){
                        passwordField1.setEchoChar((char) 0);
                    }else{
                        passwordField1.setEchoChar('*');
                    }
                });
                    exitButton.addActionListener(event ->{
                        var selection = JOptionPane.showConfirmDialog(
                                this,
                                "Do you really want to exit",
                                "Exit",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE
                        );
                        if ( selection == JOptionPane.OK_OPTION){
                            System.exit(0);
                        }
                });
            }
    private void createUIComponents() {

        // Load the image
        ImageIcon imageIcon = new ImageIcon("Image/img_6.png");

        // Resize the image
        Image image = imageIcon.getImage(); // transform it
        Image newImage = image.getScaledInstance(400, 400,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newImage);  // transform it back

        // Set the resized image to the JLabel
        anh.setIcon(imageIcon);
        // Set preferred size for JLabel
        anh.setPreferredSize(new Dimension(50, 50));


        tittle.setOpaque(true);
        tittle.setBackground(new Color(0x76A4A6));

        leTren1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        leTren2.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren3.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren5.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
        leTren6.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        // Tạo EmptyBorder cho lề của nền
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Tạo LineBorder đen cho viền
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);

        // Tạo CompoundBorder kết hợp EmptyBorder và LineBorder
        Border compoundBorder = BorderFactory.createCompoundBorder(lineBorder, emptyBorder);

        // Thiết lập viền và lề cho tittle
        tittle.setBorder(compoundBorder);

        // Thiết lập lề trái cho JLabel nhan_ten
        nhan_ten.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        nhan_mat_khau.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));



        // Xóa hoặc bỏ comment dòng dưới để hiển thị đường viền dưới cho passwordField1
        Color backgroundColor = new Color(0, 0, 0);
        textFieldUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
        passwordField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, backgroundColor));
    }


}

