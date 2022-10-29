/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mrm.Controller;


import com.portfolio.mrm.Dto.dtoHardySoft;
import com.portfolio.mrm.Entity.Hardysoft;
import com.portfolio.mrm.Security.Controller.Mensaje;
import com.portfolio.mrm.Service.SHardysoft;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://martinezfrontend.web.app")
@RequestMapping("/skill")
public class CHardySoft {

    @Autowired
   SHardysoft sHardySoft;

    @GetMapping("/lista")
    public ResponseEntity<List<Hardysoft>> list() {
        List<Hardysoft> list = sHardySoft.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Hardysoft> getById(@PathVariable("id") int id) {
        if (!sHardySoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Hardysoft hys = sHardySoft.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHardySoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sHardySoft.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHardySoft dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sHardySoft.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Hardysoft hys = new Hardysoft(dtohys.getNombre(), dtohys.getPorcentaje());
        sHardySoft.save(hys);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHardySoft dtohys) {
        //Validamos si existe el ID
        if (!sHardySoft.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de skills
        if (sHardySoft.existsByNombre(dtohys.getNombre()) && sHardySoft.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Hardysoft hys = sHardySoft.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());

        sHardySoft.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
