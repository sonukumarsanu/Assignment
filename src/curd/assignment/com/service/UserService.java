package curd.assignment.com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import curd.assignment.com.model.User;

@Service
public interface UserService {

	User createUser(User user);

	User getUserById(int id) throws Exception;

	User updateUserById(int id, User user) throws Exception;;

	void deleteUserById(int id) throws Exception;

	List<User> getUsers();

}
