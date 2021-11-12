package ru.job4j.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().
                map(profile -> profile.getAddress()).
                collect(Collectors.toList());
    }
}
