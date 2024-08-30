package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = new UserList();
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        User user = userList.findUserByUsername("user2");

        assertNotNull(user);
        assertEquals("user2", user.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");


        // TODO: change password of one user
        boolean passwordChanged = userList.changePassword("user2", "password2", "newpassword2");
        assertTrue(passwordChanged);

        // TODO: assert that user can change password
        //assertTrue(actual);
        User user = userList.login("user2", "newpassword2");
        assertNotNull(user);
        assertEquals("user2", user.getUsername());
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // TODO: call login() with correct username and password
        User user = userList.login("user2", "password2");

        // TODO: assert that User object is found
        // assertEquals(expected, actual);
        assertNotNull(user);
        assertEquals("user2", user.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");

        // TODO: call login() with incorrect username or incorrect password
        User user = userList.login("user2", "wrongpassword");

        // TODO: assert that the method return null
        // assertNull(actual);
        assertNull(user);
    }

}