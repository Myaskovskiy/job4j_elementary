package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /*
    //test
     */

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> sorted(List<Profile> profiles) {
        return collect(profiles).stream().
                sorted(((o1, o2) -> o1.getCity().compareTo(o2.getCity())))
                .distinct()
                .collect(Collectors.toList());
    }
}
