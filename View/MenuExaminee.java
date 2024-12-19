package View;

import Model.User;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MenuExaminee extends JFrame {
    private final User loginUser;
    private JButton enterRoomButton;
    private JButton logOutButton;
    private JButton scoreButton;
    private JPanel panelView;
    private JButton reviewButton;

    public MenuExaminee(User user)  {
        this.loginUser = user;
        addActionEvent();
        this.setTitle("Menu Examinee");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelView);

        createUIComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void addActionEvent() {
        enterRoomButton.addActionListener(event ->{
            this.dispose();
            new EnterExamRoom(loginUser);
        });
        scoreButton.addActionListener(event ->{
            this.dispose();
            new ScoreOfExaminee(loginUser);
        });
        reviewButton.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> {
                try {
                    this.dispose(); // Đóng cửa sổ hiện tại
                    Review1 review = new Review1(); // Tạo instance mới của Review
                    review.setVisible(true); // Hiển thị cửa sổ Review
                } catch (Exception e) {
                    e.printStackTrace(); // In ra ngoại lệ nếu có
                }
            });
        });
        logOutButton.addActionListener(event ->{
            this.dispose();
            new Login();
        });
    }

    // Thêm
    public class BottomBorderNut extends MatteBorder {
        public BottomBorderNut(Color color) {
            super(2, 2, 2, 2, color);
        }
    }
    // Kết

    private void createUIComponents() {
        enterRoomButton.setBorder(new MenuExaminee.BottomBorderNut(Color.BLACK));
        scoreButton.setBorder(new MenuExaminee.BottomBorderNut(Color.BLACK));
        logOutButton.setBorder(new MenuExaminee.BottomBorderNut(Color.BLACK));
        reviewButton.setBorder(new MenuExaminee.BottomBorderNut(Color.BLACK));
    }

    public static void main(String[] args) {
    User examinee = new User(
            "examinee",
            "examinee",
            "examinee",
            false
    );
        EventQueue.invokeLater(() -> new MenuExaminee(examinee));
    }
}
