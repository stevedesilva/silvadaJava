package builder.usinginterface;

class DefaultPerson implements Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String phoneNumber;
    protected String address;

    public DefaultPerson() { }
    public DefaultPerson(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        address = builder.address;
        phoneNumber = builder.phoneNumber;
        age = builder.age;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    static class Builder extends DefaultPerson {

        public Builder() {}

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder firstName(String firstName) {
            this.firstName=firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName=lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber=phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address=address;
            return this;
        }

        public Person build(){
            return new DefaultPerson(this);
        }
    }
}



