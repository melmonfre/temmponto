package br.com.temmcode.app.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.temmcode.app.entities.Funcionario;
import br.com.temmcode.app.security.JwtUserFactory;
import br.com.temmcode.app.services.FuncionarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Funcionario> funcionario = funcionarioService.buscarPorEmail(username);
		
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}
		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
