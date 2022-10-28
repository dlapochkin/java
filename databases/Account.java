package databases;

/*
 * Класс Account.
 * String name - ФИО пользователя.
 * String birthDate - дата рождения пользователя.
 * String email - электронная почта пользователя.
 * String password - пароль аккаунта пользователя.
 * boolean blocked указывает, заблокирован ли пользователь.
 */
public class Account {
    private String name;
    private String birthDate;
    private String email;
    private String password;
    private boolean blocked;

    Account (String name, String birthDate, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean getBlocked() {
        return this.blocked;
    }

    public void setBlocked() {
        this.blocked = true;
    }
}