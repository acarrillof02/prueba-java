package org.example.prices.infrastructure.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class PriceRepositoryJpaImpl implements PriceRepositoryJpaCustom {

    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";
    public static final String FIELD_PRODUCT_ID = "id";
    public static final String FIELD_BRAND_ID = "id";
    public static final String ENTITY_PRODUCT = "product";
    public static final String ENTITY_BRAND = "brand";
    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<PriceJpa> getPriceByDateProductIdBrandId(final LocalDateTime date, final Long productId, final Long brandId) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<PriceJpa> cq = cb.createQuery(PriceJpa.class);
        final Root<PriceJpa> priceJpaRoot = cq.from(PriceJpa.class);
        final var filters = List.of(cb.lessThanOrEqualTo(priceJpaRoot.get(FIELD_START_DATE), date)
                , cb.greaterThanOrEqualTo(priceJpaRoot.get(FIELD_END_DATE), date)
                , cb.equal(priceJpaRoot.get(ENTITY_PRODUCT).get(FIELD_PRODUCT_ID), productId)
                , cb.equal(priceJpaRoot.get(ENTITY_BRAND).get(FIELD_BRAND_ID), brandId)
        );
        cq.where(filters.toArray(new Predicate[filters.size()]));
        cq.orderBy(cb.desc(priceJpaRoot.get("priority")), cb.asc(priceJpaRoot.get("price")));
        final TypedQuery<PriceJpa> query = entityManager.createQuery(cq);
        final List<PriceJpa> pricesJpa = query.setMaxResults(1).getResultList();
        return pricesJpa == null
                    || pricesJpa.isEmpty()
                        ? Optional.empty()
                        : Optional.ofNullable(pricesJpa.get(0));
    }
}

