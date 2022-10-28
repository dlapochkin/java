package databases;

/*
 * Исключение, возникающее при попытке входа на заблокированный аккаунт.
 */
public class AccountBlockedException extends Exception {
    AccountBlockedException() {
        System.out.println("Данный аккаунт заблокирован после пяти неудачных попыток входа.");
    }
}
