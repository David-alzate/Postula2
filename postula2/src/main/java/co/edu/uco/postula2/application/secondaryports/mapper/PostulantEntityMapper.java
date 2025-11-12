package co.edu.uco.postula2.application.secondaryports.mapper;

import co.edu.uco.postula2.application.secondaryports.entity.postulant.PostulantEntity;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostulantEntityMapper {

    PostulantEntityMapper INSTANCE = Mappers.getMapper(PostulantEntityMapper.class);

    PostulantEntity toEntity(PostulantDomain domain);

    List<PostulantDomain> toDomainCollection(List<PostulantEntity> stateEntities);
}
