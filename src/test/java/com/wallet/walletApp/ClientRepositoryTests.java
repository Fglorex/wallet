package com.wallet.walletApp;

import com.wallet.walletApp.client.Client;
import com.wallet.walletApp.client.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ClientRepositoryTests {
    @Autowired
    private ClientRepository rep;

    @Test
    public void testAddNew(){
        Client client = new Client();
        client.setUserName("Jessica");
        client.setBalance(5000L);
        client.setEmail("jessica@gmail.com");
        Client savedClient = rep.save(client);
        Assertions.assertNotNull(savedClient);
        Assertions.assertTrue(savedClient.getId() > 0);
    }
    @Test
    public void testUpdateDeposit(){
        Long id = 1L;
        Optional<Client> optionalClient = rep.findById(id);
        Client client = optionalClient.get();
        client.setBalance(client.getBalance()+1000L);
        rep.save(client);
        Client updatedClient = rep.findById(id).get();
        Assertions.assertTrue(updatedClient.getBalance().equals(client.getBalance()));
    }
    @Test
    public void testUpdateWithdrow(){
        Long id = 1L;
        Optional<Client> optionalClient = rep.findById(id);
        Client client = optionalClient.get();
        client.setBalance(client.getBalance()-1000L);
        rep.save(client);
        Client updatedClient = rep.findById(id).get();
        Assertions.assertTrue(updatedClient.getBalance().equals(client.getBalance()));
    }
    @Test
    public void testGet(){
        Long id = 1L;
        Optional<Client> optionalClient = rep.findById(id);
        Assertions.assertNotNull(optionalClient);
        System.out.println(optionalClient.get());
    }

}
