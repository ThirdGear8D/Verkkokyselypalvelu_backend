package ThirdGear.Kyselypalvelu_backend.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.List;

import com.google.gson.Gson;




public class JsonReader {

	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	static class Item {
	    String nimi;
	  
	}

	static class Page {
	  
	    List<Item> items;
	}

	public static void main(String[] args) throws Exception {

	    String json = readUrl("http://localhost:8080/api/kyselyt");

	    Gson gson = new Gson();        
	    Page page = gson.fromJson(json, Page.class);

	    System.out.println(page);
	    for (Item item : page.items)
	        System.out.println("    " + item.nimi);
	}
	
}
