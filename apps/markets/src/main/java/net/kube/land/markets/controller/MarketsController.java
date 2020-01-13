package net.kube.land.markets.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.kube.land.markets.dto.Market;
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
@RequestMapping("/kube/markets")
public class MarketsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketsController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> list() throws Exception {

        List<Market> markets = Arrays.asList(
                new Market("100", "1000", "100.10", "10100"),
                new Market("200", "2000", "200.10", "20200"),
                new Market("300", "3000", "300.10", "30300"),
                new Market("400", "4000", "400.10", "40400")
        );

        String responseString = objectMapper.writeValueAsString(markets);

        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @RequestMapping(value = "/{marketId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getCustomer(@PathVariable("marketId") String marketId) throws Exception {

        return new ResponseEntity(new Market(marketId, marketId + "0", marketId + ".10", "10" + marketId), HttpStatus.OK);
    }
}
