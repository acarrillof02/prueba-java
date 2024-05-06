package org.example.prices.infrastructure.controller;

import org.example.prices.domain.caseuse.GetPriceCaseUse;
import org.example.prices.infrastructure.controller.mapper.PriceVmMapper;
import org.example.prices.infrastructure.controller.vm.PriceVm;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping ("api/v1")
public class PriceController {

    private final GetPriceCaseUse getPriceCaseUse;

    public PriceController(GetPriceCaseUse getPriceCaseUse) {
        this.getPriceCaseUse = getPriceCaseUse;
    }

    @GetMapping("/price")
    @Transactional(readOnly = true)
    public ResponseEntity<PriceVm> getPrice(
            @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) final LocalDateTime date,
            @RequestParam(value = "productId") final Long productId,
            @RequestParam(value = "brandId") final Long brandId) {
        final PriceVmMapper mapper = new PriceVmMapper();
        return this.getPriceCaseUse.getPrice(date, productId, brandId)
                .map(price -> new ResponseEntity<>(mapper.toVm(price), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
