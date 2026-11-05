package com.arij.vetements.service;

import com.arij.vetements.dto.APIResponseDTO;
import com.arij.vetements.dto.VetementDTO;

public interface VetementService {
    APIResponseDTO getVetementById(Long id);
}
