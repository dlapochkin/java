/*
 * Исключение, возникающее в случае, если найти нужную запись не удается.
 */
class RecordNotFound extends RuntimeException {
    RecordNotFound() {
        System.out.println("Справочник не содержит искомой записи.");
    }
}
