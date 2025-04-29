package hus.oop.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        /* TODO */
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        this.bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAtPosition(Book book, int index) {
        /* TODO */
        this.bookList.add(index, book);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        return this.bookList.get(index);
    }

    /**
     * Trả ra số book trong danh sách.
     * @return
     */
    public int numberOfBooks() {
        /* TODO */
        return this.bookList.size();
    }

    /**
     * Tổng giá của tất cả các book.
     * @return
     */
    public double totalPrice() {
        /* TODO */
        return this.bookList.stream().mapToDouble(Book::getPrice).sum();
    }

    /**
     * Tổng số trang của tất cả các book.
     * @return
     */
    public int totalPages() {
        /* TODO */
        return this.bookList.stream().mapToInt(Book::getPages).sum();
    }

    /**
     * Trả ra danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        /* TODO */
        return this.bookList.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
    }

    /**
     * Trả ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortByPublisherAndPrice() {
        /* TODO */
        return this.bookList.stream()
                .sorted(Comparator.comparing(Book::getPublisher).thenComparing(Book::getPrice, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    /**
     * Trả ra danh sách book sắp xếp theo giá tăng dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        return this.bookList.stream().sorted(Comparator.comparing(Book::getPrice)).collect(Collectors.toList());
    }

    /**
     * Trả ra danh sách book theo giá giảm dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        return this.bookList.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).collect(Collectors.toList());
    }

    /**
     * Trả ra danh sách book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        return this.bookList.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    /**
     * Trả ra danh sách book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        return this.bookList.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    /**
     * Trả ra danh sách book theo publisher.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        return this.bookList.stream().filter(book -> book.getPublisher().equals(publisher)).collect(Collectors.toList());
    }

    public static String titleOfBooksToString(List<Book> bookList) {
        StringBuilder titleOfBooks = new StringBuilder();
        titleOfBooks.append("[\n");
        for (Book book : bookList) {
            titleOfBooks.append(book.getTitle()).append("\n");
        }
        return titleOfBooks.toString().trim() + "\n]";
    }

    public static void print(List<Book> bookList) {
        StringBuilder booksString = new StringBuilder();
        booksString.append("[\n");
        for (Book book : bookList) {
            booksString.append(book.toString()).append("\n");
        }
        System.out.print(booksString.toString().trim() + "\n]");
    }
}