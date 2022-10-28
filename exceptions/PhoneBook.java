import java.util.List;

/*
 * Класс, реализующий телефонный справочник для записи номеров телефонов.
 * List<Record> records - список с номерами телефонов.
 */
class PhoneBook {
    private List<Record> records;

    PhoneBook(List<Record> records) {
        this.records = records;
    }

    /*
     * Метод возвращает список из всех записей справочника.
     */
    public List<Record> getAllRecords() {
        return this.records;
    }

    /*
     * Метод сохраняет в справочнике новую запись.
     */
    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        if(this.searchById(record.getId()) == null && this.searchByPhoneNumber(record.getPhoneNumber()) == null) {
            this.records.add(record);
        }
        else {
            throw new PhoneNumberAlreadyExists();
        }
    }

    /*
     * Метод удаляет запись из справочника по идентификатору.
     */
    public void deleteRecord(long id) throws RecordNotFound {
        if(this.searchById(id) != null) {
            this.records.remove(this.searchById(id));
        }
        else {
            throw new RecordNotFound();
        }
    }

    /*
     * Метод обновляет запись в справочнике.
     */
    public void updateRecord(Record record) throws RecordNotFound, RecordNotValid {
        Record search = this.searchById(record.getId());
        if(search != null) {
            if(record.getPhoneNumber() == null || record.getName() == null) {
                throw new RecordNotValid();
            }
            else {
                this.records.remove(search);
                this.records.add(record);
            }
        }
        else {
            throw new RecordNotFound();
        }
    }

    /*
     * Метод осуществляет поиск нужной записи по id.
     */
    public Record searchById(long id) {
            return this.records.stream().filter(rec -> rec.getId() == id).findFirst().orElse(null);
    }

    /*
     * Метод осуществляет поиск нужной записи по номеру телефона.
     */
    public Record searchByPhoneNumber(String phoneNumber) {
        return this.records.stream().filter(rec -> rec.getPhoneNumber() == phoneNumber).findFirst().orElse(null);
    } 
}