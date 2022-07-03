package lt.volat.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.volat.loans.config.LoansServiceConfig;
import lt.volat.loans.model.Customer;
import lt.volat.loans.model.Loans;
import lt.volat.loans.model.Properties;
import lt.volat.loans.repository.LoansRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private final LoansRepository loansRepository;
    private final LoansServiceConfig loansServiceConfig;

    public LoansController(LoansRepository loansRepository,
                           LoansServiceConfig loansServiceConfig) {
        this.loansRepository = loansRepository;
        this.loansServiceConfig = loansServiceConfig;
    }

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        return loansRepository
                .findByCustomerIdOrderByStartDtDesc(customer.getCustomerId())
                .orElseThrow();
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        return new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(Properties.builder()
                        .msg(loansServiceConfig.getMsg())
                        .buildVersion(loansServiceConfig.getBuildVersion())
                        .mailDetails(loansServiceConfig.getMailDetails())
                        .activeBranches(loansServiceConfig.getActiveBranches())
                        .build());
    }
}
