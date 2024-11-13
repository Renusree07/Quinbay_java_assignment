public class GenericMyList<T> {
    private Object[] arr;
    private int sz;

    public GenericMyList() {
        arr = new Object[100];
        sz = 0;
    }

    public void add(T val) {
        if (sz == arr.length) {
            expand();
        }
        arr[sz] = val;
        sz++;
    }

    public void deleteByIndex(int idx) {
        if (idx < 0 || idx >= sz) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = idx; i < sz - 1; i++) {
            arr[i] = arr[i + 1];
        }
        sz--;
        shrink();
    }

    public void deleteByValue(T val) {
        for (int i = 0; i < sz; i++) {
            if (arr[i].equals(val)) {
                deleteByIndex(i);
                return;
            }
        }
        System.out.println("Value not found");
    }

    @SuppressWarnings("unchecked")
    public T get(int idx) {
        if (idx < 0 || idx >= sz) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return (T) arr[idx];
    }

    private void expand() {
        int newSize = arr.length * 2;
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, sz);
        arr = newArr;
    }

    private void shrink() {
        if (sz < arr.length / 4 && arr.length > 100) {
            int newSize = arr.length / 2;
            Object[] newArr = new Object[newSize];
            System.arraycopy(arr, 0, newArr, 0, sz);
            arr = newArr;
        }
    }

    public int size() {
        return sz;
    }

    public void printList() {
        System.out.print("Current list: ");
        for (int i = 0; i < sz; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GenericMyList<Integer> intList = new GenericMyList<>();
        intList.add(11);
        intList.add(12);
        intList.add(32);
        System.out.println("After adding elements:");
        intList.printList();

        intList.deleteByIndex(1);
        System.out.println("After deletion by index (1):");
        intList.printList();

        intList.deleteByValue(32);
        System.out.println("After deletion by value (30):");
        intList.printList();

        GenericMyList<String> strList = new GenericMyList<>();
        strList.add("Hello");
        strList.add("World");
        System.out.println("String list");
        strList.printList();

        strList.deleteByValue("Hello");
        System.out.println("After deletion by value (\"Hello\"):");
        strList.printList();
    }
}
