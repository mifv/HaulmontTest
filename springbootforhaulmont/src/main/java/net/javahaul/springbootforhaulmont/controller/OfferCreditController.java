package net.javahaul.springbootforhaulmont.controller;

import net.javahaul.springbootforhaulmont.model.Client;
import net.javahaul.springbootforhaulmont.model.OfferCredit;
import net.javahaul.springbootforhaulmont.service.BankServiceInterface;
import net.javahaul.springbootforhaulmont.service.CalculationPaymentService;
import net.javahaul.springbootforhaulmont.service.ClientServiceInterface;
import net.javahaul.springbootforhaulmont.service.OfferCreditServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/credit_offers")
public class OfferCreditController {
    private final ClientServiceInterface clientServiceInterface;
    private final BankServiceInterface bankServiceInterface;
    private final OfferCreditServiceInterface offerCreditServiceInterface;
    private final CalculationPaymentService calculationPaymentService;

    @Autowired
    public OfferCreditController(ClientServiceInterface clientServiceInterface, BankServiceInterface bankServiceInterface, OfferCreditServiceInterface offerCreditServiceInterface, CalculationPaymentService calculationPaymentService) {
        this.clientServiceInterface = clientServiceInterface;
        this.bankServiceInterface = bankServiceInterface;
        this.offerCreditServiceInterface = offerCreditServiceInterface;
        this.calculationPaymentService = calculationPaymentService;
    }


    @GetMapping("/credit_offers_list/{clientId}")
    public String homePage(@PathVariable("clientId") UUID clientId, Model model) {
        model.addAttribute("listCreditOffers", offerCreditServiceInterface.findOfferOfCreditById(clientId));
        return "/bank/offerCredit/offerCredit-list";
    }

    @GetMapping("/show_new_credit_offer_form/{clientId}")
    public String newOfferOfCreditForm(@PathVariable("clientId") UUID clientId, Model model) {
        Client client = clientServiceInterface.findClient(clientId);
        model.addAttribute("offerOfCredit", OfferCredit.builder().client(client)
                .bank(bankServiceInterface.findBankByID(client.getBank().getBank_id())).build());
        return "/bank/offerCredit/offerCredit-create";

    }

    @PostMapping("/save_credit_offer")
    public String saveOffer(@ModelAttribute("creditOffer") OfferCredit offerOfCredit,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return offerOfCredit.getId() == null
                    ? "bank/offerCredit/offerCredit-create"
                    : "bank/offerCredit/offerCredit-update";
        }
        calculationPaymentService.collectDataAboutOfferOfCredit(offerOfCredit);
        UUID clientId = offerOfCredit.getClient().getId();
        return String.format("redirect:/credit_offers/credit_offers_list/%s", clientId);
    }

    @GetMapping("/show_form_for_update/{offerOfCreditId}")
    public String formForUpdate(@PathVariable("offerOfCreditId") UUID offerOfCreditId, Model model) {
        model.addAttribute("offerOfCredit", offerCreditServiceInterface.findOfferOfCreditById(offerOfCreditId));
        return "bank/offerCredit/offerCredit-update";
    }

    @GetMapping("/delete_credit_offer/{offerOfCreditId}")
    public String deleteOfferOfCredit(@PathVariable("offerOfCreditId") UUID offerOfCreditId) {
        UUID clientId = offerCreditServiceInterface.findOfferOfCreditById(offerOfCreditId).getClient().getId();
        offerCreditServiceInterface.deleteOfferCreditById(offerOfCreditId);
        return String.format("redirect:/credit_offers/credit_offers_list/%s", clientId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}




