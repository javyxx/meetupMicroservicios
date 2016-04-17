package es.paradigma.service.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.paradigma.arquitecture.repository.AdvancedSearchRepositoryHelper;

import es.paradigma.service.user.domain.User;
import es.paradigma.service.user.domain.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AdvancedSearchRepositoryHelper advancedSearchRepositoryHelper;

	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	public void deleteById(String id) {
		this.userRepository.delete(id);
	}

	public User findById(String id) {
		return this.userRepository.findOne(id);
	}

	public List<User> findByParameters(Map<String, Object> parameters) {
		Page<User> page  = advancedSearchRepositoryHelper.findAllByParams(parameters, User.class);
		return page.getContent();
	}

}
