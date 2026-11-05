package com.arij.vetements.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.arij.vetements.dto.APIResponseDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
    private VetementDTO vetement;
    private CollectionDTO collection;
}