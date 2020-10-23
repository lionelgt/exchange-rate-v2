package pe.com.bcp.exchangerate.context.exchangerate.application;

import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateRequest;
import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateResponse;

public interface ExchangeRateApplication {
    ExchangeRateResponse getExchangeRate(ExchangeRateRequest exchangeRateRequest);
    ExchangeRateResponse saveExchangeRate(ExchangeRateRequest exchangeRateRequest);
}
