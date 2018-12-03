package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Verse {

	String bookName;
	String chapter;
	String verseNumber;
	String verse;
	
	public Verse() {
		
	}
	
	public Verse(String bookName, String chapter, String verseNumber) {
		this.bookName = bookName;
		this.chapter = chapter;
		this.verseNumber = verseNumber;
	}

	public Verse(String verse) {
		this.verse = verse;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getVerseNumber() {
		return verseNumber;
	}

	public void setVerseNumber(String verseNumber) {
		this.verseNumber = verseNumber;
	}

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}
}
