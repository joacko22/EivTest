/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apirest.eivtest.controllers;
import com.apirest.eivtest.models.Usuario;
import com.apirest.eivtest.services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author usuario
 *//**
 *
 * @author usuario
 */
public class UsuarioController implements controladorInteface<Usuario> {

    @Autowired
    private UsuarioService usuarioServicio;
    @Override
    public List<Usuario> list() throws Exception {
        return usuarioServicio.obtenerTodos();
        
    }

    public Usuario getOne(Integer id) throws Exception {
        
        return usuarioServicio.getOne(id);
    }

    @Override
    public Usuario create(Usuario model) throws Exception {
       return usuarioServicio.guardar(model);
    }

    @Override
    public Usuario edit(Usuario model) throws Exception {
       return usuarioServicio.update(model);
    }

    @Override
    public void delete(Integer id) throws Exception {
          usuarioServicio.eliminar(id);
    }

}
