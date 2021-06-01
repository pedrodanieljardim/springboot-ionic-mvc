package com.br.pedro.backend.domains;

import com.br.pedro.backend.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer statePayment;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
