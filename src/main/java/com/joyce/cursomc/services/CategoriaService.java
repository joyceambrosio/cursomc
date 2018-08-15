package com.joyce.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyce.cursomc.domain.Categoria;
import com.joyce.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado: " + id + ", Tipo:" + Categoria.class.getName()));
	}

	
	public Categoria insert(Categoria obj) {
		obj.setId(null); //garantir que o obj a ser inserido não é um update
		return repo.save(obj);
	}

}
