package net.javahaul.springbootforhaulmont.controller;

import net.javahaul.springbootforhaulmont.model.Bank;
import net.javahaul.springbootforhaulmont.service.BankServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    public String homePage(Model model) {
        model.addAttribute("listBank", bankServiceInterface.findAll());
        return "/bank/bank-list";
    }

    @GetMapping("/form_new_bank")
    public String newBank(Model model) {
        model.addAttribute("bank", new Bank());
        return "bank/bank-create";
    }

    @PostMapping("/save_bank")
    public String saveBank(@ModelAttribute Bank bank, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bank.getBank_id() == null ? "bank/bank-create" : "bank/bank-update";
        }
        bankServiceInterface.saveBank(bank);
        return "redirect:/bank_list";
    }

    @GetMapping("/bank-view/{bankId}")
    public String showBank(@PathVariable("bankId") UUID bankId, Model model) {
        model.addAttribute("bank", bankServiceInterface.findBankByID(bankId));
        return "bank/bank-view";

    }

    @GetMapping("/form_update_bank/{bankId}")
    public String updateFormBank(@PathVariable("bankId") UUID bankId, Model model) {
        model.addAttribute("bank", bankServiceInterface.findBankByID(bankId));
        return "bank/bank-update";
    }

    @GetMapping("delete_bank/{bankId}")
    public String deleteBank(@PathVariable("bankId") UUID bankId, Model model) {
        bankServiceInterface.deleteBankById(bankId);
        return "redirect:/bank_list";

    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}

