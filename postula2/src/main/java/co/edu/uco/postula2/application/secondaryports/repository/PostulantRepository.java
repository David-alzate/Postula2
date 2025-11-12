package co.edu.uco.postula2.application.secondaryports.repository;

import co.edu.uco.postula2.application.secondaryports.entity.postulant.PostulantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostulantRepository extends JpaRepository<PostulantEntity, UUID> {
}
