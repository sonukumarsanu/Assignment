package curd.assignment.com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import curd.assignment.com.model.User;

@Service
public class UserServiceImpl implements UserService {
	private Map<Integer, User> users = new HashMap<Integer, User>();
	private int id = 0;

	@Override
	public User createUser(User user) {
		int userId = id + 1;
		User nUser = new User(userId, user.getfName(), user.getlName(), user.getEmail(), user.getPinCode(),
				user.getDob(), user.isActive());
		users.put(userId, nUser);
		return nUser;
	}

	@Override
	public User getUserById(int id) throws Exception {
		User user = users.get(id);
		if (user == null) {
			throw new Exception("User Not Found By userId:" + id);
		}
		return user;
	}

	@Override
	public User updateUserById(int id, User user) throws Exception {
		User eUser = users.get(id);
		if (eUser == null) {
			throw new Exception("User Not Found By userId:" + id);
		}
		eUser.setPinCode(user.getPinCode());
		eUser.setDob(user.getDob());
		users.put(eUser.getId(), eUser);
		return eUser;
	}

	@Override
	public void deleteUserById(int id) throws Exception {
		User eUser = users.get(id);
		if (eUser == null) {
			throw new Exception("User Not Found By userId:" + id);
		}
		users.remove(eUser.id);
	}

	@Override
	public List<User> getUsers() {
		List<User> userList = new ArrayList<User>();
		for (Integer userId : users.keySet()) {
			userList.add(users.get(userId));
		}
		return userList;
	}

}
