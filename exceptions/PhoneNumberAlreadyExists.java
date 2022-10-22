class PhoneNumberAlreadyExists extends Exception {
    PhoneNumberAlreadyExists() {
        System.out.println("Справочник уже содержит запись с подобным идентификатором или номером телефона.");
    }
}