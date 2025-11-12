package co.edu.uco.postula2.application.usecase.commons.impl;

import co.edu.uco.postula2.application.secondaryports.entity.commons.DocumentTypeEntity;
import co.edu.uco.postula2.application.secondaryports.mapper.DocumentEntityMapper;
import co.edu.uco.postula2.application.secondaryports.repository.DocumentTypeRepository;
import co.edu.uco.postula2.application.usecase.commons.GetDocumentType;
import co.edu.uco.postula2.domain.commons.DocumentTypeDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDocumentTypeImpl implements GetDocumentType {

    private final DocumentTypeRepository repository;

    public GetDocumentTypeImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DocumentTypeDomain> execute() {
        List<DocumentTypeEntity> entity = repository.findAll();
        return DocumentEntityMapper.INSTANCE.toDomainCollection(entity);
    }
}
