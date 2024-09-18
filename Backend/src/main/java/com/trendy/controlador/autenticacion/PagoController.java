package com.trendy.controlador.autenticacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendy.entidades.dtos.autenticacion.PagoDTO;
import com.trendy.servicio.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {

      @Autowired
    private PagoService pagoService;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPago(@RequestBody PagoDTO pagoDTO) {
        String resultado = pagoService.procesarPago(pagoDTO);
        return ResponseEntity.ok(resultado);
    }
}
