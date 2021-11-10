package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<String> combineName = x -> x.contains(key);
        Predicate<String> combineSurname = x -> x.contains(key);
        Predicate<String> combinePhone = x -> x.contains(key);
        Predicate<String> combineAddress = x -> x.contains(key);
        combineName = combineName.or(combineSurname.or(combinePhone.or(combineAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combineName.test(person.getAddress())
                    || combineName.test(person.getPhone())
                    || combineName.test(person.getName())
                    || combineName.test(person.getSurname())) {
                result.add(person);
            }
        }
        return result;
    }
}
