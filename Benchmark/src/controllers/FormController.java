package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Verse;
import business.VersesBusinessInterface;
import data.VerseDataService;

@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	VersesBusinessInterface<Verse> service;
	
	@Inject
	VerseDataService dataService;
	
public String onSearchFull(Verse verse) {
	
		dataService.findFullVerse(verse.getBookName(), verse.getChapter(), verse.getVerseNumber());
		
		//forward to test response view along with the user managed bean
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("verse", verse);
		return "localhost:8080/Benchmark/rest/verses/getversefull/" +verse.getBookName()+ "/" + verse.getChapter() + "/" + verse.getVerseNumber();
		
	}

}
