package guru.springframework.spring6webbapp.repositories;

import guru.springframework.spring6webbapp.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}