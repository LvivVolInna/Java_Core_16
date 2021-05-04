package hw16;

import java.io.Serializable;


public class FanatasyBook extends Book implements Serializable {

	private String author = "Rowling";
	private String bookTitle = "Philisopher`s stone";
	public int numberOfPages;
	public String languageOfTranslation;

	public FanatasyBook() {
		super();
	}

	public FanatasyBook(String author, String bookTitle) {
		super();
		this.author = author;
		this.bookTitle = bookTitle;
	}

	public FanatasyBook(int numberOfPages, String languageOfTranslation) {
		super();
		this.numberOfPages = numberOfPages;
		this.languageOfTranslation = languageOfTranslation;
	}

	public FanatasyBook(String author, String bookTitle, int numberOfPages, String languageOfTranslation) {
		super();
		this.author = author;
		this.bookTitle = bookTitle;
		this.numberOfPages = numberOfPages;
		this.languageOfTranslation = languageOfTranslation;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguageOfTranslation() {
		return languageOfTranslation;
	}

	public void setLanguageOfTranslation(String languageOfTranslation) {
		this.languageOfTranslation = languageOfTranslation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + ((languageOfTranslation == null) ? 0 : languageOfTranslation.hashCode());
		result = prime * result + numberOfPages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FanatasyBook other = (FanatasyBook) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (languageOfTranslation == null) {
			if (other.languageOfTranslation != null)
				return false;
		} else if (!languageOfTranslation.equals(other.languageOfTranslation))
			return false;
		if (numberOfPages != other.numberOfPages)
			return false;
		return true;
	}
	
	public void firstUpperCase(String author) {
		String[] names = author.split("\\s");
		this.author = "";
		for(String s: names) {
			this.author += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
		}
		if(author == null || author.isEmpty()) {
			System.out.println("  ");	
		}
		System.out.println("New author: " + this.author);
	}
	
	public void translate(String lang, int k) {
		languageOfTranslation = lang;
		if(languageOfTranslation!="english") {
			this.numberOfPages += k;
			System.out.println("Number of pages after translation: " + numberOfPages);
		}
	}

	@Override
	public String toString() {
		return "FanatasyBook [author=" + author + ", bookTitle=" + bookTitle + ", numberOfPages=" + numberOfPages
				+ ", languageOfTranslation=" + languageOfTranslation + "]";
	}

}
