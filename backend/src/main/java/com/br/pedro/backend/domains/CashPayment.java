package com.br.pedro.backend.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class CashPayment extends Payment{

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date dueDate;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date payDay;
}
