package com.arij.vetements.restControllers;

import com.arij.vetements.dto.APIResponseDTO;
import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import com.arij.vetements.service.VetementService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vetements")
@RequiredArgsConstructor
public class VetementController {

    private final VetementService vetementService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getVetementById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(vetementService.getVetementById(id), HttpStatus.OK);
    }

    @Bean
    CommandLineRunner commandLineRunner(VetementRepository vetementRepository) {
        return args -> {
            vetementRepository.save(Vetement.builder()
                    .Name("Robe")
                    .Marque("Zara")
                    .colCode("ETE")
                    .build());
        };
    }
}