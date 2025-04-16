package utility;

import com.github.javafaker.Faker;

public class userDetails {
    static Faker faker = new Faker();
    private static String firstName = faker.name().firstName();
    private static String lastName = faker.name().lastName();
    private static String gender = faker.options().option("Male", "Female", "Other");
    private static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    private static String email = firstName.toLowerCase() + "@yopmail.com";
    //    private static String role = faker.options().option("Super Admin", "Front Desk");
    private static String role = "Super Admin";


    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getGender() {
        return gender;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getEmail() {
        return email;
    }

    public static String getRole() {
        return role;
    }
}
