package pe.com.bcp.exchangerate.context.exchangerate.infrastructure.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.bcp.exchangerate.context.exchangerate.infrastructure.dao.entity.ExchangeRateEntity;


@Repository
public interface ExchangeRateRepositoryJpa extends JpaRepository<ExchangeRateEntity, Long> {
    ExchangeRateEntity findAllByFromCurrencyTypeAndToCurrencyType(String fromCurrencyType, String toCurrencyType);
}
