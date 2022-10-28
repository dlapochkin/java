package databases;

/*
 * Исключение, возникающее при попытке создания записи с уже использвованной почтой.
 */
public class AccountAlreadyExistsException extends Exception {
    AccountAlreadyExistsException() {
        System.out.println("Данная электронная почта уже используется.");
    }
}
