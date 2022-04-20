package com.example.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
@Autowired
private UserRepository repo;
@Autowired
private TestEntityManager entityManager;
@Test
public void testCreateUser() {
	User user = new User();
	user.setEmail("mesratimedali@gmail.com");
	user.setPassword("dali1920");
	user.setFirstName("Mohamed Ali");
	user.setLastName("Mesrati");
	
	User savedUser = repo.save(user);
	
	User existUser = entityManager.find(User.class, savedUser.getId());
assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
}

@Test
	public void testFindUserByEmail(){
	String email = "mesratimedali@gmail.com";
	User user = repo.findbyEmail(email);
	assertThat(user).isNotNull();
}

@Test
	public void testAddNew(){
	User user = new User();
	user.setEmail("mesratimedali@gmail.com");
	user.setPassword("dali1920");
	user.setFirstName("Mohamed Ali");
	user.setLastName("Mesrati");
	User savedUser = repo.save(user);
	assertThat(savedUser).isNotNull();
	assertThat(savedUser.getId()).isGreaterThan(0);

}

@Test
	public void testListAll(){
	Iterable<User> users = repo.findAll();
	assertThat(users).hasSizeGreaterThan(0);

	for (User user : users){
		System.out.println(user);
	}
}

@Test
	public void testUpdate() {
	Integer userId = 1;
	Optional<User> optionalUser = repo.findById(Long.valueOf(userId));
	User user = optionalUser.get();
	user.setPassword("dalica");
	repo.save(user);

	User updatedUser = repo.findById(Long.valueOf(userId)).get();
	assertThat(updatedUser.getPassword()).isEqualTo("dalica");
}

@Test
	public void testGet() {
	Integer userId = 2;
	Optional<User> optionalUser = repo.findById(Long.valueOf(userId));
	assertThat(optionalUser).isPresent();
	System.out.println(optionalUser.get());
}

@Test
	public void testDelete() {
	Integer userId = 2 ;
	repo.deleteById(Long.valueOf(userId));
	Optional<User> optionalUser = repo.findById(Long.valueOf(userId));
	assertThat(optionalUser).isNotPresent();
}
}
