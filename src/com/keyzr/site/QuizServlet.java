package com.keyzr.site;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@SuppressWarnings("serial")
public class QuizServlet extends HttpServlet{

    private Participators participators = new Participators();
    private int[][] qna = new int[2][3];


    private String html = "<html><head><title>Quiz statistics</title></head><body><h1>%s</h1></body></html>";

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        try {

            int ans1 = Integer.parseInt(req.getParameter("question1"));
            int ans2 = Integer.parseInt(req.getParameter("question2"));

            int age = Integer.parseInt(req.getParameter("age"));

            if(name.trim().equals("")||surname.trim().equals("")){ throw new IllegalArgumentException();}

            Participator temp = new Participator(
                            name,
                            surname,
                            age,
                            new HashMap<String,Integer>(){{
                                put("question1",ans1);
                                put("question2",ans2);
                            }}
            );
            if(participators.getParticipators().contains(temp)){
                throw new IllegalArgumentException();
            }
            participators.add(temp);

            ++qna[0][ans1];
            ++qna[1][ans2];

            resp.getWriter().println(formatHtmlStatistics());
            System.out.println(participators);

        }catch (IllegalArgumentException e){
            resp.sendRedirect("index.html"); // else redirect to start page
        }
    }

    private String formatHtmlStatistics(){
        String response = "<p>%s</p>";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qna.length; i++) {
            sb.append("Question #").append(i+1).append(" answers stats: ");
            for (int j = 0; j < qna[i].length; j++) {
                sb.append("<br>").append("answer #").append(j+1).append(" - ").append(qna[i][j]);
            }
            sb.append("<hr/>");
        }
        response=String.format(response,sb.toString());
        return String.format(this.html,response);
    }
}
