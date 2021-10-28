package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> list = Arrays.asList(
                new Attachment("name 4", 300),
                new Attachment("name 2222", 200),
                new Attachment("name 33", 400)
        );
        Comparator<Attachment> comparator = (o1, o2) -> Integer.compare(o1.getSize(), o2.getSize());
        list.sort(comparator);
        System.out.println(list);
        Comparator<Attachment> comparatorName = (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        };
        list.sort(comparatorName);
        System.out.println(list);
        Comparator<Attachment> comparator2 = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Attachment> cmpDescSize = (o1, o2) -> (o2.getName().length() - o1.getName().length());
        list.sort(cmpDescSize);
        System.out.println(list);

    }
}
