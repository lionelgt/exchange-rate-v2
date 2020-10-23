package pe.com.bcp.exchangerate.context.exchangerate.rest.dto;

import lombok.Builder;
import lombok.Data;
import pe.com.bcp.exchangerate.share.type.CurrencyType;

import java.math.BigDecimal;

@Data
@Builder
public class ExchangeRateResponse {
    private BigDecimal amount;
    private BigDecimal amountWithExchangeRate;
    private CurrencyType fromCurrencyType;
    private CurrencyType toCurrencyType;
    private BigDecimal exchangeRate;
}
