package com.apirest.eivtest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.eivtest.models.Usuario;
import com.apirest.eivtest.repositorys.UsuariosRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuariosRepository userRepo;

    @Transactional
    public Usuario guardar(Usuario user) {
        user.setHashed(new BCryptPasswordEncoder().encode(user.getHashed()));
        return userRepo.save(user);
    }

    @Transactional
    public Usuario update(Usuario user) throws Exception {
       
        user.setHashed(new BCryptPasswordEncoder().encode(user.getHashed()));
        return userRepo.save(user);

    }

    public Usuario alta(Integer id) throws Exception {
        Usuario entidad = findByid(id);
        entidad.setActivo(true);
        return userRepo.save(entidad);
    }

    public Usuario baja(Integer id) throws Exception {
        Usuario entidad = findByid(id);
        entidad.setActivo(true);
        return userRepo.save(entidad);
    }

    @Transactional
    public void eliminar(Integer id) {
        userRepo.deleteById(id);
    }

    public Usuario findByid(Integer id) throws Exception {
        Optional<Usuario> res = userRepo.findById(id);
        if (res.isPresent()) {
            return res.get();
        } else {
            throw new Exception("no existe un Usuario con ese ID");
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodos() {
        return userRepo.findAll();
    }

    public Usuario getOne(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepo.findByUser(username);
        if (user != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + user.getRol().toString());
            permisos.add(p);

            return new User(user.getNombreUsuario(), user.getHashed(), permisos);
        }
        return null;
    }
}
