package net.kube.land.offers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.kube.land.offers.dto.Offer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/kube/offers")
public class OffersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OffersController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> list() throws Exception {

        List<Offer> offers = Arrays.asList(
                new Offer("100", "1000", "100.10", "10100"),
                new Offer("200", "2000", "200.10", "20200"),
                new Offer("300", "3000", "300.10", "30300"),
                new Offer("400", "4000", "400.10", "40400")
        );

        String responseString = objectMapper.writeValueAsString(offers);

        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @RequestMapping(value = "/{offerId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getCustomer(@PathVariable("offerId") String offerId) throws Exception {

        return new ResponseEntity(new Offer(offerId, offerId + "0", offerId + ".10", "10" + offerId), HttpStatus.OK);
    }
}
