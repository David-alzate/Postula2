package co.edu.uco.postula2.domain.postulant.rules.impl;

import co.edu.uco.postula2.domain.postulant.exceptions.PostulantNameLenghIsNotValidException;
import co.edu.uco.postula2.domain.postulant.rules.PostulantNameLenghIsValidRule;
import org.springframework.stereotype.Service;

@Service
public class PostulantNameLenghIsValidRuleImpl implements PostulantNameLenghIsValidRule {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 255;

    @Override
    public void validate(String data) {
        if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
            throw PostulantNameLenghIsNotValidException.create();
        }
    }
}


