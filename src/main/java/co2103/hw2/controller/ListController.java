package co2103.hw2.controller;

import co2103.hw2.Hw2Application;
import co2103.hw2.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

    @Autowired
    private RestaurantRepository rRepo;

    @RequestMapping(value = "/")
    public String start(){
        return "list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model){
        model.addAttribute("restaurants", rRepo.findAll());
        return "list";
    }
}
