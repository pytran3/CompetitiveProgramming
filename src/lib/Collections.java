package lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Collections {

    public static void main(String[] args) {
        // to test
        IntList a = new IntList(16);
        for (int i = 0; i < 100; i++) {
            a.add(i);
        }
        for (int i = 0; i < a.size()+1; i++) {
            System.out.println(a.get(i));
        }
    }
}

class IntList{
    private int[] array;
    private int size = 0;
    public IntList() {
        array = new int[256];
    }

    public IntList(int size) {
        array = new int[size];
    }

    public void add(int a) {
        if(size == array.length) {
            int newSize = Math.min(Integer.MAX_VALUE, size*2);
            array = Arrays.copyOf(array, newSize);
        }
        array[size++] = a;
    }

    public void addAll(IntList list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
        // TODO convert to copyOf
//        int[] a = list.getArray();
//        int numNew = a.length;
//        if(size + numNew > array.length) {
//            int length = array.length;
//            while (size + numNew < length) {
//                length *= 2;
//            }
//            array = Arrays.copyOf(array, length);
//        }
//        System.arraycopy(a, 0, array, size, numNew);
//        size += numNew;
    }

    public int get(int i) {
        if(i >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%d, i=%d", i, size));
        }
        return array[i];
    }

    public int size(){
        return size;
    }

    public int[] getArray() {
        return array;
    }
}