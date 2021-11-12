package ru.job4j.streamapi;

import java.util.Objects;

public class Profile {
    private Address address;
    private String name;

    public Profile(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address)
                && Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address='" + address + '\''
                + ", name=" + name
                + '}';
    }
}
