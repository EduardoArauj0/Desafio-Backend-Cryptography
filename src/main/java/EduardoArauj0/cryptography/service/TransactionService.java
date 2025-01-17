package main.java.EduardoArauj0.cryptography.service;

import org.springframework.stereotype.Service;

import EduardoArauj0.cryptography.entity.TransactionEntity;
import main.java.EduardoArauj0.cryptography.controller.dto.TransactionResponse;
import main.java.EduardoArauj0.cryptography.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository){
        this.repository = repository;
    }

public void create(CreateTransactionRequest request){
    var entity = new TransactionEntity();
    entity.setRawCreditCardToken(request.creditCardToken());
    entity.setRawUserDocument(request.userDocumentn());
    entity.setTransactionValue(request.value());

    repository.save(entity);
}

public Page<TransactionResponse> listAll(int page, int pageSize){
    repository.findAll(PageRequest.of(page, pageSize));
    return contrnt.map(TransactionEntity -> TransactionResponse::fromEntity);
}
}
