/*
 * Исключение, возникающее в случае, если запись некорректна.
 */
class RecordNotValid extends Exception {
    RecordNotValid() {
        System.out.println("Новая запись не содержит поля name и/или поля phoneNumber.");
    }
}
