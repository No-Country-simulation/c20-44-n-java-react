package com.trendy.entidades.dtos.autenticacion;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@EqualsAndHashCode
@Getter
@Setter
@Builder

public class PaisDTO {
    private Long id_Pais;
    private String nombre_Pais;
 
}
