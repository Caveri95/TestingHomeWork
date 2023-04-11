import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    User userWithTwoParameters = new User("uragmailcom", "");
    User userWithoutParameters = new User();



    @Test
    public void shouldValidationUserOfTwoParametersEmail() {
        Assertions.assertThrows(Exception.class, () -> User.validationUserOfTwoParametersEmail(userWithTwoParameters.getEmail()));
    }

    @Test
    public void shouldValidationUserOfTwoParametersLogin() {
        Assertions.assertThrows(Exception.class, () -> User.validationUserOfTwoParametersLogin(userWithTwoParameters.getLogin()));
    }

    @Test
    void shouldValidationUserWithoutParameters() throws IllegalAccessException {
        Assertions.assertTrue(User.validationUserWithoutParameters(userWithoutParameters));
    }

    @Test
    void shouldEqualsLoginAndEmail() {
        User user = new User("ura22@gmail.com", "ura22@gmail.com");
        Assertions.assertThrows(Exception.class, () -> User.equalsLoginAndEmail(user.getEmail(), user.getLogin()));
    }

}