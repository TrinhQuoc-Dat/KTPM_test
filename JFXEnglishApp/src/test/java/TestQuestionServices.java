/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.tqd.pojo.Choice;
import com.tqd.pojo.Question;
import com.tqd.services.QuestionServices;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


/**
 *
 * @author admin
 */
public class TestQuestionServices {

    @Test
    public void testQuestionIsNull() {
        QuestionServices s = new QuestionServices();
        try {
            List<Question> questions = s.getQuestions(5);
            for (var q : questions){
                Assertions.assertTrue(q.getCategoryId() > 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestQuestionServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testQuestion4Choice(){
        QuestionServices s = new QuestionServices();
        try {
            List<Question> question = s.getQuestions(5);
            for (var q : question){
                q.setChoices(s.getChoice(q.getId()));
                Assertions.assertTrue(q.getChoices().size() == 4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestQuestionServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testQuestionChoiceOfCorrect(){
        QuestionServices s = new QuestionServices();
        try {
            List<Question> question = s.getQuestions(5);
            for (var q : question){
                q.setChoices(s.getChoice(q.getId()));
                List<Choice> choices = q.getChoices();
                int dem = 0;
                for (var c : choices){
                    if(c.isCorrect()) dem++;
                }
                Assertions.assertTrue(dem == 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestQuestionServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
