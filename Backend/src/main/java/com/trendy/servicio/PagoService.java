package com.trendy.servicio;

import org.springframework.stereotype.Service;

import com.trendy.entidades.dtos.autenticacion.PagoDTO;

@Service
public class PagoService {
      // Simular proceso de pago
    public String procesarPago(PagoDTO pagoDTO) {
        
        return "Pago exitoso para el paquete: ";
    }

}
