package com.emp.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Developer PC on 10/30/2017.
 */
@Controller
public class MainController {

    @RequestMapping("/role")
    public String role() {
        return "role";
    }

    @RequestMapping("/task")
    public String task() {
        return "task";
    }

    @RequestMapping("/employee")
    public String employee() {
        return "employee";
    }
}
