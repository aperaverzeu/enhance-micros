package lt.volat.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.volat.accounts.config.AccountsServiceConfig;
import lt.volat.accounts.model.Accounts;
import lt.volat.accounts.model.Customer;
import lt.volat.accounts.model.Properties;
import lt.volat.accounts.repository.AccountsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
    private final AccountsRepository accountsRepository;
    private final AccountsServiceConfig accountsServiceConfig;

    public AccountsController(AccountsRepository accountsRepository,
                              AccountsServiceConfig accountsServiceConfig) {
        this.accountsRepository = accountsRepository;
        this.accountsServiceConfig = accountsServiceConfig;
    }

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return accountsRepository
                .findByCustomerId(customer.getCustomerId())
                .orElseThrow();
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        return new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(Properties.builder()
                        .msg(accountsServiceConfig.getMsg())
                        .buildVersion(accountsServiceConfig.getBuildVersion())
                        .mailDetails(accountsServiceConfig.getMailDetails())
                        .activeBranches(accountsServiceConfig.getActiveBranches())
                        .build());
    }
}
