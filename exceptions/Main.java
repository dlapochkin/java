import java.util.ArrayList;
import java.util.stream.Collectors;


/*
 * Класс Main, тело работы программы.
 */
public class Main {

    /*
     * Функция демонстрирует пример работы с исключениями.
     */
    public static void main(String[] args) throws PhoneNumberAlreadyExists, RecordNotValid {

        /*
         * Для демонстрации работы программы были использованы пустые catch(...) {} (демонстрация исключений).
         */

        // (1)
        System.out.println("(1)");
        PhoneBook book = new PhoneBook(new ArrayList<Record>());
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(2)
        System.out.println("(2)");
        book.createRecord(new Record(1, "+7(996)231-34-05", "Лапочкин Дмитрий"));
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(3)
        System.out.println("(3)");
        try {
            book.createRecord(new Record(1, "+7(921)674-32-09", "Лапочкин Дмитрий"));
        }
        catch(PhoneNumberAlreadyExists exception) {
            book.createRecord(new Record(2, "+7(921)674-32-09", "Лапочкин Дмитрий"));
        }
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(4)
        System.out.println("(4)");
        try {
            book.createRecord(new Record(3, "+7(996)231-34-05", "Лапочкин Дмитрий"));
        }
        catch(PhoneNumberAlreadyExists exception) {
        }
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(5)
        System.out.println("(5)");
        try {
            book.updateRecord(new Record(4, "+7(921)674-32-09", "Петров Петр"));
        }
        catch(RecordNotFound exception) {
            book.updateRecord(new Record(2, "+7(921)674-32-09", "Петров Петр"));
        }
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));
        
        //(6)
        System.out.println("(6)");
        try {
            book.updateRecord(new Record(2, "+7(921)674-32-09",null));
        }
        catch(RecordNotValid exception) {
            book.updateRecord(new Record(2, "+7(921)674-32-09", "Иванов Иван"));
        }
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(7)
        System.out.println("(7)");
        book.deleteRecord(2);
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));

        //(8)
        System.out.println("(8)");
        try {
            book.deleteRecord(2);;
        }
        catch(RecordNotFound exception) {
        }
        System.out.println(book.getAllRecords().stream().map(Object::toString).collect(Collectors.joining("\n")));
    }
}