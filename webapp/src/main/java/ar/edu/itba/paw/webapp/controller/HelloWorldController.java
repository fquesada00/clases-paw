package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.service.UserService;
import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

  @Autowired private UserService userService;

  @RequestMapping("/users/{userId}")
  public ModelAndView helloWorld(@PathVariable("userId") final int userId) {
    final User user = userService.findById(userId);
    final ModelAndView mav = new ModelAndView("users");
    mav.addObject("user", user);
    return mav;
  }

  @RequestMapping("/users/create")
  public ModelAndView create(
      @RequestParam(value = "email") final String email,
      @RequestParam(value = "first_name") final String firstName,
      @RequestParam(value = "last_name") final String lastName,
      @RequestParam(value = "age") final int age) {
    final User u = userService.create(email, firstName, lastName, age);
    return new ModelAndView("redirect:/users/" + u.getId());
  }

  @RequestMapping("/")
  public ModelAndView helloWorld() {
    final ModelAndView mav = new ModelAndView("index");
    mav.addObject("greeting", "PAW");
    return mav;
  }
}
