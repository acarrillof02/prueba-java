package org.example.prices.infrastructure.controller.vm;

import java.time.LocalDateTime;

public record PriceVm (Long productId, Long brandId, LocalDateTime startDate
        , LocalDateTime endDate, Long priceId, Float price, String currency){


}
