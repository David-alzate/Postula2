package co.edu.uco.postula2.application.primaryports.mapper.commons;

import co.edu.uco.postula2.application.primaryports.dto.commons.DocumentTypeDTO;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface DocumentTypeMapper {

    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    DocumentTypeDomain toDomain(DocumentTypeDTO dto);

    List<DocumentTypeDTO> toDomain(List<DocumentTypeDomain> domain);
}
