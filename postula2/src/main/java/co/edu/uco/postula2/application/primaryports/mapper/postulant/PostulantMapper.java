package co.edu.uco.postula2.application.primaryports.mapper.postulant;

import co.edu.uco.postula2.application.primaryports.dto.commons.DocumentTypeDTO;
import co.edu.uco.postula2.application.primaryports.dto.postulant.PostulantDTO;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostulantMapper {

    PostulantMapper INSTANCE = Mappers.getMapper(PostulantMapper.class);

    @Mapping(target = "documentType", expression = "java(mapDocumentType(domain.getDocumentType()))")
    PostulantDTO toDto(PostulantDomain domain);

    List<PostulantDTO> toDto(List<PostulantDomain> domains);

    default DocumentTypeDTO mapDocumentType(DocumentTypeDomain documentTypeDomain) {
        if (documentTypeDomain == null) {
            return DocumentTypeDTO.create();
        }
        return DocumentTypeDTO.create(documentTypeDomain.getId(), documentTypeDomain.getNombre());
    }
}
