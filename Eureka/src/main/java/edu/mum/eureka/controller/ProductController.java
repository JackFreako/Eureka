package edu.mum.eureka.controller;

import edu.mum.eureka.domain.Product;
import edu.mum.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping({"", "/all"})
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.GET)
    public String searchProduct(Model model, @RequestParam("name") String name, @RequestParam("desc") String description, @RequestParam("min") double minPrice, @RequestParam("max") double maxPrice) {
        model.addAttribute("name", name);
        model.addAttribute("min", minPrice);
        model.addAttribute("max", maxPrice);
        model.addAttribute("desc", description);
        model.addAttribute("products", productService.findProductByCriteria(name, description, minPrice, maxPrice));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(Model model, @RequestParam("id") Long id) {

        Product product = productService.findOne(id);
        model.addAttribute("product", product);

        return "product";
    }

    @RequestMapping("/delete")
    public String removeProductById(Model model, @RequestParam("id") Long id) {
        productService.remove(id);

        return "redirect:/products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        try {
            productService.save(productToBeAdded);
        } catch (Exception up) {
            System.out.println("Transaction Failed!!!");

        }

        return "redirect:/products";
    }


}
