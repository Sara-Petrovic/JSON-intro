package main;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import movie.Movie;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Movie m = new Movie();
		m.setImdbId("tt0116367");
		m.setTitle("From dusk till dawn");
		m.setReleaseYear(1996);
		m.setRating(7.2);
		
		String[] actors = {"George Clooney", "Quentin Tarantino"};
		m.setActors(actors);
		
		System.out.println(m);
		//Gson gson = new Gson();
		//da bi bio lep json:
		try(FileWriter file = new FileWriter("movie.json")){//try with resources, automatski ce zatvoriti filewriter cak i ako pukne exception
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		
			//String json = gson.toJson(m);
		
			//file.write(json);
			
			gson.toJson(m, file); //drugi nacin, prosledjujem i string i writer
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
