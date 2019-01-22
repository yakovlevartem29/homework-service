package com.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Redirects root requests to swagger page
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}
