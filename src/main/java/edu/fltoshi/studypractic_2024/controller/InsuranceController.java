package edu.fltoshi.studypractic_2024.controller;

import com.fasterxml.jackson.annotation.JsonSetter;
import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.InsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/insurance")
@AllArgsConstructor
@Tag(name = "Виды страхования", description = "Контроллер, отвечающий за работу с видами страхования.")
public class InsuranceController {
    private final InsuranceService service;

    @Operation(summary = "12. Получить прайс-лист видов страховки", description = "Позволяет получить данные по видами страхования с их ценами.")
    @GetMapping("/getPrice")
    public ResponseEntity<ListResponse<InsuranceEntity>> getPricing(Integer cost) {
        return ResponseEntity.ok(new ListResponse(true, "Прайс-лист видов страхования: ", service.getPricing(cost)));
    }

    @Operation(summary = "13. Получить бланк страхования", description = "Позволяет получить образец бланка с нужными полями для заполнения.")
    @GetMapping("/getBlank")
    public ResponseEntity<BaseResponse> getInsuranceBlank() {
        return ResponseEntity.ok(
                new BaseResponse(true, "Фамилия: " + "Имя: " + "Отчество: " + "Вид страхования: " + "Срок действия договора: "));
    }

    @Operation(summary = "14. Получить данные по видам страховок", description = "Позволяет получить все виды страховок, предоставляемые компанией.")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<InsuranceEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<InsuranceEntity>(true, "Список видов страховок", service.findAll()));
    }

    @Operation(summary = "15. Изменить данные по видам страхования", description = "Позволяет изменить данные видов страхования.")
    @PutMapping
    public ResponseEntity<BaseResponse> updateInsuranceType(@RequestBody InsuranceEntity insurance) {
        service.update(insurance);
        return ResponseEntity.ok(
                new BaseResponse(true, "Вид страховки сохранён"));
    }

    @Operation(summary = "16. Получить данные о стоимости страховок", description = "Позволяет получить данные о стоимости всех видов страховок, предоставляемых компанией.")
    @GetMapping
    public ResponseEntity<ListResponse<InsuranceEntity>> getInsurancesPrices(Integer cost) {
        return ResponseEntity.ok(
                new ListResponse<InsuranceEntity>(true, "Список видов страховок по ценам", service.findAllPrices(cost)));
    }

    // Ambiguous mapping.
    @Operation(summary = "17. Изменить данные о стоимости вида страхования", description = "Позволяет изменить цену вида страхования.")
    @PutMapping("/InsurancePrice")
    public ResponseEntity<BaseResponse> updateInsurancePrice(@RequestBody InsuranceEntity insurance) {
        service.update(insurance);
        return ResponseEntity.ok(
                new BaseResponse(true, "Вид страховки сохранён"));
    }

    @Operation(summary = "Создать новый вид страхования", description = "Позволяет создать новый вид страхования.")
    @PostMapping
    public ResponseEntity<DataResponse<InsuranceEntity>> save(@RequestBody InsuranceEntity insurance) {
        return ResponseEntity.ok(
                new DataResponse<InsuranceEntity>(true, "Вид страховки сохранён", service.save(insurance)));
    }

    @Operation(summary = "Удалить вид страхования", description = "Позволяет удалить из базы вид страхования.")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Вид страхования удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}