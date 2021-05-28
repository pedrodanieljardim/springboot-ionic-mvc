package com.br.pedro.backend.domains;

import com.br.pedro.backend.enums.TypeClient;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_cell")
    private String contactCell;

    @Column(name="document")
    private String document;

    @Column(name = "type_client")
    private Integer typeClient;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Adress> adressList = new ArrayList<>();
}
