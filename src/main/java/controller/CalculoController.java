package controller;

import entity.Calculo;
import entity.Resultado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CalcularService;

@RestController
@RequestMapping(value = "/calculo")
public class CalculoController {
    private CalcularService calcularService;

    @PostMapping
    public ResponseEntity<?> calcular(@RequestBody final Calculo calculo){
        Resultado resultado;
        try{
            resultado = this.calcularService.cadastrar(calculo);
            return ResponseEntity.ok("Calculo efetuado"+ resultado);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("erro" +e.getStackTrace());
        }
    }
}
