public class MyList {
    private int[] arr;
    private int sz;

    public MyList() {
        arr = new int[100];
        sz = 0;
    }

    public void add(int val) {
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

    public void deleteByValue(int val) {
        for (int i = 0; i < sz; i++) {
            if (arr[i] == val) {
                deleteByIndex(i);
                return;
            }
        }
        System.out.println("Value not found");
    }

    public int get(int idx) {
        if (idx < 0 || idx >= sz) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return arr[idx];
    }

    private void expand() {
        int newSize = arr.length * 2;
        int[] newArr = new int[newSize];
        System.arraycopy(arr, 0, newArr, 0, sz);
        arr = newArr;
    }

    private void shrink() {
        if (sz < arr.length / 4 && arr.length > 100) {
            int newSize = arr.length / 2;
            int[] newArr = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, sz);
            arr = newArr;
        }
    }

    public int size() {
        return sz;
    }

    public void printArray() {
        System.out.print("Current array: ");
        for (int i = 0; i < sz; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList list = new MyList();

        list.add(18);
        list.add(22);
        list.add(31);
        list.add(4);
        list.add(11);

        System.out.println("Initial array:");
        list.printArray();

        list.deleteByIndex(2);
        System.out.println("After deletion by index (2):");
        list.printArray();

        list.deleteByValue(4);
        System.out.println("After deletion by value (40):");
        list.printArray();
    }
}

