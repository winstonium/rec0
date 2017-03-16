/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.afcoop.rec.controller;

import bo.afcoop.rec.dto.AdmUsuario;
import bo.afcoop.rec.service.AdmUsuarioService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Winston
 */
//@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping(value="/")
public class AdmUsuarioController {

    @Autowired
    private AdmUsuarioService admUsuarioService;

    @RequestMapping("/usuarios")
    public List<AdmUsuario> user() {
        List<AdmUsuario> admUsuarios = admUsuarioService.listarAdmUsuarios();
        HashMap model = new HashMap();
        model.put("admUsuarios", admUsuarios);
        System.out.println("WIN: Listando Usuarios.");
        return admUsuarios;
    }
    @RequestMapping(value="/usuario/{idAdmUsuario}", method = RequestMethod.GET)
    public AdmUsuario doObtenerUsuario(@PathVariable("idAdmUsuario") Integer idAdmUsuario) {
        AdmUsuario admUsuario=new AdmUsuario();
        admUsuario.setIdAdmUsuario(idAdmUsuario);
        admUsuario = admUsuarioService.obtenerUsuario(admUsuario);
        return admUsuario;
    }
}