package br.com.kaikeventura.kafood.domain.repository;

import br.com.kaikeventura.kafood.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByDocument(String document);
}
