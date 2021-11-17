package ru.job4j.tdd;

import java.util.Map;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        for (Student st: students.keySet()) {
            if (st.getAccount().equals(account)) {
                return st;
            }
        }
        return null;
    }

    public Student findByAccountStream(String account) {
        return students.keySet()
                .stream()
                .filter(e -> e.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    public Subject findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            Set<Subject> subjects = students.get(a);
            for (Subject s : subjects) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
        }

        return students.get(findByAccountStream(account))
                .stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {

        Student student = new Student("Slava", "001", "1");
        Set<Subject> subjects = Set.of(new Subject("Math", 5),
                                       new Subject("Hist", 4));
        Map<Student, Set<Subject>> studentSetMap = Map.of(student, subjects);
        College college = new College(studentSetMap);
        System.out.println(college.findByAccount("001"));
        System.out.println(college.findByAccountStream("001"));
        System.out.println(college.findBySubjectName("001", "Math"));
    }
}
