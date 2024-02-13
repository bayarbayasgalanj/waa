package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show calculator page
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //show result page
        double result = 0;
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String operation = request.getParameter("op");
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);
        result = calculate(operation, num1, num2);


        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>SIMPLE CALCULATOR<br><br><br></head>");
        out.println("<body>");
        out.println("<form method = 'post' action = 'calc'>");
        out.println("enter the first number:<br>");
        out.println("<input type = 'text' name='number1'><br><br>");
        out.println("enter the second number:<br>");
        out.println("<input type = 'text' name='number2'><br><br>");
        out.println("enter the operation:<br><br>");
        out.println("<input type ='radio' name = 'op' value = '+'>add<br>");
        out.println("<input type = 'radio' name = 'op' value = '-'>sub<br>");
        out.println("<input type = 'radio' name = 'op' value = '*'>mul<br>");
        out.println("<input type = 'radio' name = 'op' value = '/'>div<br><br>");
        out.println("<input type = 'submit' name = 'result' value = 'submit'><br>");

        out.println("<h2>The result of " + number1 + " " + operation + " " + number2 + " =" + result + "</h2>");
        
        HashMap<String, Object> calculation = new HashMap<>();
        calculation.put("number1", number1);
        calculation.put("operation", operation);
        calculation.put("number2", number2);
        calculation.put("result", result);
        
        HttpSession session = request.getSession();
        List<HashMap<String, Object>> historyOfCalculation = (ArrayList<HashMap<String, Object>>) session.getAttribute("calculationHistory");
        if (historyOfCalculation == null) {
            historyOfCalculation = new ArrayList<HashMap<String, Object>>();
        }
        historyOfCalculation.add(calculation);
        session.setAttribute("calculationHistory", historyOfCalculation);

        showHistory(out, request);
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    private double calculate(String op, int num1, int num2) {
        if (op.equals("+")) {
            return num1 + num2;
        } else if (op.equals("-")) {
            return num1 - num2;
        } else if (op.equals("*")) {
            return num1 * num2;
        } else if (op.equals("/")) {
            return num1 / num2;
        }
        return 0;
    }

    private void showHistory(PrintWriter out, HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<HashMap<String, Object>> historyOfCalculation = (ArrayList<HashMap<String, Object>>) session.getAttribute("calculationHistory");
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>first</th>");
        out.println("<th>operation</th>");
        out.println("<th>second</th>");
        out.println("<th>result</th>");
        out.println("</tr>");

        for (HashMap<String, Object> calculation : historyOfCalculation) {
            out.println("<tr>");
            out.println("<th>" + calculation.get("number1") + "</th>");
            out.println("<th>" + calculation.get("operation") + "</th>");
            out.println("<th>" + calculation.get("number2") + "</th>");
            out.println("<th>" + calculation.get("result") + "</th>");
            out.println("</tr>");
        }
        out.println("</table >");
    }
}
