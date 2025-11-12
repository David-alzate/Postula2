package co.edu.uco.postula2.application.primaryports.interactor.commons.impl;

import co.edu.uco.postula2.application.primaryports.dto.commons.DocumentTypeDTO;
import co.edu.uco.postula2.application.primaryports.interactor.commons.GetDocumentTypeInteractor;
import co.edu.uco.postula2.application.primaryports.mapper.commons.DocumentTypeMapper;
import co.edu.uco.postula2.application.usecase.commons.GetDocumentType;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDocumentTypeInteractorImpl implements GetDocumentTypeInteractor {

    private final GetDocumentType getDocumentType;

    public GetDocumentTypeInteractorImpl(GetDocumentType getDocumentType) {
        this.getDocumentType = getDocumentType;
    }

    @Override
    public List<DocumentTypeDTO> execute() {
        List<DocumentTypeDomain> domainList = getDocumentType.execute();
        return DocumentTypeMapper.INSTANCE.toDomain(domainList);
    }
}
