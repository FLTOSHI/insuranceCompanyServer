package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.ClientEntity;
import edu.fltoshi.studypractic_2024.entity.InsuranceEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
@Tag(name = "Клиенты", description = "Контроллер, отвечающий за работу с данными клиентов.")
public class ClientController {
    private final ClientService service;

    @Operation(summary = "2. Создать клиента в базе данных", description = "Позволяет создать нового клиента в базе данных.")
    @PostMapping
    public ResponseEntity<DataResponse<ClientEntity>> save(@RequestBody ClientEntity client) {
        return ResponseEntity.ok(new DataResponse<ClientEntity>(true, "Клиент сохранён.", service.save(client)));
    }

    @Operation(summary = "3/7.Удалить клиента из базы / Удалить информацию о клиенте", description = "Позволяет удалить информацию о указанном клиенте.")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Клиент удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

//     Ambiguous mapping
    @Operation(summary = "4. Обновить данные о клиенте", description = "Позволяет заново получить информацию о клиенте по его ID, если она была изменена.")
    @GetMapping("/getInfoById")
    public ResponseEntity<BaseResponse> getClientInfoById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<List<ClientEntity>>(true, "Найдена возможно новая информация по:", service.getById(id)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "5. Получить данные о клиенте в базе", description = "Позволяет получить данные конкретного клиента по его ID.")
    @GetMapping
    public ResponseEntity<BaseResponse> byId(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<ClientEntity>(true, "Найден следующий клиент", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(
                    new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "6. Изменить информацию о клиенте в базе данных", description = "Позволяет изменить информацию о указанном клиенте.")
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

    @Operation(summary = "20. Получить список клиентов страховой компании", description = "Позволяет получить список клиентов компании.")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<ClientEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<ClientEntity>(true, "Список клиентов", service.findAll()));
    }

    @Operation(summary = "21. Получить список клиентов, оформивших ОСАГО", description = "Позволяет получить список всех клиентов компании, оформивших ОСАГО.")
    @GetMapping("/getOsago")
    public ResponseEntity<ListResponse<InsuranceEntity>> getByOsago(Boolean osago) {
        return ResponseEntity.ok(new ListResponse(true, "Клиенты со страхованием ОСАГО: ", service.getAllByOsago(osago)));
    }

    @Operation(summary = "22. Получить список клиентов, оформивших страхование имущества", description = "Позволяет получить список всех клиентов компании, оформивших страхование имущества.")
    @GetMapping("/getProperty")
    public ResponseEntity<ListResponse<InsuranceEntity>> getByProperty(Boolean property) {
        return ResponseEntity.ok(new ListResponse(true, "Клиенты со страхованием имущества: ", service.getAllByProperty(property)));
    }

    @Operation(summary = "23. Получить список клиентов, оформивших медицинскую страховку", description = "Позволяет получить список всех клиентов компании, оформивших медицинскую страховку.")
    @GetMapping("/getMedical")
    public ResponseEntity<ListResponse<InsuranceEntity>> getByMedical(Boolean medical) {
        return ResponseEntity.ok(new ListResponse(true, "Клиенты со медицинским страхованием: ", service.getAllByMedical(medical)));
    }

    @Operation(summary = "24. Получить список клиентов, оформивших страхование жизни", description = "Позволяет получить список всех клиентов компании, оформивших страхование жизни.")
    @GetMapping("/getLife")
    public ResponseEntity<ListResponse<InsuranceEntity>> getByLife(Boolean life) {
        return ResponseEntity.ok(new ListResponse(true, "Клиенты со страхованием жизни: ", service.getAllByLife(life)));
    }
}