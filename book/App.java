package hus.oop.book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    private static final String COMMA_DELIMITER = ",";

    private static final BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortIncreasingTitle();
        testSortPublisherAndPrice();
        testPriceOfBooksIncreasing();
        testPriceOfBooksDecreasing();
        testFilterBooksOfAuthor();
        testFilterBooksOfPublisher();
        testFilterBooksOfGenre();
        System.out.println("Total Pages: " + testTotalPages());
        System.out.println("Total Price: " + testTotalPrice());

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test theo format:
              Tên test:
              Kết quả chạy chương trình.

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_BookManager>.txt (Ví dụ, NguyenVanA_123456_BookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookManager>.zip (Ví dụ, NguyenVanA_123456_BookManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào bookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                int pages = Integer.parseInt(dataList.get(3));
                double price = Double.parseDouble(dataList.get(4));
                String publisher = dataList.get(5);

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPages(pages)
                        .withPrice(price)
                        .withPublisher(publisher)
                        .build();
                bookManager.append(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    /*
     * In ra danh sách book theo thứ tự đọc vào ban đầu, mỗi book được in trên 1 dòng theo format book
     * được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testOriginalData() {
        /* TODO */
        System.out.println("Original Data:");
        BookManager.print(bookManager.getBookList());
    }

    /*
     * In ra danh sách book theo thứ tự tăng dần của title, mỗi book được in trên 1 dòng theo format book
     * được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testSortIncreasingTitle() {
        /* TODO */
        System.out.println("\nSort Increasing Title:");
        BookManager.print(bookManager.sortIncreasingByTitle());
    }

    /*
     * Test in ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testSortPublisherAndPrice() {
        /* TODO */
        System.out.println("\nSort by Publisher and Price:");
        BookManager.print(bookManager.sortByPublisherAndPrice());
    }

    /*
     * Test in ra danh sách book theo giá tăng dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksIncreasing() {
        /* TODO */
        System.out.println("\nSort Increasing Price:");
        BookManager.print(bookManager.sortIncreasingPrice());
    }

    /*
     * Test in ra danh sách book theo giá giảm dần.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testPriceOfBooksDecreasing() {
        /* TODO */
        System.out.println("\nSort Decreasing Price:");
        BookManager.print(bookManager.sortDecreasingPrice());
    }

    /*
     * Test in ra danh sách book theo tác giả.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        System.out.println("\nFilter Books of Author 'Harper Lee':");
        BookManager.print(bookManager.filterBooksOfAuthor("Harper Lee"));
    }

    /*
     * Test in ra danh sách book theo nhà xuất bản.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        System.out.println("\nFilter Books of Publisher 'Penguin Books':");
        BookManager.print(bookManager.filterBooksOfPublisher("Penguin Books"));
    }

    /*
     * Test in ra danh sách book theo thể loại.
     * Mỗi book được in trên 1 dòng theo format book được định nghĩa trong trong hàm toString() của Book.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        System.out.println("\nFilter Books of Genre 'Fiction':");
        BookManager.print(bookManager.filterBooksOfGenre("Fiction"));
    }

    /*
     * In ra tổng số trang của tất cả các book.
     */
    public static int testTotalPages() {
        /* TODO */
        return bookManager.totalPages();
    }

    /*
     * In ra tổng giá của tất cả các sách.
     */
    public static double testTotalPrice() {
        /* TODO */
        return bookManager.totalPrice();
    }
}