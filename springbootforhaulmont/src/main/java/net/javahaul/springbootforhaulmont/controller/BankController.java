package net.javahaul.springbootforhaulmont.controller;

import net.javahaul.springbootforhaulmont.service.BankServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
    private final BankServiceInterface bankServiceInterface;

    public BankController(BankServiceInterface bankServiceInterface) {
        this.bankServiceInterface = bankServiceInterface;
    }

    public BankServiceInterface getBankServiceInterface() {
        return bankServiceInterface;
    }

    @GetMapping({"/", "/bank_list"})
    public String goToHomePage(Model model) {
        model.addAttribute("listBank", bankServiceInterface.findAll());
        return "/bank/bank-list";
    }


}
