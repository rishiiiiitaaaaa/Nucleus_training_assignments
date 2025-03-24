package com.example.hrPortal.service;

import com.example.hrPortal.model.Hr;
import java.util.Optional;

public interface HrService {
    Optional<Hr> authenticateHr(String hrUsername, String hrPassword);
}