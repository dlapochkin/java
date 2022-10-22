import java.util.List;

class PhoneBook {
    private List<Record> records;

    PhoneBook(List<Record> records) {
        this.records = records;
    }

    public List<Record> getAllRecords() {
        return this.records;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        if(this.searchById(record.getId()) == null && this.searchByPhoneNumber(record.getPhoneNumber()) == null) {
            this.records.add(record);
        }
        else {
            throw new PhoneNumberAlreadyExists();
        }
    }

    public void deleteRecord(long id) throws RecordNotFound {
        if(this.searchById(id) != null) {
            this.records.remove(this.searchById(id));
        }
        else {
            throw new RecordNotFound();
        }
    }

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

    public Record searchById(long id) {
            return this.records.stream().filter(rec -> rec.getId() == id).findFirst().orElse(null);
    }

    public Record searchByPhoneNumber(String phoneNumber) {
        return this.records.stream().filter(rec -> rec.getPhoneNumber() == phoneNumber).findFirst().orElse(null);
    } 
}