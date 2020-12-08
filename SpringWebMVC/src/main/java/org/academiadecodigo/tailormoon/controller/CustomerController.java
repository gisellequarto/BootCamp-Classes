package org.academiadecodigo.tailormoon.controller;

import org.academiadecodigo.tailormoon.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    // Map the URL/Verb to the method
    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public String sayHello(Model model) {

        Customer person = new Customer();
        person.setName("Bond");

        // Add an attribute to the request
        model.addAttribute("person", person);

        // Return the view name
        return "index";

    }


}
