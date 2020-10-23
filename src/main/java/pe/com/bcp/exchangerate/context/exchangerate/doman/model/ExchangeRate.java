package pe.com.bcp.exchangerate.context.exchangerate.doman.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pe.com.bcp.exchangerate.share.type.CurrencyType;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ExchangeRate {
    private Long id;
    private CurrencyType fromCurrencyType;
    private CurrencyType toCurrencyType;
    private BigDecimal price;
}
