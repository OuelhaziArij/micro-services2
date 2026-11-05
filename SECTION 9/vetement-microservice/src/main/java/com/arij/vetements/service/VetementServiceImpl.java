package com.arij.vetements.service;

import com.arij.vetements.dto.APIResponseDTO;
import com.arij.vetements.dto.CollectionDTO;
import com.arij.vetements.dto.VetementDTO;
import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VetementServiceImpl implements VetementService {

    @Autowired
    private VetementRepository vetementRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public APIResponseDTO getVetementById(Long id) {
        Vetement vetement = vetementRepository.findById(id).get();

        CollectionDTO collectionDTO = webClient.get()
                .uri("http://localhost:8080/api/collections/" + vetement.getColCode())
                .retrieve()
                .bodyToMono(CollectionDTO.class)
                .block();

        VetementDTO vetementDTO = new VetementDTO(
                vetement.getId(),
                vetement.getName(),
                vetement.getMarque(),
                vetement.getColCode()
        );

        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setVetement(vetementDTO);
        apiResponseDTO.setCollection(collectionDTO);
        return apiResponseDTO;
    }
}