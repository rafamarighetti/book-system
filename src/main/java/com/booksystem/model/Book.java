package com.booksystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // NÃO PERMITE LIVROS REPITIDOS
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String author;

    // OBJETO PARA INSERIR PÁGINAS EM ENTIDADE SEPARADA E ATRIBUÍDAS AO ID DO LIVRO
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book")
    public List<Page> pages;
    
    @Column(nullable = false)
    private String category;
}
