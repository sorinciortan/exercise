package exercise.library;

public class BookServiceImpl implements BookService {

	@Override
	public Book retrieveBook(String isbn) throws BookNotFoundException, InvalidIsbnException {
		
		if (isbn == null || !isbn.startsWith("ISBN-")) {
			throw new InvalidIsbnException("Book ISBN must begin with 'ISBN-'.");
		}
		
		BookRepository repository = new BookRepositoryImpl();
		Book book = repository.retrieveBook(isbn);
		
		if (book == null) {
			throw new BookNotFoundException();
		}
		
		return book;
	}

	@Override
	public String getBookSummary(String isbn) throws BookNotFoundException, InvalidIsbnException {
		Book book = retrieveBook(isbn);
		return "[" + book.getIsbn() + "] " + book.getTitle() + " - " + book.getDescription();
	}

}
