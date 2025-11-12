package co.edu.uco.postula2.application.usecase.postulant.impl;

import co.edu.uco.postula2.application.usecase.postulant.RegisterNewPostulantRulesValidator;
import co.edu.uco.postula2.domain.postulant.PostulantDomain;
import co.edu.uco.postula2.domain.postulant.rules.PostulantNameLenghIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewPostulantRulesValidatorImpl implements RegisterNewPostulantRulesValidator {

    private final PostulantNameLenghIsValidRule postulantNameLenghIsValidRule;

    public RegisterNewPostulantRulesValidatorImpl(PostulantNameLenghIsValidRule postulantNameLenghIsValidRule) {
        this.postulantNameLenghIsValidRule = postulantNameLenghIsValidRule;
    }

    @Override
    public void validate(PostulantDomain data) {
        postulantNameLenghIsValidRule.validate(data.getFirstName());
    }
}
