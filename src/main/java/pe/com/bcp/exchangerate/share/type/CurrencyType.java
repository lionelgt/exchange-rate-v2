package pe.com.bcp.exchangerate.share.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum  CurrencyType {
    PEN("PEN"),
    USD("USD"),
    EUR("EUR"),
    CAD("CAD");
    private final String code;
}
