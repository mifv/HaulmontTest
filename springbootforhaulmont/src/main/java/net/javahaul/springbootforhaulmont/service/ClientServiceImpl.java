package net.javahaul.springbootforhaulmont.service;

import net.javahaul.springbootforhaulmont.model.Client;
import net.javahaul.springbootforhaulmont.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientServiceInterface {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientServiceImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public Client findClient(UUID clientId) {
        return clientRepo.findById(clientId).orElse(null);
    }

    @Override
    public void deleteClientById(UUID id){
        clientRepo.deleteById(id);
    }

    @Override
    public void saveClient(Client client) { clientRepo.save(client);
    }

    @Override
    public List<Client> findBankId(UUID bankId) {
        return clientRepo.findBankId(bankId);
    }
}


