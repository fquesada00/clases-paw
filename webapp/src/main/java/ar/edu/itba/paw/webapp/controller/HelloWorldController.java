package ar.edu.itba.paw.webapp.controller;

import ar.edu.itba.paw.interfaces.service.UserService;
import ar.edu.itba.paw.models.User;
import ar.edu.itba.paw.webapp.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HelloWorldController {

  @Autowired private UserService userService;

  @Autowired private PasswordEncoder passwordEncoder;

  @RequestMapping("/users/{userId}")
  public ModelAndView helloWorld(@PathVariable("userId") final int userId) {
    final User user = userService.findById(userId);
    final ModelAndView mav = new ModelAndView("users");
    mav.addObject("user", user);
    return mav;
  }

  @RequestMapping(value = "/register")
  public ModelAndView register(@ModelAttribute("registerForm") final UserForm form) {

    return new ModelAndView("register");
  }

  @RequestMapping(value = "/users/create", method = RequestMethod.POST)
  public ModelAndView create(
      @Valid @ModelAttribute("registerForm") final UserForm form, final BindingResult errors) {

    if (errors.hasErrors()) {
      return register(form);
    }

    final User u =
        userService.create(
            form.getEmail(),
            form.getFirstName(),
            form.getLastName(),
            form.getAge(),
            passwordEncoder.encode(form.getPassword()));
    return new ModelAndView("redirect:/users/" + u.getId());
  }

  @RequestMapping("/")
  public ModelAndView helloWorld() {
    final ModelAndView mav = new ModelAndView("index");
    final String name;
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof org.springframework.security.core.userdetails.User springUser) {
      final String email = springUser.getUsername();
      name = userService.findByEmail(email).map(User::getFirstName).orElse("Weird PAW");
    } else {
      name = "PAW";
    }
    mav.addObject("greeting", name);
    return mav;
  }
}
