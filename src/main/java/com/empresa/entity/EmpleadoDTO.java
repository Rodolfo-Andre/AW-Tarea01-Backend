package com.empresa.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDTO {
  private String nombres;
  private int estado;
  private int idPais;
  private long fechaNacimiento;
}
