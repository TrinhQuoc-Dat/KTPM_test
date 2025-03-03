package com.tqd.jfxenglishapp;

import com.tqd.pojo.Choice;
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
        Choice c = this.questions.get(index).getChoices().get(index);
            

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            QuestionServices s = new QuestionServices();
            this.questions = s.getQuestions(3);
            loadQuestionToUI();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void nextHandel(ActionEvent e) throws SQLException{
        if (this.index < this.questions.size()){
            this.index++;
            loadQuestionToUI();
        }else this.index = 0;
    }
    

    public void loadQuestionToUI() throws SQLException {
        QuestionServices s = new QuestionServices();
        this.questions = s.getQuestions(3);
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
