package hus.oop.book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> bookList;

    public BookManager() {
        /* TODO */
        bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    private boolean checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit){
            return false;
        }
        return true;
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void append(Book book) {
        /* TODO */
        bookList.add(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAtPosition(Book book, int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size())){
            bookList.add(index, book);
        };
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)){
            bookList.remove(index);
        }
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        /* TODO */
        if (checkBoundaries(index, bookList.size() - 1)){
            return bookList.get(index);
        }
        return null;
    }

    /**
     * Trả ra số book trong danh sách.
     * @return
     */
    public int numberOfBooks() {
        /* TODO */
        return bookList.size();
    }

    /**
     * Tổng giá của tất cả các book.
     * @return
     */
    public double totalPrice() {
        /* TODO */
        double sum = 0;
        for (Book book: bookList){
            sum += book.getPrice();
        }
        return sum;
    }

    /**
     * Tổng số trang của tất cả các book.
     * @return
     */
    public double totalPages() {
        /* TODO */
        double sum = 0;
        for (Book book: bookList){
            sum += book.getPages();
        }
        return sum;
    }

    /**
     * Trả ra danh sách book theo thứ tự tăng dần theo title.
     * @return
     */
    public List<Book> sortIncreasingByTitle() {
        /* TODO */
        for (int i = 0; i < bookList.size() - 1; i++){
            for (int j = i + 1; j < bookList.size(); j++){
                Book book1 = bookAt(i);
                Book book2 = bookAt(j);
                if (book1.compareTo(book2) > 0){
                    Book temp = book1;
                    bookList.set(i, book2);
                    bookList.set(j, temp);
                }
            }
        }
        return bookList;
    }

    /**
     * Trả ra book sắp xếp theo tiêu chí: đầu tiên theo publisher tăng dần, nếu cùng publisher thì theo thứ tự giá giảm dần.
     * Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortByPublisherAndPrice() {
        /* TODO */
        MyBookComparator comparator = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                if (left.getPublisher().equals(right.getPublisher())){
                    if (left.getPrice() < right.getPrice()){
                        return 1;
                    }
                    else if (left.getPrice() > right.getPrice()){
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
                return left.getPublisher().compareTo(right.getPublisher());
            }
        };

        List<Book> copy = new ArrayList<>();

        for (Book book: bookList){
            copy.add(book);
        }

        for (int i = 0; i < copy.size() - 1; i++){
            for (int j = i + 1; j < copy.size(); j++){
                Book book1 = bookAt(i);
                Book book2 = bookAt(j);
                if (comparator.compare(book1, book2) > 0){
                    Book temp = book1;
                    copy.set(i, book2);
                    copy.set(j, temp);
                }
            }
        }
        return copy;
    }

    /**
     * Trả ra danh sách book sắp xếp theo giá tăng dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortIncreasingPrice() {
        /* TODO */
        MyBookComparator comparator = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                if (left.getPrice() > right.getPrice()){
                    return 1;
                } else if (left.getPrice() < right.getPrice()) {
                    return -1;
                }
                return 0;
            }
        };

        List<Book> copy = new ArrayList<>();

        for (Book book: bookList){
            copy.add(book);
        }

        for (int i = 0; i < copy .size() - 1; i++){
            for (int j = i + 1; j < copy .size(); j++){
                Book book1 = bookAt(i);
                Book book2 = bookAt(j);
                if (comparator.compare(book1, book2) > 0){
                    Book temp = book1;
                    copy.set(i, book2);
                    copy.set(j, temp);
                }
            }
        }
        return copy ;
    }

    /**
     * Trả ra danh sách book theo giá giảm dần. Sử dụng giao diện MyBookComparator để thực hiện tiêu chí sắp xếp.
     * Không làm thay đổi thứ tự book trong danh sách ban đầu.
     * @return
     */
    public List<Book> sortDecreasingPrice() {
        /* TODO */
        MyBookComparator comparator = new MyBookComparator() {
            @Override
            public int compare(Book left, Book right) {
                if (left.getPrice() > right.getPrice()){
                    return 1;
                } else if (left.getPrice() < right.getPrice()) {
                    return -1;
                }
                return 0;
            }
        };

        List<Book> copy = new ArrayList<>();

        for (Book book: bookList){
            copy.add(book);
        }
        for (int i = 0; i < copy.size() - 1; i++){
            for (int j = i + 1; j < copy.size(); j++){
                Book book1 = bookAt(i);
                Book book2 = bookAt(j);
                if (comparator.compare(book1, book2) < 0){
                    Book temp = book1;
                    copy.set(i, book2);
                    copy.set(j, temp);
                }
            }
        }
        return copy;
    }

    /**
     * Trả ra danh sách book theo thể loại.
     * @param genre
     * @return
     */
    public List<Book> filterBooksOfGenre(String genre) {
        /* TODO */
        List<Book> res = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getGenre().equals(genre)){
                res.add(bookList.get(i));
            }
        }
        return res;
    }

    /**
     * Trả ra danh sách book theo tác giả.
     * @param author
     * @return
     */
    public List<Book> filterBooksOfAuthor(String author) {
        /* TODO */
        List<Book> res = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getAuthor().equals(author)){
                res.add(bookList.get(i));
            }
        }
        return res;
    }

    /**
     * Trả ra danh sách book theo publisher.
     * @param publisher
     * @return
     */
    public List<Book> filterBooksOfPublisher(String publisher) {
        /* TODO */
        List<Book> res = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++){
            if (bookList.get(i).getPublisher().equals(publisher)){
                res.add(bookList.get(i));
            }
        }
        return res;
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
