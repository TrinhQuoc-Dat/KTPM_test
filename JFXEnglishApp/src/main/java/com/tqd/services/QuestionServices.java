/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.services;

import com.tqd.pojo.Choice;
import com.tqd.pojo.JdbcUtils;
import com.tqd.pojo.Question;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class QuestionServices {
    public List<Question> getQuestions(int num) throws SQLException{
        List<Question> questions = new ArrayList<>();
        
        Connection conn = JdbcUtils.getConn();
        
        PreparedStatement stm = conn.prepareStatement("Select * From question order by rand() limit ?");
        stm.setInt(1, num);
        
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
            questions.add(q);
        }
        
        return questions;
    }
    public List<Question> getQuestions() throws SQLException{
        List<Question> questions = new ArrayList<>();
        Connection conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs =  stm.executeQuery("SELECT * FROM question");
        
        while(rs.next()){
            Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
            questions.add(q);
        }
        
        return questions;
    }
    
    
    public List<Choice> getChoice(String questionId) throws SQLException{
        List<Choice> choices = new ArrayList<>();
        
        Connection conn = JdbcUtils.getConn();
        
        PreparedStatement stm = conn.prepareStatement("Select * From choice where question_id=?");
        stm.setString(1, questionId);
        
        ResultSet rs = stm.executeQuery();
        
        while(rs.next()){
            Choice c = new Choice(rs.getString("id"), rs.getString("content"),
                    rs.getBoolean("is_correct"), rs.getString("question_id"));
            choices.add(c);
        }
        
        return choices;
    }
    
}
