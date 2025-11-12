package co.edu.uco.postula2.application.usecase.postulant.impl;

import co.edu.uco.postula2.application.secondaryports.entity.postulant.PostulantEntity;
import co.edu.uco.postula2.application.secondaryports.mapper.PostulantEntityMapper;
import co.edu.uco.postula2.application.secondaryports.repository.PostulantRepository;
import co.edu.uco.postula2.application.secondaryports.service.NotificationService;
import co.edu.uco.postula2.application.usecase.postulant.RegisterNewPostulant;
import co.edu.uco.postula2.application.usecase.postulant.RegisterNewPostulantRulesValidator;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewPostulantImpl implements RegisterNewPostulant {

    private final PostulantRepository repository;
    private final NotificationService notificationService;
    private final RegisterNewPostulantRulesValidator rulesValidator;

    public RegisterNewPostulantImpl(PostulantRepository repository, NotificationService notificationService, RegisterNewPostulantRulesValidator rulesValidator) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.rulesValidator = rulesValidator;
    }

    @Override
    public void execute(PostulantDomain domain) {
        rulesValidator.validate(domain);
        PostulantEntity postulantEntity = PostulantEntityMapper.INSTANCE.toEntity(domain);
        repository.save(postulantEntity);
        notificationService.notifyNewPostulant(domain);
    }
}
