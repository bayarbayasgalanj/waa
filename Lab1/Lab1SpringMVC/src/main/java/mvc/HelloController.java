package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public ModelAndView hello(@RequestParam(value = "firstname") String firstName,
            @RequestParam(value = "lastname") String lastName) {

        String message = firstName + " " + lastName;

        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        System.out.println(message);
        return new ModelAndView("hello", params);
    }

    @RequestMapping("/calc")
    public ModelAndView calc(@RequestParam(value = "num1") String num1,
            @RequestParam(value = "num2") String num2,
            @RequestParam(value = "op") String op) {
        double result = calculate(op, Integer.parseInt(num1), Integer.parseInt(num2));

        Map<String, Object> params = new HashMap<>();
        params.put("num1", "Number 1 = " + num1);
        params.put("op", "Operator = " + op);
        params.put("num2", "Number 2 = " + num2);
        params.put("result", "Result = " + result);
        return new ModelAndView("calc", params);
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
}
