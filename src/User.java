import java.util.Objects;

public class User {
    private String email;
    private String login;

    public User(String email, String login) {
        if (validationUserOfTwoParametersEmail(email)) {
            this.email = email;
        } else throw new IllegalArgumentException();

        if (validationUserOfTwoParametersLogin(login)) {
            this.login = login;
        } else throw new IllegalArgumentException();

        if (equalsLoginAndEmail(email, login)) {
            throw new IllegalArgumentException();
        }
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public static boolean validationUserOfTwoParametersEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean validationUserOfTwoParametersLogin(String login) {
        return !login.isBlank();
    }

    public static boolean equalsLoginAndEmail(String email, String login)  {
        return email.equals(login);
    }

    public static boolean validationUserWithoutParameters(User user) throws IllegalAccessException {
        EmptyObjectCheck<User> emptyObjectCheck = new EmptyObjectCheck<>();
        emptyObjectCheck.setEntity(user);
        return emptyObjectCheck.isEmpty();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(email, user.email) && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, login);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
