package curd.assignment.service.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import curd.assignment.com.model.User;
import curd.assignment.com.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserServiceTest.class, secure = false)
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void addUserTest() {
		User user = new User(null, "Test", "User", "test@gamail.com", 411052, new Date(02 - 11 - 1989), true);
		User response = userService.createUser(user);
		user.setId(1);
		Assert.assertNotNull(response);
		Assert.assertEquals(response, user);
	}

	@Test
	public void upadteUserTest() {
		User user = new User(1, "Test", "User", "test@gamail.com", 411048, new Date(02 - 11 - 1990), true);
		User response = userService.createUser(user);
		Assert.assertNotNull(response);
		Assert.assertEquals(response, user);
	}

}
