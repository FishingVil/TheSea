package hus.oop.numbersystem;

public abstract class MyAbstractList implements MyList {
    /**
     * Phương thức kiểm tra xem index có nằm trong đoạn [0 - limit] không.
     * @param index
     * @param limit
     * @return
     */
    public boolean checkBoundaries(int index, int limit) {
        return (index >= 0 && index <= limit);

    }

    /**
     * Mô tả tập dữ liệu.
     * @return mô tả tập dữ liệu theo định dạng [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            result.append(get(i));
            if (i < size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }
}
