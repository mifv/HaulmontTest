package net.javahaul.springbootforhaulmont.controller;

import lombok.RequiredArgsConstructor;
import net.javahaul.springbootforhaulmont.model.Credit;
import net.javahaul.springbootforhaulmont.service.BankServiceInterface;
import net.javahaul.springbootforhaulmont.service.CreditServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
@RequiredArgsConstructor
@Controller
@RequestMapping("/credits")
public class CreditController {
    private BankServiceInterface bankServiceInterface;
    private CreditServiceInterface creditServiceInterface;

    @Autowired
    public CreditController(BankServiceInterface bankServiceInterface, CreditServiceInterface creditServiceInterface) {
        this.bankServiceInterface = bankServiceInterface;
        this.creditServiceInterface = creditServiceInterface;
    }

    @GetMapping("/credits_list/{bankId}")
    public String homePage(@PathVariable("bankId") UUID bankId, Model model) {
        model.addAttribute("listCredits", creditServiceInterface.findBankId(bankId));
        return "/bank/credit/credit-list";
    }

    @GetMapping("/show_new_credit_form/{bankId}")
    public String newCredit(Model model, @PathVariable("bankId") UUID bankId) {
        Credit credit = new Credit();
        credit.setBank(bankServiceInterface.getBank(bankId));
       model.addAttribute("credit",credit);
        return "bank/credit/credit-create";
    }

    @PostMapping("/save_credit")
    public String saveCredit(BindingResult bindingResult,@ModelAttribute("credit")@Valid Credit credit) {
        if (bindingResult.hasErrors()) {
            return credit.getId() == null
                    ? "/bank/credit/credit-create"
                    : "/bank/credit/credit-update";
        }
        UUID bankId = credit.getBank().getBank_id();
        creditServiceInterface.saveCredit(credit);
        return String.format("redirect:/credits/credits_list/%s", bankId);
    }

    @GetMapping("/show_form_for_update/{creditId}")
    public String formUpdate(@PathVariable("creditId") UUID creditId, Model model) {
        model.addAttribute("credit", creditServiceInterface.findCredit(creditId));
        return "bank/credit/credit-update";
    }

    @GetMapping("/delete_credit/{creditId}")
    public String deleteCredit(@PathVariable("creditId") UUID creditId) {
        UUID bankId = creditServiceInterface.findCredit(creditId).getBank().getBank_id();
        creditServiceInterface.deleteCredit(creditId);
        return String.format("redirect:/credits/credits_list/%s", bankId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}