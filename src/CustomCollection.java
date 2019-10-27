import java.util.Collection;
public interface CustomCollection {
    boolean add(String str);
    boolean addAll(String[] strArr);
    boolean addAll(Collection strColl);
    boolean delete (int index);
    boolean delete (String str);
    String get(int index);
    boolean contains(String str);
    boolean equals(String[] strArr);
    boolean clear();
    int indexOf(String str);
    int size();
    boolean trim();
    int length();
}
