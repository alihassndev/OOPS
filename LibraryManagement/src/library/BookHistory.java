package library;

import java.io.Serializable;
import java.time.LocalDate;

public class BookHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookId;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status; // "BORROWED", "RETURNED", "OVERDUE"

    public BookHistory(String bookId, String bookTitle, LocalDate borrowDate, LocalDate returnDate, String status) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters
    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookHistory{" +
                "bookId='" + bookId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}