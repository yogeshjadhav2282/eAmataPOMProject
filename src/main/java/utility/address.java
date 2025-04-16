package utility;

import com.github.javafaker.Faker;

public class address {
    static Faker faker = new Faker();
    private static String addressLine1 = faker.address().streetAddress();
    private static String addressLine2 = faker.address().secondaryAddress();
    private static String state = "Arizona";
    private static String city = faker.address().city();
    private static String country = faker.address().country();
    private static String zipCode = faker.address().zipCode();


    public static String getAddressLine1() {
        return addressLine1;
    }

    public static String getAddressLine2() {
        return addressLine2;
    }

    public static String getState() {
        return state;
    }

    public static String getCity() {
        return city;
    }

    public static String getCountry() {
        return country;
    }

    public static String getZipCode() {
        return zipCode;
    }
}
