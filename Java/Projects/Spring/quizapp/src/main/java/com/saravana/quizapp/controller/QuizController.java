package com.saravana.quizapp.controller;

import com.saravana.quizapp.model.Question;
import com.saravana.quizapp.model.User;
import com.saravana.quizapp.service.QuestionService;
import com.saravana.quizapp.service.QuizUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {
    private final QuizUserDetailsService userDetailsService;
    private final QuestionService questionService;
    private final AuthenticationManager authenticationManager;

    public QuizController(QuizUserDetailsService userDetailsService, QuestionService questionService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.questionService =  questionService;
        this.authenticationManager = authenticationManager;
    }

    //GET request for retrieving the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    //GET request for retrieving the registration page
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {
        try{
            userDetailsService.registerUser(username,email,password,role );
        }catch (Exception e){
            return "redirect:/register?error";
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/login?success";
    }
    //GET mapping for the retrieving the addQuiz page
    @GetMapping("/addQuiz")
    public String addQuiz(Model model) {
        model.addAttribute("quiz", new Question());
        return "addQuiz";
    }
    //POST request for adding quiz questions
    @PostMapping("/addQuiz")
    public String addQuiz(@ModelAttribute Question question, Model model, Authentication authentication ) {
        // Get the user's role
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER");

        //Redirect to the appropriate page based on a role
        if(role.equals("ROLE_ADMIN")){
            question.setId(questionService.getNextId());
            questionService.addQuiz(question);
            model.addAttribute("success", "Quiz added successfully!");
            return "redirect:/home";
        }else {
            model.addAttribute("error", "You are not allowed to add a quiz!");
            return "redirect:/addQuiz?error";
        }
    }
    // GET mapping for the retrieving the editQuiz page
    @GetMapping("/editQuiz/{id}")
    public String showEditQuizForm(@PathVariable("id") int id, Model model) {
        // Find the quiz by ID
        Question quiz = questionService.getQuizById(id);

        // Add the quiz to the model
        model.addAttribute("quiz", quiz);

        // Return the editQuiz.html template
        return "editQuiz";
    }
    // PUT request for editing quiz questions
    @PostMapping("/editQuestion")
    public String editQuestion(@ModelAttribute("quiz") Question quiz) {
        // Get the authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the user's role
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER"); // Default role if no authority is found

        // Redirect to the appropriate page based on the role
        if (role.equals("ROLE_ADMIN")) {
            // Update the quiz in the service
            questionService.editQuiz(quiz);
            // Redirect to the quiz list page
            return "redirect:/home";
        } else {
            // Redirect to the quiz page
            return "redirect:/home";
        }
    }
    // DELETE request for removing quiz questions
    @GetMapping("/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable("id") int id, Model model) {
        // Get the authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the user's role
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER"); // Default role if no authority is found

        // Redirect to the appropriate page based on the role
        if (role.equals("ROLE_ADMIN")) {
            // Delete the quiz by ID
            questionService.deleteQuiz(id);
            return "redirect:/home"; // Redirect to the quiz list page
        } else {
            return "redirect:/home"; // Redirect to the home page
        }
    }
    // GET request for retrieving quiz questions (home page - different for admin and regular users)
    @GetMapping("/home")
    public String homepage(Model model) {
        // Get the authenticated user's details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get the username
        String username = authentication.getName();
        model.addAttribute("username", username);

        // Get the user's role
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("ROLE_USER"); // Default role if no authority is found

        // Redirect to the appropriate page based on the role
        if (role.equals("ROLE_ADMIN")) {
            // Fetch the latest quizzes from the service
            List<Question> quizzes = questionService.loadQuizzes();

            // Add the quizzes to the model
            model.addAttribute("quizzes", quizzes);
            return "QuizList"; // Return the QuizList.html template
        } else {
            // Fetch the latest quizzes from the service
            List<Question> quizzes = questionService.loadQuizzes();

            // Add the quizzes to the model
            model.addAttribute("quizzes", quizzes);
            return "Quiz"; // Return the Quiz.html template
        }
    }
    // POST request for submitting answers
    @PostMapping("/submitQuiz")
    public String evaluateQuiz(@RequestParam Map<String, String> allParams, Model model) {
        int correctAnswers = 0;
        List<String> userAnswers = new ArrayList<>();
        ArrayList<Question> quizzes = questionService.loadQuizzes();

        // Iterate through the quizzes and compare answers
        for (int i = 0; i < quizzes.size(); i++) {
            String userAnswer = allParams.get("answer" + i); // Get the answer for question i
            userAnswers.add(userAnswer); // Store user's answer
            if (quizzes.get(i).getCorrectAnswer().equals(userAnswer)) {
                correctAnswers++;
            }
        }

        // Add data to the model
        model.addAttribute("quizzes", quizzes);
        model.addAttribute("userAnswers", userAnswers);
        model.addAttribute("correctAnswers", correctAnswers);
        model.addAttribute("totalQuestions", quizzes.size());

        // Return the result template
        return "result";
    }

    @GetMapping("/myResult")
    public String myResult(Model model) {
        return "result";
    }

}
