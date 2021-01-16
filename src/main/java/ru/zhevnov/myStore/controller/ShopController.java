package ru.zhevnov.myStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zhevnov.myStore.dao.BasketDao;
import ru.zhevnov.myStore.dao.ProductDao;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.model.Product;

import java.util.List;

@Controller
@RequestMapping("/shop")
@SessionAttributes({"person","listOfProducts"})
public class ShopController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private BasketDao basketDao;

    @ModelAttribute("listOfProducts")
    public List<Product> productList() {
        return productDao.returnAllProducts();
    }

    @GetMapping("/")
    public String showShop(Model model){
//        model.addAttribute("listOfProducts", productDao.returnAllProducts());
        return "shop/allProducts";
    }
    @PostMapping("/")
    public String addToBasket(@RequestParam("idProduct") int idProduct, @RequestParam("count") int count, @ModelAttribute("person")Person person){
        basketDao.addProductToBasket(person.getId(), idProduct, count);
        return "shop/allProducts";
    }
}
