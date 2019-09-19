package edu.mum.cs.controller;

import edu.mum.cs.model.Quiz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/")
public class HomeController extends HttpServlet {
    int prevQnIndex = 0;
    int score = 0;
    Quiz quiz = new Quiz();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Random r = new Random();
        int n = r.nextInt(quiz.getQuestions().length);
        prevQnIndex = n;
//        if(session.getAttribute("quiz") == null) {
            session.setAttribute("quiz", quiz.getQuestions()[n]);
            if(session.getAttribute("score") == null) {
                session.setAttribute("score", score);
            }

//        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ans = Integer.parseInt(req.getParameter("answer"));
        HttpSession session = req.getSession();
        if(ans == quiz.getAnswers()[prevQnIndex]) {
            int s = (int)session.getAttribute("score");
            s += 1;
            session.setAttribute("score", s);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
