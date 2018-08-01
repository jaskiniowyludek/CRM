package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findById(Long id);
    List<Project> findFirst5ByOrderByCreatedDesc();
    List<Project> findAllByActive(boolean active);

}
