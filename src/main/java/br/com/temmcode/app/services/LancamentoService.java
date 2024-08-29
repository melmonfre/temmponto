package br.com.temmcode.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.temmcode.app.entities.Lancamento;

public interface LancamentoService {

	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	Optional<Lancamento> buscarPorId(Long id);
	Lancamento persistir(Lancamento lancamento);
	void remover(Long id);
	Optional<Lancamento> buscarUltimoPorFuncionarioId(Long funcionarioId);
	List<Lancamento> buscarTodosPorFuncionarioId(Long funcionarioId);
	
}
