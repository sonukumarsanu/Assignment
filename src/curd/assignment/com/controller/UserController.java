package curd.assignment.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import curd.assignment.com.model.User;
import curd.assignment.com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Object> create(@RequestBody User user) {
		return new ResponseEntity<Object>(userService.createUser(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> get(@PathVariable("id") Integer id) throws Exception {
		if (id == null)
			return new ResponseEntity<Object>(userService.getUsers(), HttpStatus.OK);

		return new ResponseEntity<Object>(userService.getUserById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Object update(@PathVariable("id") int id, @RequestBody User user) throws Exception {

		return new ResponseEntity<Object>(userService.updateUserById(id, user), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("id") int id) throws Exception {
		userService.deleteUserById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
