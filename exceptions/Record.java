class Record {
    private long id;
    private String phoneNumber;
    private String name;
    public Object toString;

    Record (long id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.id + ", " + this.name + ", " + this.phoneNumber;
    }
}