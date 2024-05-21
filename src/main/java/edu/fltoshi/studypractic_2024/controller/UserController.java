package edu.fltoshi.studypractic_2024.controller;

import edu.fltoshi.studypractic_2024.entity.UserEntity;
import edu.fltoshi.studypractic_2024.response.BaseResponse;
import edu.fltoshi.studypractic_2024.response.DataResponse;
import edu.fltoshi.studypractic_2024.response.ListResponse;
import edu.fltoshi.studypractic_2024.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/all")
    public ResponseEntity<ListResponse<UserEntity>> getAll() {
        return ResponseEntity.ok(
                new ListResponse<UserEntity>(true, "Список пользователей", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<DataResponse<UserEntity>> by_id(@RequestParam Long id) {
        return ResponseEntity.ok(
                new DataResponse<UserEntity>(true, "Найден следующий пользователь", service.findById(id).orElseThrow()));
    }

    @PostMapping
    public ResponseEntity<DataResponse<UserEntity>> save(@RequestBody UserEntity insurance) {
        return ResponseEntity.ok(
                new DataResponse<UserEntity>(true, "Пользователь сохранён", service.save(insurance)));
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody UserEntity insurance) {
        service.update(insurance);
        return ResponseEntity.ok(
                new BaseResponse(true, "Пользователь сохранён"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Пользователь удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}