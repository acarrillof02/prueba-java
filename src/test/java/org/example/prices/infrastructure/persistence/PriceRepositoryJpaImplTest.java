package org.example.prices.infrastructure.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.prices.infrastructure.persistence.entity.PriceJpa;
import org.example.prices.infrastructure.persistence.entity.PriceJpaMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryJpaImplTest {
    public static final String FIELD_START_DATE = "startDate";
    public static final String FIELD_END_DATE = "endDate";
    public static final String FIELD_PRODUCT_ID = "id";
    public static final String FIELD_BRAND_ID = "id";

    public static final String ENTITY_PRODUCT = "product";
    public static final String ENTITY_BRAND = "brand";

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private PriceRepositoryJpaImpl priceRepositoryImpl = new PriceRepositoryJpaImpl();

    @Test
    void shouldBeNullWhenNotExistData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 7646l;
        final Long brandId = 78534l;
        final CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        final CriteriaQuery criteriaQuery = Mockito.mock(CriteriaQuery.class);
        final Root<PriceJpa> priceJpaRoot = Mockito.mock(Root.class);
        final Path path = Mockito.mock(Path.class);
        final TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(PriceJpa.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(PriceJpa.class)).thenReturn(priceJpaRoot);
        Mockito.when(priceJpaRoot.get(FIELD_END_DATE)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(FIELD_START_DATE)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(ENTITY_PRODUCT)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(ENTITY_BRAND)).thenReturn(path);
        Mockito.when(path.get(Mockito.anyString())).thenReturn(path).thenReturn(path);
        Mockito.when(criteriaBuilder.lessThanOrEqualTo(Mockito.any(Path.class), Mockito.any(LocalDateTime.class)))
                .thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(criteriaBuilder.greaterThanOrEqualTo(Mockito.any(Path.class), Mockito.any(LocalDateTime.class))).
                thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(criteriaBuilder.equal(Mockito.any(Path.class), Mockito.any(Long.class)))
                .thenReturn(Mockito.mock(Predicate.class))
                .thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(query);
        Mockito.when(query.setMaxResults(1)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(List.of());
        final Optional<PriceJpa> result = priceRepositoryImpl.getPriceByDateProductIdBrandId(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void shouldBeNotEmptyWhenExistData() {
        final LocalDateTime date = LocalDateTime.now();
        final Long productId = 7646l;
        final Long brandId = 78534l;
        final CriteriaBuilder criteriaBuilder = Mockito.mock(CriteriaBuilder.class);
        final CriteriaQuery criteriaQuery = Mockito.mock(CriteriaQuery.class);
        final Root<PriceJpa> priceJpaRoot = Mockito.mock(Root.class);
        final Path path = Mockito.mock(Path.class);
        final TypedQuery query = Mockito.mock(TypedQuery.class);
        final PriceJpa priceJpa = PriceJpaMo.createPriceJpa();
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        Mockito.when(criteriaBuilder.createQuery(PriceJpa.class)).thenReturn(criteriaQuery);
        Mockito.when(criteriaQuery.from(PriceJpa.class)).thenReturn(priceJpaRoot);
        Mockito.when(priceJpaRoot.get(FIELD_END_DATE)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(FIELD_START_DATE)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(ENTITY_PRODUCT)).thenReturn(path);
        Mockito.when(priceJpaRoot.get(ENTITY_BRAND)).thenReturn(path);
        Mockito.when(path.get(Mockito.anyString())).thenReturn(path).thenReturn(path);
        Mockito.when(criteriaBuilder.lessThanOrEqualTo(Mockito.any(Path.class), Mockito.any(LocalDateTime.class)))
                .thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(criteriaBuilder.greaterThanOrEqualTo(Mockito.any(Path.class), Mockito.any(LocalDateTime.class))).
                thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(criteriaBuilder.equal(Mockito.any(Path.class), Mockito.any(Long.class)))
                .thenReturn(Mockito.mock(Predicate.class))
                .thenReturn(Mockito.mock(Predicate.class));
        Mockito.when(entityManager.createQuery(criteriaQuery)).thenReturn(query);
        Mockito.when(query.setMaxResults(1)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(List.of(priceJpa));
        final Optional<PriceJpa> result = priceRepositoryImpl.getPriceByDateProductIdBrandId(date, productId, brandId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(priceJpa, result.get());
    }
}