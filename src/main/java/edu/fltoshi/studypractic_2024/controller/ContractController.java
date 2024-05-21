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

    @GetMapping("/all") // Получить данные по всем договорам
    public ResponseEntity<ListResponse<ContractEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ContractEntity>(true, "Список договоров", service.findAll()));
    }

    @GetMapping // Получить данные о договоре по ID
    public ResponseEntity<DataResponse<ContractEntity>> by_id(@RequestParam Long id) {
            return ResponseEntity.ok(
                    new DataResponse<ContractEntity>(true, "По запросу с идентификатором " + id + " был найден следующий договор", service.findById(id).orElseThrow()));
    }

    @GetMapping("/getTimelapse")
    public ResponseEntity<ListResponse<ContractEntity>> getTimelapses (String timelapse) {
        return ResponseEntity.ok(new ListResponse<ContractEntity>(true, "Список длительности заключённых договоров: ", service.getTimelapses(timelapse)));
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
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Страховой договор и информация о нём удалена из базы данных."));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}