package hus.oop.numbersystem;

import java.util.Random;

public class TestNumberSystem {
    public static void main(String[] args) {
        /* Yêu cầu:

        - Sinh ngẫu nhiên 3 số tự nhiện n1, n2, n3:

        - Thực hiện chạy chương trình bằng cách set các số vừa sinh ra vào MyNumber.
          Chương trình sẽ in ra terminal thông tin về các số ban đầu và các số chuyển đổi, ví dụ:

          Original number: n1
          Binary: 1111111
          Octal: 7777777

          Original number: n2
          Binary: 1111111
          Octal: 7777777

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_NumberSystemConverter>.txt (Ví dụ, NguyenVanA_123456_NumberSystemConverter.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_NumberSystemConverter>.zip (Ví dụ, NguyenVanA_123456_NumberSystemConverter.zip),
          nộp lên classroom.
         */
        Random rand = new Random();
        int[] numbers = new int[3];
        StringBuilder resultOutput = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            numbers[i] = rand.nextInt(1000); // Sinh số từ 0 đến 999
        }

        for (int n : numbers) {
            MyNumber myNumber = new MyNumber(n);

            BinaryConverter binaryConverter = new BinaryConverter(myNumber);
            OctalConverter octalConverter = new OctalConverter(myNumber);

            myNumber.addConverter(binaryConverter);
            myNumber.addConverter(octalConverter);

            System.out.println("Original number: " + n);
            System.out.print("Binary: ");
            binaryConverter.display();

            System.out.print("Octal: ");
            octalConverter.display();
        }
    }
}
