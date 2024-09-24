package com.booksystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chapter; // VALOR INFORMADO SOMENNTE QUANDO HOUVER UM NOVO PARÁGRAFO INICIADO

    @Column(length = 2000) // MÁXIMO DE CONTEÚDO PERMITIDO POR PÁGINA EM CARÁCTERES
    private String content;

}
