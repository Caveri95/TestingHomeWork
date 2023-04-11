import java.util.Objects;

public class User {
    private String email;
    private String login;

    public User(String email, String login) {
        try {
            validationUserOfTwoParametersEmail(email);
            this.email = email;
        } catch (UnknownParametersException e) {
            System.out.println(e.getMessage());
        }

        try {
            validationUserOfTwoParametersLogin(login);
            this.login = login;
        } catch (UnknownParametersException e) {
            System.out.println(e.getMessage());
        }

        try {
            equalsLoginAndEmail(email, login);
        } catch (UsernameAndEmailEqualsException e) {
            System.out.println(e.getMessage());
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

    public static void validationUserOfTwoParametersEmail(String email) throws UnknownParametersException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new UnknownParametersException("Неверный емейл!");
        }
    }

    public static void validationUserOfTwoParametersLogin(String login) throws UnknownParametersException {
        if (login.isBlank()) {
            throw new UnknownParametersException("Введите логин!");
        }
    }

    public static boolean validationUserWithoutParameters(User user) throws IllegalAccessException {
        EmptyObjectCheck<User> emptyObjectCheck = new EmptyObjectCheck<>();
        emptyObjectCheck.setEntity(user);
        return emptyObjectCheck.isEmpty();
    }


    public static void equalsLoginAndEmail(String email, String login) throws UsernameAndEmailEqualsException {
        if (email.equals(login)) {
            throw new UsernameAndEmailEqualsException("Логин и Email не должны быть равны!");
        }
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
