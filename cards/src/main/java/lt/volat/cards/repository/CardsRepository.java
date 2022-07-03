package lt.volat.cards.repository;

import lt.volat.cards.model.Cards;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsRepository extends CrudRepository<Cards, Long> {
    Optional<List<Cards>> findByCustomerId(int customerId);
}
