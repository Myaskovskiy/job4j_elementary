package ru.job4j.lambda;

public class Attachment {
    private String name;
    private int size;

    Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    String getName() {
        return this.name;
    }

    int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{"
                + "name='"
                + name
                + '\''
                + ", size="
                + size + '}';
    }
}
