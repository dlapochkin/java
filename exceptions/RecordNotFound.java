class RecordNotFound extends RuntimeException {
    RecordNotFound() {
        System.out.println("Справочник не содержит искомой записи.");
    }
}
