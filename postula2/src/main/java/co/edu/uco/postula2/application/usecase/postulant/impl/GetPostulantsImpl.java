package co.edu.uco.postula2.application.usecase.postulant.impl;

import co.edu.uco.postula2.application.secondaryports.entity.postulant.PostulantEntity;
import co.edu.uco.postula2.application.secondaryports.mapper.PostulantEntityMapper;
import co.edu.uco.postula2.application.secondaryports.repository.PostulantRepository;
import co.edu.uco.postula2.application.usecase.postulant.GetPostulants;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPostulantsImpl implements GetPostulants {

    private final PostulantRepository repository;

    public GetPostulantsImpl(PostulantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PostulantDomain> execute() {
        List<PostulantEntity> entities = repository.findAll();
        return PostulantEntityMapper.INSTANCE.toDomainCollection(entities);
    }
}
