package com.empresa.entity;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter
@Setter
public class Empleado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idEmpleado;
  private String nombres;
  private int estado;
  @ManyToOne
  @JoinColumn(name = "idPais")
  private Pais pais;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Temporal(TemporalType.DATE)
  @CreatedDate
  private Date fechaRegistro = new Date();
}
