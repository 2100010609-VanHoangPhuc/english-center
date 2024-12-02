package com.english_center.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.english_center.dao.impl.UserDaoImpl;
import com.english_center.entity.Users;
import com.english_center.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserDaoImpl userDaoImpl;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	private Users users;

	private Users saveUser;

	private List<Users> listUser;

	@BeforeEach
	public void setup() {
		users = Users.builder().id(1).userName("").email("").phone("")
				.build();

		saveUser = Users.builder().id(2).userName("").email("").phone("")
				.build();

		listUser = List.of(users, saveUser);
	}

	@Test
	void UserService_FindOne_ReturnsUser() throws Exception {
		when(userDaoImpl.findOne(anyInt())).thenReturn(users);
		Users userById = userServiceImpl.findOne(2);

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_FindUsersByPhone_ReturnsUser() throws Exception {
		when(userDaoImpl.findUsersByPhone(anyString())).thenReturn(users);
		Users userById = userServiceImpl.findUsersByPhone("0383534267");

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_findUsersByUsersName_ReturnsUser() throws Exception {
		when(userDaoImpl.findUsersByUsersName(anyString())).thenReturn(users);
		Users userById = userServiceImpl.findUsersByUsersName("");

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_FindUsersByUsersNameAndEmail_ReturnsUser() throws Exception {
		when(userDaoImpl.findUsersByUsersNameAndEmail(anyString(), anyString())).thenReturn(users);
		Users userById = userServiceImpl.findUsersByUsersNameAndEmail("", "");

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_FindUsersByUsersNameAndPassword_ReturnsUser() throws Exception {
		when(userDaoImpl.findUsersByUsersNameAndPassword(anyString(), anyString())).thenReturn(users);
		Users userById = userServiceImpl.findUsersByUsersNameAndPassword("", "englishcenter");

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_FindUsersByEmail_ReturnsUser() throws Exception {
		when(userDaoImpl.findUsersByEmail(anyString(), anyInt())).thenReturn(users);
		Users userById = userServiceImpl.findUsersByEmail("", 1);

		Assertions.assertThat(userById).isNotNull();
		Assertions.assertThat(userById.getId()).isEqualTo(1);

	}

	@Test
	void UserService_FindAll_ReturnListUser() throws Exception {
		when(userDaoImpl.getAll()).thenReturn(listUser);

		List<Users> userTest = userServiceImpl.getAll();
		Assertions.assertThat(userTest.size()).isGreaterThan(1);

	}

	@Test
	public void UserService_SpUCreateUsers_ReturnUser() throws Exception {
		when(userDaoImpl.spUCreateUsers(anyString(), anyString(), anyString(), anyString(), anyString(), anyInt(),
				anyString(), anyInt(), anyInt(), anyInt(), anyString())).thenReturn(users);

		Users user = userDaoImpl.spUCreateUsers(//data);

		Assertions.assertThat(user).isNotNull();
		Assertions.assertThat(user.getId()).isEqualTo(1);

	}
}
