import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void shouldValidationUserOfTwoParametersEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("ura2205.ru", "qwerty"));
    }

    @Test
    public void shouldValidationUserOfTwoParametersLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("ura@2205.ru", "       "));
    }

    @Test
    void shouldValidationUserWithoutParameters() throws IllegalAccessException {
        Assertions.assertTrue(User.validationUserWithoutParameters(new User()));
    }

    @Test
    void shouldEqualsLoginAndEmail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("ura@2205.ru", "ura@2205.ru"));
    }
}