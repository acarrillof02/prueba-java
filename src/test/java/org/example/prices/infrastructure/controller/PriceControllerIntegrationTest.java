package org.example.prices.infrastructure.controller;

import org.example.Application;
import org.example.prices.infrastructure.controller.vm.PriceVm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.time.LocalDateTime;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void test1(){
        final PriceVm priceVm = new PriceVm(35455l
                , 1l
                , LocalDateTime.parse("2020-06-14T00:00:00")
                , LocalDateTime.parse("2020-12-31T23:59:59.00")
                , 1l
                , 35.50f
                , "EUR");
        final PriceVm result = this.restTemplate
                .getForObject(this.createUrl("2020-06-14T10:00:00", "35455", "1")
                        , PriceVm.class);
        Assertions.assertEquals(priceVm, result);
    }

    /**
     * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void test2(){
        final PriceVm priceVm = new PriceVm(35455l
                , 1l
                , LocalDateTime.parse("2020-06-14T15:00:00")
                , LocalDateTime.parse("2020-06-14T18:30:00")
                , 2l
                , 25.45f
                , "EUR");
        final PriceVm result = this.restTemplate
                .getForObject(this.createUrl("2020-06-14T16:00:00", "35455", "1")
                        , PriceVm.class);
        Assertions.assertEquals(priceVm, result);

    }

    /**
     * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void test3(){
        final PriceVm priceVm = new PriceVm(35455l
                , 1l
                , LocalDateTime.parse("2020-06-14T00:00:00")
                , LocalDateTime.parse("2020-12-31T23:59:59")
                , 1l
                , 35.50f
                , "EUR");
        final PriceVm result = this.restTemplate
                .getForObject(this.createUrl("2020-06-14T21:00:00", "35455", "1")
                        , PriceVm.class);
        Assertions.assertEquals(priceVm, result);
    }

    /**
     * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void test4(){
        final PriceVm priceVm = new PriceVm(35455l
                , 1l
                , LocalDateTime.parse("2020-06-15T00:00:00")
                , LocalDateTime.parse("2020-06-15T11:00:00")
                , 3l
                , 30.50f
                , "EUR");
        final PriceVm result = this.restTemplate
                .getForObject(this.createUrl("2020-06-15T10:00:00", "35455", "1")
                        , PriceVm.class);
        Assertions.assertEquals(priceVm, result);
    }

    /**
     * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
     */
    @Test
    void test5(){
        final PriceVm priceVm = new PriceVm(35455l
                , 1l
                , LocalDateTime.parse("2020-06-15T16:00:00")
                , LocalDateTime.parse("2020-12-31T23:59:59")
                , 4l
                , 38.95f
                , "EUR");
        final PriceVm result = this.restTemplate
                .getForObject(this.createUrl("2020-06-16T21:00:00", "35455", "1")
                        , PriceVm.class);
        Assertions.assertEquals(priceVm, result);
    }

    private String createUrl(String date, String productId, String brandId ) {
        return "http://localhost:" + port + "/api/v1/price?date=" + date
                + "&productId=" + productId + "&brandId=" + brandId;
    }
}