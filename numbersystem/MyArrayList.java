package hus.oop.numbersystem;

import java.util.Arrays;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private int[] data;
    private int size;

    public MyArrayList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data[index];
    }

    @Override
    public void set(int value, int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        data[index] = value;
    }

    @Override
    public void insertAtStart(int value) {
        insertAtPos(value, 0);
    }

    @Override
    public void insertAtEnd(int value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    @Override
    public void insertAtPos(int value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (size == data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    private void allocateMore() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }
}
