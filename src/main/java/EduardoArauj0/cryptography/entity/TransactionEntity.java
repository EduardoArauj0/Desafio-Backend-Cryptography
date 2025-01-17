package EduardoArauj0.cryptography.entity;

import java.beans.Transient;

import javax.annotation.processing.Generated;

import EduardoArauj0.cryptography.service.CryptoService;
import jakarta.persistence.*;

@Entity 
@Table(name = "tb_transactions")
public class TransactionEntity {


        @Id
        @Column(name = "transaction_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long transactionId;

        @Column(name = "user_document")
        private String encrypteduserDocument;

        @Column(name = "credit_card_token")
        private String encryptedcreditCardToken;

        @Column(name = "transaction_value")
        private Long transactionValue;

        @Transient
        private String rawUserDocument;

        @Transient
        private String rawCreditCardToken;
        
        public TransactionEntity() {
        }
    
        public Long getTransactionId() {
            return transactionId;
        }
    
        public void setTransactionId(Long transactionId) {
            this.transactionId = transactionId;
        }
    
        public String getEncryptedUserDocument() {
            return encryptedUserDocument;
        }
    
        public void setEncryptedUserDocument(String encryptedUserDocument) {
            this.encryptedUserDocument = encryptedUserDocument;
        }
    
        public String getEncryptedCreditCardToken() {
            return encryptedCreditCardToken;
        }
    
        public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
            this.encryptedCreditCardToken = encryptedCreditCardToken;
        }
    
        public Long getTransactionValue() {
            return transactionValue;
        }
    
        public void setTransactionValue(Long transactionValue) {
            this.transactionValue = transactionValue;
        }
    
        public String getRawUserDocument() {
            return rawUserDocument;
        }
    
        public void setRawUserDocument(String rawUserDocument) {
            this.rawUserDocument = rawUserDocument;
        }
    
        public String getRawCreditCardToken() {
            return rawCreditCardToken;
        }
    
        public void setRawCreditCardToken(String rawCreditCardToken) {
            this.rawCreditCardToken = rawCreditCardToken;
        }

        @PrePersist
        public void PrePersist(){
            this.encrypteduserDocument = CryptoService.encrypt(rawUserDocument);
            this.encryptedcreditCardToken = CryptoService.encrypt(rawCreditCardToken);
        }


        @PosLoad
        public void postLoad (){
            this.rawUserDocument = CryptoService.decrypt(encrypteduserDocument);
            this.rawCreditCardToken = CryptoService.decrypt(encryptedcreditCardToken); 
        }
}