package Lesson_9;

import java.util.List;

public interface Collection {

    boolean add(String o, List<String> list);
    boolean add(int index, String o);
    boolean delete(String o);
    String get(int index);
    boolean contains(String o);
    boolean equals(Collection str);
    boolean clear();
    int size();
}
