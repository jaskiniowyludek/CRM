package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Status;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Long> {

    List<Status> findAllByActive(boolean active);

}
