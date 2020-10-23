package pe.com.bcp.exchangerate.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Calendar;

@ControllerAdvice
public class ExchangeRateResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SuppressWarnings("unchecked")
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (request.getURI().getPath().startsWith("/api/") && !(body instanceof ExchangeRateResponseEntity)) {
            @SuppressWarnings("rawtypes")
            ExchangeRateResponseEntity responseEntity = new ExchangeRateResponseEntity();
            responseEntity.setData(body);
            responseEntity.setTrackingId(getTrackingId());
            return responseEntity;
        }
        return body;
    }

    protected Long getTrackingId(){
       return Calendar.getInstance().getTimeInMillis();
    };

}
