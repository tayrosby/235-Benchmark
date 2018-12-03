package business;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beans.Verse;

@RequestScoped
@Path("/verses")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class VersesRestService {
	
	
	@Inject
	VersesBusinessInterface<Verse> service;
		
		//localhost:8080/Benchmark/rest/verses/getversebyword/{word}
		@GET
		@Path("/getversebyword/{word}")
		@Produces(MediaType.APPLICATION_JSON)
		public Verse getVerse(@PathParam("word") String word) {
			
			System.out.println("API was /getverse: I recieved a request for name: " + word);
			
			
			 return service.searchByWord(word);
		}
		
		//localhost:8080/Benchmark/rest/verses/getwordfrequency/{word}
		@GET
		@Path("/getwordfrequency/{word}")
		@Produces(MediaType.APPLICATION_JSON)
		public int getWord(@PathParam("word") String word) {
			
			System.out.println("API was /getverse: I recieved a request for name: " + word);
			
			 return service.findWordFrequency(word);
		}
	
		//localhost:8080/Benchmark/rest/verses/getversefull/{bookname}/{chapter}/{versenumber}
		@GET
		@Path("/getversefull/{bookname}/{chapter}/{versenumber}")
		@Produces(MediaType.APPLICATION_JSON)
		public Verse getVerse(@PathParam("bookname") String bookName, @PathParam("chapter") String chapter, @PathParam("versenumber") String verseNumber) {
			
			System.out.println("API was /getverse: I recieved a request for verse: " + bookName + chapter + verseNumber);
			//return new Verse();
			return service.searchByVerse(bookName, chapter, verseNumber);
		}
}
