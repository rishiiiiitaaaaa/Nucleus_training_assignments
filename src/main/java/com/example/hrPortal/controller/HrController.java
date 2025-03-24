package com.example.hrPortal.controller;

import com.example.hrPortal.model.Hr;
import com.example.hrPortal.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500") // Allow frontend requests
@RestController
@RequestMapping("/api/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateHr(@RequestBody Hr hr) {
        Optional<Hr> authenticatedHr = hrService.authenticateHr(hr.getHrUsername(), hr.getHrPassword());

        if (authenticatedHr.isPresent()) {
            return ResponseEntity.ok(Collections.singletonMap("message", "Login Successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Invalid Credentials"));
        }
    }
}