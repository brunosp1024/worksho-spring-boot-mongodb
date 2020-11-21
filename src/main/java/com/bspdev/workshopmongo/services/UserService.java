package com.bspdev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bspdev.workshopmongo.domain.User;
import com.bspdev.workshopmongo.dto.UserDTO;
import com.bspdev.workshopmongo.repositories.UserRepository;
import com.bspdev.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); //Se não encontrar objeto, lança uma exceção.
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		return repo.save(newObj);
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
