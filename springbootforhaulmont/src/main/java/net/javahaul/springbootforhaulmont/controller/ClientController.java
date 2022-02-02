package net.javahaul.springbootforhaulmont.controller;

import net.javahaul.springbootforhaulmont.model.Client;
import net.javahaul.springbootforhaulmont.service.BankServiceInterface;
import net.javahaul.springbootforhaulmont.service.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clients")
public class ClientController {
    private final ClientServiceInterface clientServiceInterface;
    private final BankServiceInterface bankServiceInterface;


    @Autowired
    public ClientController(ClientServiceInterface clientServiceInterface, BankServiceInterface bankServiceInterface) {
        this.clientServiceInterface = clientServiceInterface;
        this.bankServiceInterface = bankServiceInterface;
    }
    @GetMapping("/clients_list/{bankId}")
    public String homePage(@PathVariable("bankId") UUID bankId, Model model) {
        model.addAttribute("listClients", clientServiceInterface.findByBankId(bankId));
        return "bank/client/client-list";
    }

    @GetMapping("/show_new_client_form/{bankId}")
    public String newClient(@PathVariable("bankId") UUID bankId, Model model) {
        Client client = new Client();
        client.setBank(bankServiceInterface.getBank(bankId));
        model.addAttribute("client", client);
        return "bank/client/client-create";

    }

    @PostMapping("save_client")
    public String saveClient(@ModelAttribute Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return client.getId() == null ? "bank/client/client-create" : "bank/client/client-update";
        }
        clientServiceInterface.saveClient(client);
        return String.format("redirect:/clients/clients_list/%s", client.getBank().getBank_id());
    }

    @GetMapping("/show_form_for_update/{clientId}")
    public String updateFormClient(@PathVariable("clientId") UUID clientId, Model model) {
        model.addAttribute("client", clientServiceInterface.findClient(clientId));
        return "bank/client/client-update";
    }

    @GetMapping("delete_client/{clientId}")
    public String deleteClient(@PathVariable("clientId") UUID clientId) {
        UUID bankId = clientServiceInterface.findClient(clientId).getBank().getBank_id();
        clientServiceInterface.deleteClientById(clientId);
        return String.format("redirect:/clients/clients_list/%s", bankId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onException() {
        return "Wrong page number";
    }
}