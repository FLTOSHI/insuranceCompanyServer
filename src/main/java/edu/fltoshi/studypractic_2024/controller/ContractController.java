package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.ContractEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.ContractService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/contract")
@AllArgsConstructor
@Tag(name = "Страховые договора", description = "Контроллер, отвечающий за работу со страховыми договорами.")
public class ContractController {
    private final ContractService service;

    @Operation(summary = "8. Создать договор в базе", description = "Позволяет создать новый страховой договор.")
    @PostMapping
    public ResponseEntity<DataResponse<ContractEntity>> save(@RequestBody ContractEntity contract) {
        return ResponseEntity.ok(
                new DataResponse<ContractEntity>(true, "Договор сохранён", service.save(contract)));
    }

    @Operation(summary = "9. Удалить договор из базы", description = "Позволяет удалить информацию о страховом договоре.")
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

    @Operation(summary = "10. Обновить данные о страховом договоре", description = "Позволяет изменить информацию о страховом договоре.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody ContractEntity contract) {
        service.update(contract);
        return ResponseEntity.ok(
                new BaseResponse(true, "Договор сохранён"));
    }

    @Operation(summary = "11. Получить данные о договоре в базе", description = "Позволяет получить список договора по его ID.")
    @GetMapping
    public ResponseEntity<DataResponse<ContractEntity>> getInfoById(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<ContractEntity>(true, "По запросу с идентификатором " + id + " был найден следующий договор", service.findById(id).orElseThrow()));
    }

    @Operation(summary = "18. Получить данные по совершённым сделкам", description = "Позволяет получить заключенных сделок, по итогам которых были заключены договора.")
    @GetMapping("/all") // Получить данные по всем договорам
    public ResponseEntity<ListResponse<ContractEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ContractEntity>(true, "Список договоров", service.findAll()));
    }

    @Operation(summary = "19. Получить данные о совершённых сделках", description = "Позволяет получить список длительности заключённых договоров.")
    @GetMapping("/getTimelapse")
    public ResponseEntity<ListResponse<ContractEntity>> getTimelapses(String timelapse) {
        return ResponseEntity.ok(new ListResponse<ContractEntity>(true, "Список длительности заключённых договоров: ", service.getTimelapses(timelapse)));
    }


}