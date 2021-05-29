package com.br.pedro.backend.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Adress> adressList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonManagedReference
    private State state;
}
