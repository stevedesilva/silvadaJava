package builder.usingstatic;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

    public User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName= builder.lastName;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
        this.address= builder.address;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder() {}

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

        public User build() {
            return new User(this);
        }
    }
}
