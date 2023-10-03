package com.example.testeusuario.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import com.example.testeusuario.model.entity.User;
import com.example.testeusuario.model.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService;
    private UserRepository mockRepository;

    @Before
    public void setUp() {
        mockRepository = createMock(UserRepository.class);
        userService = new UserService(mockRepository);
    }

    @After
    public void tearDown() {
        verify(mockRepository);
    }

    @Test
    public void testGetUserById() {
        int userId = 1;
        User expectedUser = new User("john", "john@example.com");

        // Configurando o mock
        expect(mockRepository.findById(userId)).andReturn(expectedUser);

        // Ativando o mock
        replay(mockRepository);

        // Executando o teste
        User result = userService.getUserById(userId);

        // Verificando o resultado
        assertEquals(expectedUser, result);
    }

    @Test
    public void testCreateUser() {
        User newUser = new User("alice", "alice@example.com");

        // Configurando o mock
        mockRepository.save(newUser);
        expectLastCall();

        // Ativando o mock
        replay(mockRepository);

        // Executando o teste
        userService.createUser(newUser);
    }

    @Test
    public void testGetUserByUsername() {
        String username = "alice";
        User expectedUser = new User(username, "alice@example.com");

        // Configurando o mock
        expect(mockRepository.findByUsername(username)).andReturn(expectedUser);

        // Ativando o mock
        replay(mockRepository);

        // Executando o teste
        User result = userService.getUserByUsername(username);

        // Verificando o resultado
        assertEquals(expectedUser, result);
    }
}
