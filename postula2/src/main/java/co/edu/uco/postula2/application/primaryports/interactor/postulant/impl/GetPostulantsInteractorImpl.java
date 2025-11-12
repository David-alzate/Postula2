package co.edu.uco.postula2.application.primaryports.interactor.postulant.impl;

import co.edu.uco.postula2.application.primaryports.dto.postulant.PostulantDTO;
import co.edu.uco.postula2.application.primaryports.interactor.postulant.GetPostulantsInteractor;
import co.edu.uco.postula2.application.primaryports.mapper.postulant.PostulantMapper;
import co.edu.uco.postula2.application.usecase.postulant.GetPostulants;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPostulantsInteractorImpl implements GetPostulantsInteractor {

    private final GetPostulants getPostulants;

    public GetPostulantsInteractorImpl(GetPostulants getPostulants) {
        this.getPostulants = getPostulants;
    }

    @Override
    public List<PostulantDTO> execute() {
        List<PostulantDomain> domainList = getPostulants.execute();
        return PostulantMapper.INSTANCE.toDto(domainList);
    }
}
