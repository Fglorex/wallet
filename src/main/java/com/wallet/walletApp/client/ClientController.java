package com.wallet.walletApp.client;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientService service;
    @Autowired
    private ClientRepository rep;
    @GetMapping("/create")
    public String createAWallet(ModelAndView model){
        model.addObject("client", new Client());
        return "create";
    }
    @PostMapping("/create")
    public String clientAdd (@RequestParam String userName, @RequestParam String email, ModelAndView model){
        Client client = new Client();
        client.setUserName(userName);
        client.setEmail(email);
        client.setBalance(0L);
        rep.save(client);
        return "redirect:/";
    }
    @GetMapping("/balance")
    public String balanceCheck(ModelAndView model){
        model.addObject("balance", new Client());
        return "balance";
    }
    @PostMapping("/balance")
    public String checkBalance (@RequestParam Long id, ModelAndView model){
        return "redirect:/";
    }

    @GetMapping("/deposit")
    public String depositUpdate(ModelAndView model){
        model.addObject("deposit", new Client());
        return "deposit";
    }
    @PostMapping("/deposit")
    public String deposit (@RequestParam Long id, ModelAndView model){
        return "redirect:/";
    }
    @GetMapping("/withdrow")
    public String withdrowUpdate(ModelAndView model){
        model.addObject("withdrow", new Client());
        return "withdrow";
    }
    @PostMapping("/withdrow")
    public String withdrow (@RequestParam Long id, ModelAndView model){
        return "redirect:/";
    }
}
