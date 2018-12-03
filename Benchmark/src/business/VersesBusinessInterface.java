package business;

import javax.ejb.Local;

@Local
public interface VersesBusinessInterface<T> {
	
	public T searchByWord(String word);
	public int findWordFrequency(String word);
	public T searchByVerse(String bookName, String chapter, String verseNumber);

	
}
