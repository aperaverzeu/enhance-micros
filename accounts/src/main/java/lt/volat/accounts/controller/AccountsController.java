/**
 * 
 */
package lt.volat.accounts.controller;

import lt.volat.accounts.model.Accounts;
import lt.volat.accounts.model.Customer;
import lt.volat.accounts.repository.AccountsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
	private final AccountsRepository accountsRepository;

	public AccountsController(AccountsRepository accountsRepository) {
		this.accountsRepository = accountsRepository;
	}

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		return accountsRepository
				.findByCustomerId(customer.getCustomerId())
				.orElseThrow();
	}
}
