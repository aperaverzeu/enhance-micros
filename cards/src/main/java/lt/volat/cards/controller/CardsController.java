package lt.volat.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lt.volat.cards.config.CardsServiceConfiguration;
import lt.volat.cards.model.Cards;
import lt.volat.cards.model.Customer;
import lt.volat.cards.model.Properties;
import lt.volat.cards.repository.CardsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {
    private final CardsRepository cardsRepository;
    private final CardsServiceConfiguration cardsServiceConfiguration;

    public CardsController(CardsRepository cardsRepository,
                           CardsServiceConfiguration cardsServiceConfiguration) {
        this.cardsRepository = cardsRepository;
        this.cardsServiceConfiguration = cardsServiceConfiguration;
    }

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        return cardsRepository
                .findByCustomerId(customer.getCustomerId())
                .orElseThrow();
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        return new ObjectMapper()
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(Properties.builder()
                        .msg(cardsServiceConfiguration.getMsg())
                        .buildVersion(cardsServiceConfiguration.getBuildVersion())
                        .mailDetails(cardsServiceConfiguration.getMailDetails())
                        .activeBranches(cardsServiceConfiguration.getActiveBranches())
                        .build());
    }
}
