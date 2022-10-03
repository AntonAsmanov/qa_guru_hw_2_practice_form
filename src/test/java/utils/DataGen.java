package utils;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Random;

public class DataGen {
    static Faker faker = new Faker();

    public static String firstName(){
        return faker.name().firstName();
    }

    public static String lastName(){
        return faker.name().lastName();
    }

    public static String email(){
        return faker.internet().emailAddress();
    }

    public static String gender(){
        return faker.demographic().sex();
    }

    public static String phone(){
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String birthdateYear(){
        return String.valueOf(faker.date().birthday().getYear()+1900);
    }

    public static String birthdateMonth(){
        return Month.getTextMonth(faker.date().birthday().getMonth());
    }

    public static String birthdateDay(){
        return String.valueOf(faker.date().birthday().getDate());
    }

    public static String subject(){
        String[] subjects = {"English", "Maths", "Physics", "Chemistry", "Computer Science", "Economics", "History", "Commerce", "Accounting"};
        return subjects[new Random().nextInt(subjects.length)];
    }

    public static String hobby(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[new Random().nextInt(hobbies.length)];
    }

    public static String pictureName(){
        return ("selenide-logo-big.png");
    }

    public static String address(){
        return faker.address().fullAddress();
    }

    public static String state(){
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return states[new Random().nextInt(states.length)];
    }

    public static String city(String state){
        String city;
        String[] cities;
        switch (state){
            case ("NCR"):
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                city = cities[new Random().nextInt(cities.length)];
                break;
            case ("Uttar Pradesh"):
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                city = cities[new Random().nextInt(cities.length)];
                break;
            case ("Haryana"):
                cities = new String[]{"Karnal", "Paipat"};
                city = cities[new Random().nextInt(cities.length)];
                break;
            case ("Rajasthan"):
                cities = new String[]{"Jaipur", "Jaiselmer"};
                city = cities[new Random().nextInt(cities.length)];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
        return city;
    }

}
