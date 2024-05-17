package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.ContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/contract")
@AllArgsConstructor
public class ContractController {
    private final ContractService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<ContractEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ContractEntity>(true, "Список договоров", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<ContractEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<ContractEntity>(true, "Найден следующий договор", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<ContractEntity>> save(@RequestBody ContractEntity contract) {
        return ResponseEntity.ok(
                new DataResponse<ContractEntity>(true, "Договор сохранён", service.save(contract)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ContractEntity contract) {
        service.update(contract);
        return ResponseEntity.ok(
                new BaseResponse(true, "Договор сохранён"));
    }
}