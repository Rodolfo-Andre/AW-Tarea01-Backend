package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Empleado;
import com.empresa.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
  @Autowired
  private EmpleadoRepository empleadoRepository;

  @Override
  public Empleado insertaEmpleado(Empleado objEmpleado) {
    return empleadoRepository.save(objEmpleado);
  }
}
