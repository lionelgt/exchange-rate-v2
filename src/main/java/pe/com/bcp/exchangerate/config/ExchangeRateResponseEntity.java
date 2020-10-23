package pe.com.bcp.exchangerate.config;

import lombok.Data;

@Data
public class ExchangeRateResponseEntity<T> {
    private Long trackingId;
    private String errorCode;
    private String message;
    private T data;
}