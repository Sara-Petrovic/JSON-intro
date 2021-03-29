package main;

import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Main6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(FileReader file = new FileReader("movie_manual.json")){
			Gson gson = new Gson();
			
			JsonObject m = gson.fromJson(file, JsonObject.class);
			
			//sad vadimo propertije rucno
			System.out.println(m.get("imdbId").getAsString());
			System.out.println(m.get("title").getAsString());
			System.out.println(m.get("releaseYear").getAsInt());
			
			double rating = m.get("rating").getAsDouble()-1;
			System.out.println(rating);
			
			JsonArray actors = m.getAsJsonArray("actors");
			//ispisi ime drugog glumca
			System.out.println(actors.get(1).getAsString());
			
			
			Set<Entry<String, JsonElement>> es = m.entrySet();
			
			for (Entry<String, JsonElement> entry : es) {
				System.out.println(entry);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
