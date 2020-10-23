package pe.com.bcp.exchangerate.context.exchangerate.infrastructure.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "EXCHANGE_RATE")
@Getter
@Setter
public class ExchangeRateEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long  id;
    @Column(name = "FROM_CURRENCY_TYPE")
    private String  fromCurrencyType;
    @Column(name = "TO_CURRENCY_TYPE")
    private String  toCurrencyType;
    @Column(name = "PRICE")
    private BigDecimal price;
}
