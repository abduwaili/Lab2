package author_book_Information;

import java.sql.Date;

/**
 *  ‰µƒœÍœ∏–≈œ¢
 * @author ∞¢∂≈
 *
 */
public class BookInfirmation {
	private String ISBN;
	private String Title;
	private int  AuthorID;
	private String Publisher;
	private Date PublishDate;
	private double Price;
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	

	
	
	
}
