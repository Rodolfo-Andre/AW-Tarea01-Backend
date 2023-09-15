package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.entity.Empleado;
import com.empresa.entity.EmpleadoDTO;
import com.empresa.entity.Pais;
import com.empresa.service.EmpleadoService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/empleado")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpleadoController {
  @Autowired
  private EmpleadoService service;

  @PostMapping
  @ResponseBody
  public ResponseEntity<?> insertaEmpleado(@RequestBody EmpleadoDTO objEmpleadoDTO) {
    HashMap<String, String> mensaje = new HashMap<>();

    Empleado objEmpleado = new Empleado();
    objEmpleado.setNombres(objEmpleadoDTO.getNombres());
    objEmpleado.setEstado(objEmpleadoDTO.getEstado());

    Pais pais = new Pais();
    pais.setIdPais(objEmpleadoDTO.getIdPais());
    objEmpleado.setPais(pais);

    objEmpleado.setFechaNacimiento(new Date(objEmpleadoDTO.getFechaNacimiento()));

    Empleado objSalida = service.insertaEmpleado(objEmpleado);

    if (objSalida == null) {
      mensaje.put("mensaje", "Error en el registro");
    } else {
      mensaje.put("mensaje", "Se ha registrado el empleado de ID " + objSalida.getIdEmpleado());
    }
    return ResponseEntity.ok(mensaje);
  }
}
