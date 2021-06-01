package com.br.pedro.backend.domains;


import lombok.*;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class CreditCardPayment extends Payment{
    private Integer splitPrice;
}
