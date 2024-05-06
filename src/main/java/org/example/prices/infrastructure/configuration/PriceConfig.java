package org.example.prices.infrastructure.configuration;

import org.example.prices.domain.caseuse.GetPriceCaseUse;
import org.example.prices.application.caseuse.GetPriceCaseUseImpl;
import org.example.prices.domain.repository.PriceRepository;
import org.example.prices.infrastructure.persistence.PriceRepositoryImpl;
import org.example.prices.infrastructure.persistence.PriceRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PriceConfig {

    @Bean
    public GetPriceCaseUse getPriceCaseUse(@Autowired final PriceRepository priceRepository) {
        return new GetPriceCaseUseImpl(priceRepository);
    }

    @Bean
    public PriceRepository priceRepository(@Autowired final PriceRepositoryJpa priceRepositoryJpa) {
        return new PriceRepositoryImpl(priceRepositoryJpa);
    }

}
