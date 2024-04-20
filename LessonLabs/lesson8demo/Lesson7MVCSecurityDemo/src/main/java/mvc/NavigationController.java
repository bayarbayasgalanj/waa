package mvc;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class NavigationController {

    @GetMapping("/page1")
    public ModelAndView init(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("page1", params);
    }
    @PreAuthorize("hasRole('user')")
    @GetMapping("/page2")
    public ModelAndView page2() {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("page2", params);
    }
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/page3")
    public ModelAndView page3() {
        Map<String, Object> params = new HashMap<>();
        return new ModelAndView("page3", params);
    }
}
