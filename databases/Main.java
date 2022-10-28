package databases;

import java.io.*;
import java.util.*;

/*
 * Класс Main, тело работы программы.
 */
public class Main {
    /*
     * Функция демонстрирует пример работы с базой данных.
     */
    public static void main(String[] args) throws AccountAlreadyExistsException, WrongCredentialsException, AccountBlockedException, IOException {
        Scanner input = new Scanner(System.in);

        /*
         * Для демонстрации работы программы были использованы
         *  пустой input.nextInt() (ожидание отклика клавиатуры на каждом шаге)
         *  пустые catch(...) {} (демонстрация исключений)
         */

        /*
         * Описание пути к базе данных.
         * String path - путь к папке проекта.
         * String database - название файла базы данных (с расширением).
         */
        String path = new File(".").getCanonicalPath() + "/databases/";
        System.out.println("Введите название базы данных. \"data\", к примеру.");
        String database = input.nextLine() + ".csv";

        /*
         * Удаляем файл с базой данных (если существует) с целью демонстрации процесса с момента создания базы данных. 
         */
        File file = new File(path + database);
        if (file.exists()) {
            file.delete();
            
            System.out.println("Удален файл " + path + database);
            input.nextLine();
        }
            
        /*
         * Создание экземпляра manager класса FileAccountManager.
         */
        FileAccountManager manager = new FileAccountManager(path + database);
        
        System.out.println("Создан экземпляр manager класса FileAccountManager.");
        input.nextLine();

        /*
         * Создание аккаунтов A и B.
         * A: Иванов Иван Иванович, 13.05.1997, i.ivanov@gmail.com, ivanov
         * B: Петров Петр Петрович, 10.10.2000, p.petrov@gmail.com, petrov
         */
        manager.register(new Account("Иванов Иван Иванович", "13.05.1997", "i.ivanov@gmail.com", "ivanov"));
        manager.register(new Account("Петров Петр Петрович", "10.10.2000", "p.petrov@gmail.com", "petrov"));
        
        System.out.println("Созданы аккаунты A и B.");
        input.nextLine();

        /*
         * Повторное создание аккаунта A.
         * Пустой блок catch(AccountAlreadyExistsException exception) используется для демонстрации работы программы.
         */
        try {
        manager.register(new Account("Иванов Иван Иванович", "13.05.1997", "i.ivanov@gmail.com", "ivanov"));
        } catch(AccountAlreadyExistsException exception) {}
        
        input.nextLine();

        /*
         * Цепочка вызовов логина
         * А(н) -> B(н) -> A(н) -> A(н) -> A(н) -> A(н) blocked -> A(у) ex -> B(н) -> B(у) -> B(н) -> B(н) -> B(н) -> B(н) -> B(у)
         * Пустые блоки catch используются для демонстрации работы программы.
         */
        try {
            manager.login("i.ivanov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}
        
        input.nextLine();

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        input.nextLine();

        try {
            manager.login("i.ivanov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("i.ivanov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("i.ivanov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("i.ivanov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        input.nextLine();

        try {
            manager.login("i.ivanov@gmail.com", "ivanov");
        } catch(AccountBlockedException exception) {}

        input.nextLine();

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        input.nextLine();

        Account petrov = manager.login("p.petrov@gmail.com", "petrov");
        System.out.println("Успешный вход с " + petrov.getEmail() + ".");

        input.nextLine();

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            manager.login("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}

        try {
            Account anotherPetrov = manager.login("p.petrov@gmail.com", "petrov");
        } catch(AccountBlockedException exception) {}

        input.nextLine();

        /*
         * Удаление аккаунтов A и B.
         */
        manager.removeAccount("i.ivanov@gmail.com", "ivanov");
        
        input.nextLine();

        try {
            manager.removeAccount("p.petrov@gmail.com", "wrong_password");
        } catch(WrongCredentialsException exception) {}
        
        input.nextLine();
        
        manager.removeAccount("p.petrov@gmail.com", "petrov");
    }
}
