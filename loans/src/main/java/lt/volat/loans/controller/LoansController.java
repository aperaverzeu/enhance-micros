/**
 *
 */
package lt.volat.loans.controller;

import lt.volat.loans.model.Customer;
import lt.volat.loans.model.Loans;
import lt.volat.loans.repository.LoansRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    private final LoansRepository loansRepository;

    public LoansController(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        return loansRepository
                .findByCustomerIdOrderByStartDtDesc(customer.getCustomerId())
                .orElseThrow();
    }
}
