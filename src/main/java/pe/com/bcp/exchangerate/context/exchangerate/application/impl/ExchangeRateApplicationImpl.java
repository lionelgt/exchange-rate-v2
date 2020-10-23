package pe.com.bcp.exchangerate.context.exchangerate.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.bcp.exchangerate.context.exchangerate.application.ExchangeRateApplication;
import pe.com.bcp.exchangerate.context.exchangerate.doman.model.ExchangeRate;
import pe.com.bcp.exchangerate.context.exchangerate.doman.repository.ExchangeRateRepository;
import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateRequest;
import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateResponse;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeRateApplicationImpl implements ExchangeRateApplication {

    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRateResponse getExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate exchangeRate =  exchangeRateRepository.find(exchangeRateRequest.getFromCurrencyType(), exchangeRateRequest.getToCurrencyType());
        BigDecimal amountWithExchangeRate = exchangeRateRequest.getAmount().divide(exchangeRate.getPrice(),6, BigDecimal.ROUND_HALF_EVEN);
        return ExchangeRateResponse.builder()
                .fromCurrencyType(exchangeRate.getFromCurrencyType())
                .toCurrencyType(exchangeRate.getToCurrencyType())
                .amount(exchangeRateRequest.getAmount())
                .amountWithExchangeRate(amountWithExchangeRate)
                .exchangeRate(exchangeRate.getPrice())
                .build();
    }

    public ExchangeRateResponse saveExchangeRate(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate exchangeRate =  exchangeRateRepository.find(exchangeRateRequest.getFromCurrencyType(), exchangeRateRequest.getToCurrencyType());
        exchangeRate.setPrice(exchangeRateRequest.getPrice());
        exchangeRate = exchangeRateRepository.save(exchangeRate);
        return ExchangeRateResponse.builder()
                .fromCurrencyType(exchangeRate.getFromCurrencyType())
                .toCurrencyType(exchangeRate.getToCurrencyType())
                .exchangeRate(exchangeRate.getPrice())
                .build();
    }
}
