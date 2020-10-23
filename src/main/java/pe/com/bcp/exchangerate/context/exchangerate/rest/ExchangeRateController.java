package pe.com.bcp.exchangerate.context.exchangerate.rest;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.bcp.exchangerate.context.exchangerate.application.ExchangeRateApplication;
import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateRequest;
import pe.com.bcp.exchangerate.context.exchangerate.rest.dto.ExchangeRateResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/exchange-rate")
public class ExchangeRateController {
    private final ExchangeRateApplication exchangeRateApplcation;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRateResponse getExchangeRate(
            final @RequestBody ExchangeRateRequest exchangeRateRequest) {
        Preconditions.checkNotNull(exchangeRateRequest.getAmount(), "AMOUNT_NOT_NULL");
        Preconditions.checkNotNull(exchangeRateRequest.getFromCurrencyType(), "FROM_CURRENCY_NOT_NULL");
        Preconditions.checkNotNull(exchangeRateRequest.getToCurrencyType(), "TO_CURRENCY_NOT_NULL");
        Preconditions.checkArgument(!exchangeRateRequest.getFromCurrencyType().equals(exchangeRateRequest.getToCurrencyType()), "CURRENCIES_NOT_BE_THE_SAME");
        return exchangeRateApplcation.getExchangeRate(exchangeRateRequest);
    }

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRateResponse saveExchangeRate(
            final @RequestBody ExchangeRateRequest exchangeRateRequest) {
        Preconditions.checkNotNull(exchangeRateRequest.getPrice(), "PRICE_NOT_NULL");
        Preconditions.checkNotNull(exchangeRateRequest.getFromCurrencyType(), "FROM_CURRENCY_NOT_NULL");
        Preconditions.checkNotNull(exchangeRateRequest.getToCurrencyType(), "TO_CURRENCY_NOT_NULL");
        Preconditions.checkArgument(!exchangeRateRequest.getFromCurrencyType().equals(exchangeRateRequest.getToCurrencyType()), "CURRENCIES_NOT_BE_THE_SAME");
        return exchangeRateApplcation.saveExchangeRate(exchangeRateRequest);
    }

}
