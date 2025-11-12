package co.edu.uco.postula2.application.secondaryports.repository;

import co.edu.uco.postula2.application.secondaryports.entity.commons.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, UUID> {
}
