package br.com.temmcode.app.services;

import java.util.Optional;

import br.com.temmcode.app.entities.Empresa;

public interface EmpresaService {

	Optional<Empresa> buscarPorCnpj(String cnpj);
	Empresa persistir(Empresa empresa);
}
