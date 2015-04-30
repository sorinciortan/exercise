package exercise.library;

public interface BookService
{
    public Book retrieveBook(String isbn) throws BookNotFoundException, InvalidIsbnException;
    public String getBookSummary(String isbn) throws BookNotFoundException, InvalidIsbnException;
}
