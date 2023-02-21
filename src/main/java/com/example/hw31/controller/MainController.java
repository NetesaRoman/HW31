package com.example.hw31.controller;

import com.example.hw31.dto.ProductDto;
import com.example.hw31.model.Product;
import com.example.hw31.service.ProductService;
import com.example.hw31.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/*
 *
 * @author Roman Netesa
 *
 */
@Controller
@Slf4j
public class MainController {

    @Autowired
    private ProductService productService;


    @GetMapping("/login")
    public String login() {
        log.info("Login page");
        return "login";
    }

    @GetMapping("/403")
    public String error() {
        log.info("403 page");
        return "403";
    }

    @GetMapping("/main")
    public String main() {
        log.info("main page");
        return "main";
    }

    @GetMapping("/add")
    public String add(Model model) {
        log.info("add page");
        productService.addNewProduct(new ProductDto(1, "Banana", 13.2));
        return "add";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        log.info("showAll");
        StringBuilder stringBuilder = new StringBuilder();
        productService.findAll().forEach(p -> stringBuilder.append(p.toString()));

        model.addAttribute("products", stringBuilder.toString());
        return "showAll";
    }

    @GetMapping("/showThird")
    public String showThird(Model model) {
        log.info("showThird");

        model.addAttribute("thirdProduct", productService.findById(3).toString());
        return "showThird";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        log.info("delete");

        productService.deleteProduct(2);
        return "delete";
    }

}
