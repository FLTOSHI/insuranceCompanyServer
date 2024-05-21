package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<ClientEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ClientEntity>(true, "Список клиентов", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<BaseResponse> byId(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<ClientEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(
                    new BaseResponse(false, exception.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<DataResponse<ClientEntity>> save(@RequestBody ClientEntity client) {
        return ResponseEntity.ok(new DataResponse<ClientEntity>(true, "Клиент сохранён.", service.save(client)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ClientEntity client) {
        try {
            service.update(client);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Клиент сохранён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Клиент удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}