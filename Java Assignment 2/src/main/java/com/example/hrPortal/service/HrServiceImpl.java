package com.example.hrPortal.service;

import com.example.hrPortal.model.Hr;
import com.example.hrPortal.repository.HrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrRepository hrRepository;

    @Override
    public Optional<Hr> authenticateHr(String hrUsername, String hrPassword) {
        Optional<Hr> hr = hrRepository.findByHrUsername(hrUsername);
        if (hr.isPresent() && hr.get().getHrPassword().equals(hrPassword)) {
            return hr;
        }
        return Optional.empty();
    }
}