package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<String> combineName = x -> x.equals(key);
        Predicate<String> combineSurname = x -> x.equals(key);
        Predicate<String> combinePhone = x -> x.equals(key);
        Predicate<String> combineAddress = x -> x.equals(key);
        Predicate<Person> combine = x -> combineName.test(x.getName())
                                      || combineSurname.test(x.getSurname())
                                      || combinePhone.test(x.getPhone())
                                      || combineAddress.test(x.getAddress());
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
