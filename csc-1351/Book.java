public class Book {
    private String title;
    private int edition;
    private String author;
    private int year;

    public Book(String bookTitle, String bookAuthor, int bookEdition, int bookYear) {
        title = bookTitle;
        author = bookAuthor;
        edition = bookEdition;
        year = bookYear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int book_Year) {
        year = book_Year;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int book_Edition) {
        edition = book_Edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String book_Title) {
        title = book_Title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String book_Author) {
        author = book_Author;
    }
}