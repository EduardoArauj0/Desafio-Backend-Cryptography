package main.java.EduardoArauj0.cryptography.service;

import org.springframework.stereotype.Service;

import EduardoArauj0.cryptography.entity.TransactionEntity;
import main.java.EduardoArauj0.cryptography.controller.dto.TransactionResponse;
import main.java.EduardoArauj0.cryptography.controller.dto.UpdateTransactionRequest;
import main.java.EduardoArauj0.cryptography.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTransactionRequest request) {
        var entity = new TransactionEntity();
        entity.setRawCreditCardToken(request.creditCardToken());
        entity.setRawUserDocument(request.userDocumentn());
        entity.setTransactionValue(request.value());

        repository.save(entity);
    }

    public Page<TransactionResponse> findById(Long id) {
        var content = trepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return TransactionResponse.fromEntity(entity);
    }

    public Page<TransactionResponse> listAll(int page, int pageSize) {
        repository.findAll(PageRequest.of(page, pageSize));
        return contrnt.map(TransactionEntity -> TransactionResponse::fromEntity);
    }

    public void update(Long id, UpdateTransactionRequest request) {
        var entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setTransactionValue(request.value());
        repository.save(entity);
    }

    public void deleteById(Long id) {
        var entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(entity.getTransactionId());
    }
}
