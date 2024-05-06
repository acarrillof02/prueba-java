package org.example.prices.infrastructure.controller.mapper;


import org.example.prices.domain.model.Price;
import org.example.prices.infrastructure.controller.vm.PriceVm;

public class PriceVmMapper {

    public PriceVm toVm(final Price entity){
        if (entity == null) {
            return null;
        }
        return new PriceVm(
                entity.getProduct() == null
                    ? null
                    : entity.getProduct().getId()
                , entity.getBrand() == null
                    ? null
                    : entity.getBrand().getId()
                , entity.getStartDate()
                , entity.getEndDate()
                , entity.getId()
                , entity.getAmount()
                , entity.getCurrency());
    }
}
