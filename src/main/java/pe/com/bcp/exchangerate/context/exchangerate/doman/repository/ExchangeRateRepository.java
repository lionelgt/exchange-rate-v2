package pe.com.bcp.exchangerate.context.exchangerate.doman.repository;

import org.springframework.stereotype.Repository;
import pe.com.bcp.exchangerate.context.exchangerate.doman.model.ExchangeRate;
import pe.com.bcp.exchangerate.share.type.CurrencyType;

@Repository
public interface ExchangeRateRepository {
    ExchangeRate find(CurrencyType fromCurrencyType, CurrencyType toCurrencyType);
    ExchangeRate save(ExchangeRate exchangeRate);
}
