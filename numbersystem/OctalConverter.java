package hus.oop.numbersystem;

public class OctalConverter extends AbstractNumberConverter {
    public OctalConverter(MyNumber originalNumber) {
        super(originalNumber);
        decimalTo(originalNumber.getNumber());
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 8.
     */
    @Override
    public void decimalTo(int decimal) {
        while (!convertedNumber.isEmpty()) {
            convertedNumber.pop();
        }

        if (decimal == 0) {
            convertedNumber.push(0);
            return;
        }

        boolean isNegative = decimal < 0;
        if (isNegative) {
            decimal = -decimal;
        }

        while (decimal > 0) {
            int remainder = decimal % 8;
            convertedNumber.push(remainder);
            decimal /= 8;
        }
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi.
     */
    @Override
    public void update() {
        decimalTo(originalNumber.getNumber());
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(8).
     */
    @Override
    public void display() {
        if (convertedNumber.isEmpty()) {
            System.out.println("0(8)");
            return;
        }

        MyStack tempStack = new MyStack();
        MyStack originalStack = new MyStack();

        while (!convertedNumber.isEmpty()) {
            int digit = convertedNumber.pop();
            tempStack.push(digit);
            originalStack.push(digit);
        }

        StringBuilder result = new StringBuilder();
        while (!tempStack.isEmpty()) {
            result.append(tempStack.pop());
        }

        while (!originalStack.isEmpty()) {
            convertedNumber.push(originalStack.pop());
        }

        System.out.println(result.toString() + "(8)");
    }
}