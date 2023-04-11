import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final String email = "ura22051995@gmail.com";
    private final String login = "Caveri123";

    private final User userWithoutParameters = new User();
    private final User userWithTwoParameters = new User(email, login);




    @Test
    public void shouldValidationUserOfTwoParameters() {
        Assertions.assertTrue(User.validationUserOfTwoParameters(userWithTwoParameters));

    }

    @Test
    void shouldValidationUserWithoutParameters() {
        Assertions.assertTrue(User.validationUserWithoutParameters(userWithoutParameters));
    }

    @Test
    void shouldValidationEmail() {
        Assertions.assertTrue(User.validationEmail(userWithTwoParameters));
    }

    @Test
    void shouldEqualsLoginAndEmail() {
        Assertions.assertFalse(User.equalsLoginAndEmail(userWithTwoParameters));
    }

}