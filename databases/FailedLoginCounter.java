package databases;

import java.util.*;

/*
 * Класс Singletone, отвечающий за подсчет неудачных попыток входа в конкретный аккаунт.
 * FailedLoginCounter instance - instance.
 * Map<Account, Integer> counter - HashMap, хранит количество неудачных входов для Account.
 */
public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private static Map<Account, Integer> counter = new HashMap<>();

    public static synchronized FailedLoginCounter getInstance() {
        if(instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    /*
     * Функция увеличивает счетчик неудачных входов на единицу. В случае, если было совершено 5 неудачных
     * попыток входа, происходит блокировка Account account.
     */
    public static void count(Account account) {
        counter.putIfAbsent(account, 0);
        counter.put(account, counter.get(account) + 1);
        if (counter.get(account).equals(5)) {
            //Сообщение для демонстрации работы программы.
            System.out.print(account.getEmail() + " был заблокирован после пяти неудачных попыток входа.\n");
            account.setBlocked();
        } 
    }
}

