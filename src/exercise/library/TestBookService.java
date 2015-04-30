package exercise.library;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestBookService {

	private BookService service = new BookServiceImpl();
	Exception exception;

	@Before
	public void before() {
		exception = null;
	}

	@Test
	public void testRetrieveBookNull() {

		try {
			service.retrieveBook(null);
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof InvalidIsbnException);
	}

	@Test
	public void testRetrieveBookInvalidIsbn() {
		try {
			service.retrieveBook("INVALID-TEXT");
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof InvalidIsbnException);
	}

	@Test
	public void testRetrieveBookNotFound() {
		try {
			service.retrieveBook("ISBN-777");
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof BookNotFoundException);
	}

	@Test
	public void testRetrieveBookValid() {
		Book book = null;
		try {
			book = service.retrieveBook("ISBN-001");
		} catch (Exception e) {
			fail();
		}

		assertTrue(book.getTitle().equals("Harry Potter and the Deathly Hallows"));
	}

	@Test
	public void testGetBookSummaryNull() {

		try {
			service.getBookSummary(null);
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof InvalidIsbnException);
	}

	@Test
	public void testGetBookSummaryInvalidIsbn() {
		try {
			service.getBookSummary("INVALID-TEXT");
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof InvalidIsbnException);
	}

	@Test
	public void testGetBookSummaryNotFound() {
		try {
			service.getBookSummary("ISBN-777");
		} catch (Exception e) {
			exception = e;
		}

		assertTrue(exception instanceof BookNotFoundException);
	}

	@Test
	public void testGetBookSummaryValid() {
		String bookSummary = null;
		try {
			bookSummary = service.getBookSummary("ISBN-001");
		} catch (Exception e) {
			fail();
		}

		assertTrue(bookSummary.equals("[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic."));
	}

}
