package pe.com.bcp.exchangerate.context.exchangerate.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.bcp.exchangerate.context.exchangerate.doman.model.ExchangeRate;
import pe.com.bcp.exchangerate.context.exchangerate.doman.repository.ExchangeRateRepository;
import pe.com.bcp.exchangerate.context.exchangerate.infrastructure.dao.entity.ExchangeRateEntity;
import pe.com.bcp.exchangerate.context.exchangerate.infrastructure.dao.repository.ExchangeRateRepositoryJpa;
import pe.com.bcp.exchangerate.share.type.CurrencyType;

@Repository
@RequiredArgsConstructor
public class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private final ExchangeRateRepositoryJpa exchangeRateRepositoryJpa;

    public ExchangeRate find(CurrencyType fromCurrencyType, CurrencyType toCurrencyType){
        ExchangeRateEntity exchangeRateEntity = exchangeRateRepositoryJpa.findAllByFromCurrencyTypeAndToCurrencyType(fromCurrencyType.getCode(), toCurrencyType.getCode());
        if(exchangeRateEntity == null )
            throw new IllegalArgumentException("EXCHANGE_RATE_NOT_FOUND");
        return ExchangeRate.builder()
                .id(exchangeRateEntity.getId())
                .fromCurrencyType(CurrencyType.valueOf(exchangeRateEntity.getFromCurrencyType()))
                .toCurrencyType(CurrencyType.valueOf(exchangeRateEntity.getToCurrencyType()))
                .price(exchangeRateEntity.getPrice())
                .build();
    }

    @Override
    @Transactional
    public ExchangeRate save(ExchangeRate exchangeRate) {
        ExchangeRateEntity exchangeRateEntity = new ExchangeRateEntity();
        exchangeRateEntity.setId(exchangeRate.getId());
        exchangeRateEntity.setFromCurrencyType(exchangeRate.getFromCurrencyType().getCode());
        exchangeRateEntity.setToCurrencyType(exchangeRate.getToCurrencyType().getCode());
        exchangeRateEntity.setPrice(exchangeRate.getPrice());
        exchangeRateEntity = exchangeRateRepositoryJpa.save(exchangeRateEntity);
        return ExchangeRate.builder()
                .id(exchangeRateEntity.getId())
                .fromCurrencyType(CurrencyType.valueOf(exchangeRateEntity.getFromCurrencyType()))
                .toCurrencyType(CurrencyType.valueOf(exchangeRateEntity.getToCurrencyType()))
                .price(exchangeRateEntity.getPrice())
                .build();
    }
}
