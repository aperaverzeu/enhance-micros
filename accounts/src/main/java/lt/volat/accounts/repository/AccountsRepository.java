package lt.volat.accounts.repository;

import lt.volat.accounts.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(int customerId);
}
