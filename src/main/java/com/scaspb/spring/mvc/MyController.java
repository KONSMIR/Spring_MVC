package com.scaspb.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        Employee emp = new Employee();
        emp.setName("Enter your name");
        emp.setSurname("Enter your surname");
        emp.setSalary(0);
        model.addAttribute("employee", emp);
        return "ask-emp-details-view";
    }

    @RequestMapping("showDetails")
    public String showEpmDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }

//    @RequestMapping("showDetails")
//    public String showEpmDetails() {
//        return "show-emp-details-view";
//    }

//    @RequestMapping("showDetails")
//    public String showEpmDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//
//        model.addAttribute("description",
//                " - instructor");
//        return "show-emp-details-view";
//    }

//    @RequestMapping("showDetails")
//    public String showEpmDetails(@RequestParam("employeeName") String empName,
//                                 Model model) {
//        empName = "Mr. " + empName + "!";
//        model.addAttribute("nameAttribute", empName);
//
//        return "show-emp-details-view";
//    }
}
