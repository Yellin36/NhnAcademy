package com.nhnacademy.springboot.department.contorller;

import com.nhnacademy.springboot.department.domain.Error;
import com.nhnacademy.springboot.department.exception.BadRequestException;
import com.nhnacademy.springboot.department.service.DepartmentMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/department-members")
@RequiredArgsConstructor
public class DepartmentMemberRestController {
    private final DepartmentMemberService departmentMemberService;

    @GetMapping
    public ResponseEntity<Object> getDepartmentMembers(
            @RequestHeader(value = "Accept") Optional<MediaType> accept,
            @RequestParam("departmentIds") Optional<String> departmentIds) {
        if (checkInvalidRequest(accept, departmentIds))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        return ResponseEntity
                .ok(departmentMemberService.getDepartmentMemberWithIds(departmentIds.get()));
    }

    private static boolean checkInvalidRequest(Optional<MediaType> accept,
                                               Optional<String> departmentIds) {
        if (departmentIds.isEmpty() ||
                Objects.equals(departmentIds.get(), "") ||
                accept.isEmpty()) {
            throw new BadRequestException();
        }
        return !Objects.equals(accept.get(), MediaType.APPLICATION_JSON);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> handle(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Error(
                        LocalDateTime.now(),
                        String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        ex.getMessage()));
    }

}
