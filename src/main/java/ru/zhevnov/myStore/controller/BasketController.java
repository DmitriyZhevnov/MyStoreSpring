package ru.zhevnov.myStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zhevnov.myStore.model.BasketItem;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.service.IBasketService;

import java.util.List;

@Controller
@SessionAttributes({"person","listOfProductsInBasket"})
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private IBasketService basketService;

    @ModelAttribute("listOfProductsInBasket")
    public List<BasketItem> productList(@ModelAttribute("person") Person person) {
        return basketService.returnListOfProductsInBasket(person);
    }

    @GetMapping()
    public String showBasket(@ModelAttribute("person") Person person, Model model){
        model.addAttribute("listOfProductsInBasket", basketService.returnListOfProductsInBasket(person));
        return "basket/basket";
    }

    @PatchMapping
    public String editCount(@ModelAttribute("person") Person person, @RequestParam("count") int count,
                            @RequestParam("idProduct") int idProduct){
        basketService.updateCount(person, idProduct, count);
        return "redirect:/basket";
    }
    @DeleteMapping
    public String deleteItem(@ModelAttribute("person") Person person, @RequestParam("idProduct") int idProduct){
        basketService.deleteItem(person, idProduct);
        return "redirect:/basket";
    }
}
