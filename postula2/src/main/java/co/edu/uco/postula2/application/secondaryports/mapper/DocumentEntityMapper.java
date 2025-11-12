package co.edu.uco.postula2.application.secondaryports.mapper;

import co.edu.uco.postula2.application.secondaryports.entity.commons.DocumentTypeEntity;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentEntityMapper {

    DocumentEntityMapper INSTANCE = Mappers.getMapper(DocumentEntityMapper.class);

    DocumentTypeEntity toEntity(DocumentTypeDomain domain);

    List<DocumentTypeDomain> toDomainCollection(List<DocumentTypeEntity> entities);
}
