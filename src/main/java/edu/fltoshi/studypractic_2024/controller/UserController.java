package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
@Tag(name="Пользователи", description="Контроллер, отвечающий за работу с данными пользователей.")
public class UserController {
    private final UserService service;

    @Operation(summary = "1. Получить список менеджеров отдела по работе с клиентами страховой компании", description = "Позволяет получить список пользователей системы.")
    @GetMapping("/all")
    public ResponseEntity<ListResponse<UserEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<UserEntity>(true, "Список пользователей", service.findAll()));
    }
    @Operation(summary = "Найти пользователя по идентификатору", description = "Позволяет получить пользователя по его идентификатору.")
    @GetMapping
    public ResponseEntity<DataResponse<UserEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<UserEntity>(true, "Найден следующий пользователь", service.findById(id).orElseThrow()));
    }
    @Operation(summary = "Создать нового пользователя", description = "Позволяет создать нового пользователя в системе.")
    @PostMapping
    public ResponseEntity<DataResponse<UserEntity>> save(@RequestBody UserEntity insurance) {
        return ResponseEntity.ok(
                new DataResponse<UserEntity>(true, "Пользователь сохранён", service.save(insurance)));
    }
    @Operation(summary = "Изменить пользователя", description = "Позволяет изменить логин или пароль пользователя.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody UserEntity insurance) {
        service.update(insurance);
        return ResponseEntity.ok(
                new BaseResponse(true, "Пользователь сохранён"));
    }
    @Operation(summary = "Удалить пользователя", description = "Позволяет удалить пользователя из системы.")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @GetMapping("/passname")// Работает
    public ResponseEntity<BaseResponse> check(@RequestParam String username, @RequestParam String password) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<UserEntity>(true, "Найден следующий пользователь: ",
                            service.checkUser(username,password).orElseThrow()));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));
        }
    }
}