package edu.fltoshi.studypractic_2024.controller;

import com.fasterxml.jackson.annotation.JsonSetter;
import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.InsuranceService;
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
public class InsuranceController {
    private final InsuranceService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<InsuranceEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<InsuranceEntity>(true, "Список видов страховок", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<InsuranceEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<InsuranceEntity>(true, "Найден следующий вид страховки", service.findById(id).orElseThrow()));
    }

    @GetMapping("/getPrice")
    public ResponseEntity<ListResponse<InsuranceEntity>> getPricing(Integer cost){
        return ResponseEntity.ok(new ListResponse(true, "Прайс-лист видов страхования: ", service.getPricing(cost)));
    }

    @PostMapping
    public ResponseEntity<DataResponse<InsuranceEntity>> save(@RequestBody InsuranceEntity insurance) {
        return ResponseEntity.ok(
                new DataResponse<InsuranceEntity>(true, "Вид страховки сохранён", service.save(insurance)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody InsuranceEntity insurance) {
        service.update(insurance);
        return ResponseEntity.ok(
                new BaseResponse(true, "Вид страховки сохранён"));
    }

    @GetMapping("/getBlank")
    public ResponseEntity<BaseResponse> getInsuranceBlank (){
        return ResponseEntity.ok (
                new BaseResponse(true, "Фамилия: " + "Имя: " + "Отчество: " + "Вид страхования: " + "Срок действия договора: "));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Вид страхования удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}