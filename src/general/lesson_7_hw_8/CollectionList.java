package general.lesson_7_hw_8;
import java.util.ArrayList;
import java.util.List;

public class CollectionList {

    protected final List<String> list;

    public CollectionList() {
        list = new ArrayList<>();
    }

    public boolean add(int index, String value, List<String> list) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, value);
            return true;
        } else {
            return false;
        }
    }

    public boolean add(String value, List<String> list) {
        return list.add(value);
    }

    public boolean delete(int index, List<String> list) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String value, List<String> list) {
        return list.remove(value);
    }

    public String get(int index, List<String> list) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }
    }
}


