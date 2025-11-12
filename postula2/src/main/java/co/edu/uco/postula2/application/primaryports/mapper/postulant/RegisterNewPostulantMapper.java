package co.edu.uco.postula2.application.primaryports.mapper.postulant;

import co.edu.uco.postula2.application.primaryports.dto.postulant.RegisterNewPostulantDTO;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface RegisterNewPostulantMapper {

    RegisterNewPostulantMapper INSTANCE = Mappers.getMapper(RegisterNewPostulantMapper.class);

    PostulantDomain toDomain(RegisterNewPostulantDTO dto);
}
