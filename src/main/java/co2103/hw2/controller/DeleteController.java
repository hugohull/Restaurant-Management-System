package co2103.hw2.controller;

import co2103.hw2.model.Chef;
import co2103.hw2.model.Orders;
import co2103.hw2.model.Restaurant;
import co2103.hw2.repo.ChefRepository;
import co2103.hw2.repo.OrderRepository;
import co2103.hw2.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class DeleteController {

    @Autowired
    private RestaurantRepository rRepo;
    @Autowired
    private ChefRepository cRepo;
    @Autowired
    private OrderRepository oRepo;

    @RequestMapping("/deleteRestaurant")
    public String deleteRestaurant(@RequestParam int id) {
        if (rRepo.findById(id).isPresent()) {
            rRepo.delete(rRepo.findById(id).get());
        }
        return "redirect:list";
    }

    @RequestMapping("/deleteChef")
    public String deleteChef(@RequestParam String firstName) {
        if (cRepo.findById(firstName).isPresent()) {
            for (Restaurant r : rRepo.findAll()) {
                for (Chef c : r.getChefs()) {
                    if (c == r.getHeadChef()) {
                        r.setHeadChef(null);
                    }
                    if (Objects.equals(c.getFirstName(), cRepo.findById(firstName).get().getFirstName())) {
                        r.getChefs().remove(c);
                        break;
                    }
                }
                cRepo.deleteById(firstName);
            }
            return "redirect:list";
        }
        return "redirect:list";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam int id) {
        if (oRepo.findById(id).isPresent()) {
            for (Chef c : cRepo.findAll()) {
                for (Orders o : c.getOrders()) {
                    if (o == c.getNextOrder()) {
                        c.setNextOrder(null);
                    }
                }
                oRepo.deleteById(id);
            }
            return "redirect:list";
        }
        return "redirect:list";
    }
}
