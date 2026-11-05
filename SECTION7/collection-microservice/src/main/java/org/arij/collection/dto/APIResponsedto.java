package org.arij.collection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponsedto {
    private CollectionDTO collection;
    private List<VetementDTO> vetements;
}