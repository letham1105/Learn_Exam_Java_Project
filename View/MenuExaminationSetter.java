package View;

import Model.User;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MenuExaminationSetter extends JFrame {
    private final User loginUser;
    private JButton createQuestionButton;
    private JButton examinationRoomButton;
    private JButton createExamButton;
    private JButton EXITButton;
    private JPanel panelview;

    public MenuExaminationSetter(User user) {
        this.loginUser = user;
        addActionEvent();
        this.setTitle("Menu Examination Setter");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelview);

        createUIComponents();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        User host = new User(
                "host",
                "host",
                "host",
                true
        );
        EventQueue.invokeLater(()-> new MenuExaminationSetter(host));
    }
    private void addActionEvent() {
        createExamButton.addActionListener(event ->{
            this.dispose();
            new ExamManagement(loginUser);
        });
        createQuestionButton.addActionListener(event ->{
            this.dispose();
            new QuestionManagement(loginUser);
        });
        examinationRoomButton.addActionListener(event ->{
            this.dispose();
            new ExaminationRoomManagement(loginUser);
        });
        EXITButton.addActionListener(event ->{
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
        createExamButton.setBorder(new MenuExaminationSetter.BottomBorderNut(Color.BLACK));
        createQuestionButton.setBorder(new MenuExaminationSetter.BottomBorderNut(Color.BLACK));
        examinationRoomButton.setBorder(new MenuExaminationSetter.BottomBorderNut(Color.BLACK));
        EXITButton.setBorder(new MenuExaminationSetter.BottomBorderNut(Color.BLACK));
    }
}
