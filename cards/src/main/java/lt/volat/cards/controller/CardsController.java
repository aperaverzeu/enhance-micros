/**
 *
 */
package lt.volat.cards.controller;

import lt.volat.cards.model.Cards;
import lt.volat.cards.model.Customer;
import lt.volat.cards.repository.CardsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        return cardsRepository
                .findByCustomerId(customer.getCustomerId())
                .orElseThrow();
    }
}
