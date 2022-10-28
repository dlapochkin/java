package databases;

/*
 * Исключение, возникающее при вводе неверных данных во время входа.
 */
public class WrongCredentialsException extends Exception {
    WrongCredentialsException () {
        System.out.println("Неверно введены данные.");
    }
}
