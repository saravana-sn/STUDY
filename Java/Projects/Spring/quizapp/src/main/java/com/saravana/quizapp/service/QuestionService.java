package com.saravana.quizapp.service;

import com.saravana.quizapp.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private Map<Integer, Question> questions = new HashMap<>();
    private Integer nextId = 0;

    public ArrayList<Question> loadQuizzes() {
        ArrayList<Question> questionsList = new ArrayList<>(questions.values());
        return questionsList;
    }

    public boolean addQuiz(Question question) {
        Integer id = question.getId();
        if(questions.containsKey(id)) {
            return false;
        }else {
            questions.put(id, question);
            return true;
        }
    }

    public boolean editQuiz(Question question) {
        Integer id = question.getId();
        if(questions.containsKey(id)) {
            questions.put(id, question);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteQuiz(Integer id) {
        if(questions.containsKey(id)) {
            questions.remove(id);
            return true;
        }else {
            return false;
        }
    }
    public Integer getNextId(){
        return nextId++;
    }
    public Question getQuizById(int id) {
        return questions.get(Integer.valueOf(id));
    }
    public int submitQuiz(ArrayList<Question> list) {
        int result = 0;
        for (Question quiz: list){
            Question quizInList = questions.get(quiz.getId());
            if(quizInList.getCorrectAnswer().equals(quiz.getCorrectAnswer())) {
                result++;
            }
        }
        return result;
    }
}
