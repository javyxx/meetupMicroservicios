package es.paradigma.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paradigma.arquitecture.event.EventBus;
import com.paradigma.arquitecture.event.RemoteEvent;

import es.paradigma.service.user.domain.User;
import es.paradigma.service.user.service.UserService;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private EventBus eventBus;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@PreAuthorize("@permissions.allowAny('user', 'read')")
	@PostFilter("@permissions.allow(filterObject.id, 'user', 'read')")
	public List<User> findAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("@permissions.allow(#id, 'user', 'read')")
	public User findById(@PathVariable("id") String id) {
		return this.userService.findById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("@permissions.allow(#id, 'user', 'delete')")
	public void delete(String id) {
		this.userService.deleteById(id);
		RemoteEvent deleteUser = new RemoteEvent("deleteUserEvent");
		deleteUser.getData().put("userId", id);
		eventBus.publishEvent(deleteUser);
	}
	

}
