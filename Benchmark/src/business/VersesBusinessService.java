package business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import beans.Verse;
import data.DataAccessInterface;

@Stateless
@Local(VersesBusinessInterface.class)
public class VersesBusinessService implements VersesBusinessInterface<Verse>{

	@Inject
	DataAccessInterface<Verse> service;

	@Override
	public Verse searchByWord(String word) {
		// TODO Auto-generated method stub
		return service.findByWord(word);
		
	}
	
	@Override
	public int findWordFrequency(String word) {
		// TODO Auto-generated method stub
		return service.findWordOccurence(word);
	}
	
	@Override
	public Verse searchByVerse(String bookName, String chapter, String verseNumber) {
		// TODO Auto-generated method stub
		return service.findFullVerse(bookName, chapter, verseNumber);
		
	}
}