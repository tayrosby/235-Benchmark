package data;

public interface DataAccessInterface<T> {
	
	public T findByWord(String word);
	public int findWordOccurence(String word);
	public T findFullVerse(String bookName, String chapter, String verseNumber);
	

}
