package View;

import Model.Question;
import Model.QuestionAnswer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionAndAnswer extends JPanel {
    private JLabel labelQuestionContentView;
    private JPanel panelAnswerGroup;
    private JButton buttonClearChoice;
    private JPanel panelView;

    private ButtonGroup buttonGroup;

    public QuestionAndAnswer(Question question, List<QuestionAnswer> questionAnswerList) {
        initComponents();
        addEvents();
        showFormContent(question, questionAnswerList);
        this.setLayout(new BorderLayout());
        this.add(panelView, BorderLayout.CENTER);
    }

    private void showFormContent(Question question, List<QuestionAnswer> questionAnswerList) {
        labelQuestionContentView.setText(question.getContent());
        panelAnswerGroup.removeAll(); // Clear existing answers if any

        for (var questionAnswer : questionAnswerList) {
            var radioButton = new JRadioButton(questionAnswer.getContent());
            radioButton.setFont(labelQuestionContentView.getFont());
            radioButton.setActionCommand(questionAnswer.getContent());
            buttonGroup.add(radioButton);
            panelAnswerGroup.add(radioButton);
        }
    }

    private void addEvents() {
        buttonClearChoice.addActionListener(event -> {
            buttonGroup.clearSelection();
        });
    }

    private void initComponents() {
        buttonGroup = new ButtonGroup();
        labelQuestionContentView = new JLabel();
        panelAnswerGroup = new JPanel();
        buttonClearChoice = new JButton("Clear Choice");
        panelView = new JPanel();

        panelAnswerGroup.setLayout(new BoxLayout(panelAnswerGroup, BoxLayout.Y_AXIS)); // Vertical layout for answers
        panelView.setLayout(new BorderLayout());

        panelView.add(labelQuestionContentView, BorderLayout.NORTH);
        panelView.add(panelAnswerGroup, BorderLayout.CENTER);
        panelView.add(buttonClearChoice, BorderLayout.SOUTH);
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}
