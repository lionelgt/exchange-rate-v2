package pe.com.bcp.exchangerate.context.exchangerate.rest.dto;

import lombok.Data;
import pe.com.bcp.exchangerate.share.type.CurrencyType;

import java.math.BigDecimal;

@Data
public class ExchangeRateRequest {
    private CurrencyType fromCurrencyType;
    private CurrencyType toCurrencyType;
    private BigDecimal amount;
    private BigDecimal price;
}
