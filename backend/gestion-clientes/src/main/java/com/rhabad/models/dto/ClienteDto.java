package com.rhabad.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
