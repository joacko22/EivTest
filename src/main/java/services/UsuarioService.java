package services;

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

import models.Usuarios;
import repositorys.UsuariosRepository;

@Service
public class UsuarioService implements UserDetailsService {
	@Autowired
	UsuariosRepository userRepo;

	@Transactional
	public Usuarios guardar(Usuarios user) {
		user.setHashed(new BCryptPasswordEncoder().encode(user.getHashed()));
		return userRepo.save(user);
	}

	@Transactional
	public Usuarios update(Integer id, Usuarios user) throws Exception {
		user = findByid(id);
		user.setHashed(new BCryptPasswordEncoder().encode(user.getHashed()));
		return userRepo.save(user);

	}

	public Usuarios alta(Integer id) throws Exception {
		Usuarios entidad = findByid(id);
		entidad.setActivo(true);
		return userRepo.save(entidad);
	}

	public Usuarios baja(Integer id) throws Exception {
		Usuarios entidad = findByid(id);
		entidad.setActivo(true);
		return userRepo.save(entidad);
	}

	@Transactional
	public void eliminar(Integer id) {
		userRepo.deleteById(id);
	}

	public Usuarios findByid(Integer id) throws Exception {
		Optional<Usuarios> res = userRepo.findById(id);
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new Exception("no existe un Usuario con ese ID");
		}
	}

	@Transactional(readOnly = true)
	public List<Usuarios> obtenerTodos() {
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios user = userRepo.findByUser(username);
		if (user != null) {
			List<GrantedAuthority> permisos = new ArrayList<>();
			GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + user.getRol().toString());
			permisos.add(p);
			
		
		return new User(user.getNombreUsuario(),user.getHashed(),permisos);
	}
		return null;
	}
}
