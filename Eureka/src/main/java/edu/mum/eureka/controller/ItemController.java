package edu.mum.eureka.controller;

import javax.validation.Valid;

import edu.mum.eureka.domain.Item;
import edu.mum.eureka.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/items")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
 
 	@RequestMapping({"","/all"})
	public String list(Model model) {
		model.addAttribute("items", itemService.findAll());
		return "ListItems";
	}
	
 	@RequestMapping("/item")
	public String getItemById(Model model, @RequestParam("id") Long id) {

		Item item = itemService.findOne(id);
		model.addAttribute("item", item);
		return "ItemDetails";
	}

	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewItemForm(@ModelAttribute("newItem") Item newItem) {
	   return "ItemForm";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewItemForm(@ModelAttribute("newItem") @Valid Item itemToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "ItemForm";
		}

 		try {
			itemService.save(itemToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/items";
	}
	
   
}
