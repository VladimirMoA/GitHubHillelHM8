import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class demoCollection implements CustomCollection {

    public String[] array;
    int initialCapacity;


    public boolean add(String str) {
        if (array[array.length-1] == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = str;
                    return true;
                }
            }
        }
        else  {
            String[] newArray = new String[(int) (array.length*1.6)];
            System.arraycopy(array,0,newArray,0,array.length);
            newArray[array.length] = str;
            array = new String[(int)(array.length*1.6)];
            initialCapacity = array.length;
            System.arraycopy(newArray,0,array,0,newArray.length);
            return true;
            }
        return false;
    }

    public boolean addExp(String str) {
        if (array[array.length-1] == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = str;
                    return true;
                }
            }
        }
        else  {
            String[] newArray = new String[array.length+1];
            System.arraycopy(array,0,newArray,0,array.length);
            newArray[array.length] = str;
            array = new String[array.length+1];
            initialCapacity = array.length;
            System.arraycopy(newArray,0,array,0,newArray.length);
            return true;
        }
        return false;
    }

    public boolean addAll(String[] strArr) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) count++;
        }
        if (count >= strArr.length) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    if (i - (array.length - count) >= strArr.length) break;
                    array[i] = strArr[i - (array.length - count)];
                    return true;
                }
            }
        } else {
            String[] newArray = new String[array.length+strArr.length];
            System.arraycopy(array,0,newArray,0,array.length);
            array = new String[array.length+strArr.length];
            initialCapacity = array.length;
            System.arraycopy(newArray,0,array,0,newArray.length);
            count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) count++;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    if (i - (array.length - count) >= strArr.length) break;
                    array[i] = strArr[i - (array.length - count)];
                    return true;
                }
            }
        } return false;
    }

    public boolean addAll(Collection strColl) {
        String[] strArr = (String[]) strColl.toArray(new String[strColl.size()]);
        return addAll(strArr);
    }

    public boolean delete(int index) {
        String str = get(index);
        return delete(str);
    }

    public boolean delete(String str) {
        if (contains(str) == false) {
            System.out.println("В данной коллекции нет такой строки");
        } else {
            int pos = indexOf(str);
            if (pos == array.length) {
                String[] newArray = new String[array.length-1];
                System.arraycopy(array,0,newArray,0,array.length-1);
                array = new String[array.length-1];
                initialCapacity = array.length;
                System.arraycopy(newArray,0,array,0,array.length);
                return true;
            } else {
                String[] newArray1 = new String[pos];
                System.arraycopy(array,0,newArray1,0,pos);
                String[] newArray2 = new String[array.length-1];
                System.arraycopy(array,pos+1,newArray2,pos,array.length - pos-1);
                array = new String[array.length-1];
                initialCapacity = array.length;
                System.arraycopy(newArray1,0,array,0,pos);
                System.arraycopy(newArray2,pos,array,pos,(array.length - (pos)));
                return true;
            }
        }
        return false;
    }

    public String get(int index) {
        if (index >= array.length || index < 0) {
            return null;
        }
        return array[index];
    }

    public boolean contains(String str) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != str) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean equals(String[] strArr) {
        if (strArr.length > array.length) {
            for (int i = 0; i < array.length; i++) {
                if (strArr[i] == array[i]) {
                    return true;
                } else return false;
            }
        } else if (strArr.length < array.length) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] == array[i]) {
                    return true;
                } else return false;
            }
        } else if (strArr.length == array.length) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] == array[i]) {
                    return true;
                } else return false;
            }
        } return false;
    }

    public boolean clear() {
        array = new String[array.length];
        return true;
    }

    public int indexOf(String str) {
        int pos = -1;
        if (contains(str) == true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == str) {
                    pos = i;
                    break;
                }
            }
        } else {
            System.out.println("Данного элемента в массиве нет");
        } return pos;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=null) {
                count++;
            } else break;
        }
        return count;
    }

    public boolean trim() {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == null) {
                delete(i);
            }
        }
        return true;
    }

    public int length() {
        return initialCapacity;
    }

    public demoCollection(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new String[initialCapacity];
            this.initialCapacity = initialCapacity;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");


        String[] strings = new String[] {"Vova","Vija","3","4","5","V","Dante"};
        demoCollection array = new demoCollection(5);
        String[] arrays = new String[] {"2","1","1","1","1","Vova","Vija","3","4","5","V","Dante",null,null,null};
        array.add("2");
        array.add("2");
        array.addAll(arrayList);
        array.addAll(strings);
        array.delete(0);
        array.indexOf("2");
        if (array.contains("2")) {
            System.out.println("Содержит 2");
        }
        System.out.println(array.length());
        System.out.println(array.equals(arrays));
        array.trim();
        System.out.println();
        for (int i = 0; i < array.length() ;i++) {
            System.out.println(array.get(i));
        }
        System.out.println();
    }
}
