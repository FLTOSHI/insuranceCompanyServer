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
    public ResponseEntity<DataResponse<ClientEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<ClientEntity>(true, "Найден следующий клиент", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<ClientEntity>> save(@RequestBody ClientEntity author) {
        return ResponseEntity.ok(
                new DataResponse<ClientEntity>(true, "Клиент сохранён", service.save(author)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ClientEntity client) {
        service.update(client);
        return ResponseEntity.ok(
                new BaseResponse(true, "Клиент сохранён"));
    }
}