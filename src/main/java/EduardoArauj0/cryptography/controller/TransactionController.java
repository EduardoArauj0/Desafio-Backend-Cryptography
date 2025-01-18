package EduardoArauj0.cryptography.controller;

import org.stringframework.web.bind.annotation.DeleteMapping;
import org.stringframework.web.bind.annotation.GetMapping;
import org.stringframework.web.bind.annotation.PathVariable;
import org.stringframework.web.bind.annotation.PostMapping;
import org.stringframework.web.bind.annotation.PutMapping;
import org.stringframework.web.bind.annotation.RequestBody;
import org.stringframework.web.bind.annotation.RequestParam;
import org.stringframework.web.bind.annotation.RestController;

import main.java.EduardoArauj0.cryptography.controller.dto.TransactionResponse;
import main.java.EduardoArauj0.cryptography.controller.dto.UpdateTransactionRequest;
import main.java.EduardoArauj0.cryptography.service.CreateTransactionRequest;
import main.java.EduardoArauj0.cryptography.service.TransactionService;

public class TransactionController {

    @RestController
    @RequestMapping(value = "/transactions")
    public class TransactionController {

        private final TransactionService service;

        public TransactionController(TransactionService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<Void> create(@RequestBody CreateTransactionRequest request) {
            service.create(request);
            return ResponseEntity.ok().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Void> update(@PathVariable(value = "id") Long id,
                @RequestBody UpdateTransactionRequest request) {
            service.update(id, request);
            return ResponseEntity.noContent().build();
        }

        @GetMapping
        public ResponseEntity<Page<TransactionResponse>> listAll(
                @RequestParam(name = "page", defaultValue = "0") Integer page,
                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
            var body = service.listAll(page, pageSize);
            return ResponseEntity.ok(body);
        }

        @GetMapping("/{id}")
        public ResponseEntity<TransactionResponse> findById(@PathVariable(value = "id") Long id) {
            var body = service.findById(id);
            return ResponseEntity.ok(body);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }
}
