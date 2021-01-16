package ru.zhevnov.myStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.service.IPersonService;

import javax.validation.Valid;

@Controller
@RequestMapping("/myStore")
@SessionAttributes("person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/registration")
    public String registrationFrom(Model model) {
        model.addAttribute("person", new Person());
        return "person/registrationPage";
    }

    @PostMapping("/registration")
    public String registrationSuccessful(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "person/registrationPage";
        }
        if (!personService.checkLoginForExist(person.getLogin())) {
            personService.registerNewPerson(person.getName(), person.getAge(), person.getLogin(), person.getPassword());
            return "person/login";
        } else {
            //добавить ошибку о существующем
//            bindingResult.addError(new ObjectError(person.getLogin(), "param"));
//            bindingResult.rejectValue("person.login.exist","ll");
            return "person/registrationPage";
        }
    }

    @GetMapping("/main")
    public String mainPage(){
        return "person/mainPage";
    }

    @GetMapping("/myPage")
    public String personalPage(@ModelAttribute("person") Person person) {
        return "person/personalPage";
    }

    @GetMapping("/editPage")
    public String editPersonalParameters(){
        return "person/personalPageForChangeParameters";
    }

    @PostMapping("/editPage")
    public String editAndPostPersonalParameters(@ModelAttribute("person") @Valid Person person,
                                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "person/personalPageForChangeParameters";
        }
        personService.updatePerson(person);
        return "redirect:/myStore/myPage";
    }

    @ModelAttribute("person")
    public Person newPerson() {
        return new Person();
    }

    @GetMapping("/")
    public String loginForm(Model model) {
        return "person/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login, @RequestParam("password") String pas, Model model) {
        Person person = personService.checkAndReturnPersonByLoginAndPassword(login, pas);
        if (person == null) {
            return "страница не существующего";
        }
        System.out.println(person);
        model.addAttribute("person", person);
        return "redirect:/myStore/main";
    }
}
