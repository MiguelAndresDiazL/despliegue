package com.usta.despliegue.Rest;

import com.usta.despliegue.Entity.PersonaEntity;
import com.usta.despliegue.Service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/persona")
public class PersonaRest {
    @Autowired
    private IPersonaService iPersonaService;
    @GetMapping("/listar")
    private ResponseEntity<List<PersonaEntity>> listarPersonas(){
        return ResponseEntity.ok(iPersonaService.findAll());
    }
    @PostMapping("/crear")
    private ResponseEntity<PersonaEntity> guardar(@Validated @RequestBody PersonaEntity auto){
        try {
            iPersonaService.save(auto);
            ResponseEntity.status(200);
            return ResponseEntity.ok(auto);
        }catch (Exception e){
            System.out.println("El error es: "+ e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
        }
    }
    @DeleteMapping("/eliminar/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable("id") Long id) { //No devolverá un valor en específico
        try {
            iPersonaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println("Error → " + e);
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)).build();
        }
    }

    @PutMapping("/editar")
    private ResponseEntity<PersonaEntity> update(@RequestBody PersonaEntity persona) {
        PersonaEntity temporal = iPersonaService.update(persona);
        try {
            return ResponseEntity.created(new URI("/api/persona" + temporal.getIdpersona())).body(temporal);
        } catch (Exception e) {
            System.err.println("Error → " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
