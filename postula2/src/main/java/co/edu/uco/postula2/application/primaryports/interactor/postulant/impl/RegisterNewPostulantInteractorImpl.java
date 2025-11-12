package co.edu.uco.postula2.application.primaryports.interactor.postulant.impl;

import co.edu.uco.postula2.application.primaryports.dto.postulant.RegisterNewPostulantDTO;
import co.edu.uco.postula2.application.primaryports.interactor.postulant.RegisterNewPostulantInteractor;
import co.edu.uco.postula2.application.primaryports.mapper.postulant.RegisterNewPostulantMapper;
import co.edu.uco.postula2.application.usecase.postulant.RegisterNewPostulant;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterNewPostulantInteractorImpl implements RegisterNewPostulantInteractor {

    private final RegisterNewPostulant registerNewPostulant;

    public RegisterNewPostulantInteractorImpl(RegisterNewPostulant registerNewPostulant) {
        this.registerNewPostulant = registerNewPostulant;
    }

    @Override
    public void execute(RegisterNewPostulantDTO data) {
        PostulantDomain domain = RegisterNewPostulantMapper.INSTANCE.toDomain(data);
        registerNewPostulant.execute(domain);
    }
}
