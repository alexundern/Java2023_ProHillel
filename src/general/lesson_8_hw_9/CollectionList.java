package general.lesson_8_hw_9;

import java.util.List;
import java.util.ArrayList;

public class CollectionList implements Collection {

    protected final List<String> list;

    public CollectionList() {
        list = new ArrayList<>();
    }

    @Override
    public boolean add(String o, List<String> list) {
        return this.list.add(o);
    }

    @Override
    public boolean add(int index, String o) {
        if (index >= 0 && index <= this.list.size()) {
            this.list.add(index, o);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String o) {
        return list.remove(o);
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(String o) {
        return list.contains(o);
    }

    @Override
    public boolean equals(Collection str) {
        return false;
    }

    @Override
    public boolean clear() {
        list.clear();
        return true;
    }

    @Override
    public int size() {
        return list.size();
    }
}
