/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.tqd.pojo.JdbcUtils;
import com.tqd.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 *
 * @author admin
 */
public class TestQuestionServices {

    @Test
    public void testQuestionOfcategory() {
        Connection conn;
        List<Question> questions = new ArrayList<>();
        try {
            conn = JdbcUtils.getConn();
            PreparedStatement stm = conn.prepareStatement("select * from question where category_id is NULL ");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                questions.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestQuestionServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
