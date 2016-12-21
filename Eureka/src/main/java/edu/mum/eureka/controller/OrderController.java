package edu.mum.eureka.controller;

import edu.mum.eureka.domain.CustomerInfo;
import edu.mum.eureka.domain.Order;
import edu.mum.eureka.domain.OrderDetail;
import edu.mum.eureka.domain.Product;
import edu.mum.eureka.service.OrderService;
import edu.mum.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
//@SessionAttributes("order")
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @RequestMapping({"", "/all"})
    public String list(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @RequestMapping(value = "/addorderdetail", method = RequestMethod.GET)
    public String getAddOrderDetail(@ModelAttribute("customerInfo") CustomerInfo customerInfo, @RequestParam("productId") Long productId, HttpServletRequest request) {
        Product product = productService.findOne(productId);
        Order order = (Order) request.getSession().getAttribute("order");
        if (order == null) {
            order = new Order();
        }
        order.setOrderDate(new Date());
        this.setOrderDetail(order, product);
        request.getSession().setAttribute("order", order);
//        model.addAttribute("order", order);
        return "addOrder";
    }

    @RequestMapping(value = "/addorderdetail", method = RequestMethod.POST)
    public String submitOrderForm(@ModelAttribute("customerInfo") @Valid CustomerInfo customerInfo, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addOrder";
        }

        Order order = (Order) request.getSession().getAttribute("order");
        if (order != null) {
            order.setCustomerInfo(customerInfo);
            orderService.save(order);

            //Once order is persisted, remove order from session.
            request.getSession().removeAttribute("order");
        } else {
            //TODO: Show no order.
        }

        return "redirect:/orders";
    }

    @RequestMapping(value = "/removeorderdetail", method = RequestMethod.GET)
    public String getRemoveOrderDetail(@ModelAttribute("customerInfo") CustomerInfo customerInfo, @RequestParam("tempId") Integer tempId, HttpServletRequest request) {
        Order order = (Order) request.getSession().getAttribute("order");
        if (order != null && order.getOrderDetails() != null) {
            order.removeOrderDetail(tempId);
        }
        return "addOrder";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewOrder(Model model, @RequestParam("id") Long id) {
        model.addAttribute("order", orderService.getOrderById(id));

        return "orderDetail";
    }

    private void setOrderDetail(Order order, Product product) {
        if (order != null && order.getOrderDetails() != null && product != null) {
            Optional<OrderDetail> orderDetailOptional = order.getOrderDetails().stream().filter(od -> product.getId() == od.getProduct().getId()).findFirst();
            if (orderDetailOptional.isPresent()) {
                orderDetailOptional.get().setQuantity(orderDetailOptional.get().getQuantity() + 1);
            } else {
                this.addNewOrderDetail(order, product);
            }
        } else {
            this.addNewOrderDetail(order, product);
        }
    }

    private void addNewOrderDetail(Order order, Product product) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setTempId(order.getNextOrderDetailNum());
        order.incNextOrderDetailNum();
        orderDetail.setQuantity(1);
        orderDetail.setPrice(product.getPrice());
        orderDetail.setProduct(product);
        order.addOrderDetail(orderDetail);
    }
}
