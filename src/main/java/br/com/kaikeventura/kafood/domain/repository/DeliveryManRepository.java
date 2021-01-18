package br.com.kaikeventura.kafood.domain.repository;

import br.com.kaikeventura.kafood.domain.entity.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Long> {
}
