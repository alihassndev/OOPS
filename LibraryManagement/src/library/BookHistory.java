package library;

public class BookHistory {
    private String userId;
    private String bookId;
    private String action; // "ISSUED" or "RETURNED"
    private String timestamp;

    public BookHistory(String userId, String bookId, String action, String timestamp) {
        this.userId = userId;
        this.bookId = bookId;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", userId, bookId, action, timestamp);
    }
}