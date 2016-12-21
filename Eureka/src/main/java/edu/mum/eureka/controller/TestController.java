package edu.mum.eureka.controller;

import edu.mum.eureka.main.TestOrder;
import edu.mum.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rahul on 12/20/16.
 */
@Controller
public class TestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping({"/testOrder"})
    public String testOrder(Model model) {
        orderService.save(TestOrder.getOrder());
        return "test";
    }
}
