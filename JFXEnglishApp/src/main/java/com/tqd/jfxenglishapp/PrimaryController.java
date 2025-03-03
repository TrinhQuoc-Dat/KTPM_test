package com.tqd.jfxenglishapp;

import com.tqd.pojo.Question;
import com.tqd.services.QuestionServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class PrimaryController implements Initializable {

    QuestionServices s = new QuestionServices();

    @FXML
    private Text content;
    @FXML
    private RadioButton rdoA;
    @FXML
    private RadioButton rdoB;
    @FXML
    private RadioButton rdoC;
    @FXML
    private RadioButton rdoD;
    @FXML
    private Text txtA;

    @FXML
    private Text txtB;

    @FXML
    private Text txtC;

    @FXML
    private Text txtD;

    private int index = 0;
    private List<Question> questions;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void checkHandler(ActionEvent e) {
        Question q = this.questions.get(this.index);
        boolean d1 = rdoA.isSelected() && q.getChoices().get(0).isCorrect();
        boolean d2 = rdoB.isSelected() && q.getChoices().get(1).isCorrect();
        boolean d3 = rdoC.isSelected() && q.getChoices().get(2).isCorrect();
        boolean d4 = rdoD.isSelected() && q.getChoices().get(3).isCorrect();

        if (d1 || d2 || d3 || d4) {
            Ultils.getAlert("Exactly").show();
        } else {
            Ultils.getAlert("Failer").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.questions = s.getQuestions();
            loadQuestionToUI();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void nextHandel(ActionEvent e) throws SQLException {
        if (this.index < this.questions.size()) {
            this.index++;
            loadQuestionToUI();
        } else {
            this.index = 0;
        }
    }

    public void loadQuestionToUI() throws SQLException {
        Question q = this.questions.get(index);
        content.setText(q.getContent());

        if (q.getChoices() == null) {
            q.setChoices(s.getChoice(q.getId()));
            txtA.setText(q.getChoices().get(0).toString());
            txtB.setText(q.getChoices().get(1).toString());
            txtC.setText(q.getChoices().get(2).toString());
            txtD.setText(q.getChoices().get(3).toString());
        }
    }
}
