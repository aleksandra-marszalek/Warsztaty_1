package popular_words_search;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Popular_words_search {

	public static void main(String[] args) {
		search();
	}
	
	
	static void search() {
		
		// I start with the formula found in description of the workshop - to take the data from the website.
		
		Connection connect = Jsoup.connect("http://www.onet.pl/"); 
		try {
			Document document = connect.get();
			Elements links = document.select("span.title"); 
			PrintWriter out = new PrintWriter("popular_words.txt");
			
			// for every title, I save it in the prepared file.
			for (Element elem : links) {
				
				out.println(elem.text());
				
			}
			out.close();
			
			
			// Then from the file I take the words, and check if their length is 3 or more and 
			//		if they are not present in the prohibited words array prepared.
			// If both conditions are fullfiled, the word is written in the next file - filtered_popular_words.
			
			File popularFile = new File("popular_words.txt"); 
			Scanner scan = new Scanner(popularFile); 
		//	String[] filtered = new String [0];
			String[] prohibited = {"oraz", "ponieważ", "dlatego", "więc", "także", "jest", "będzie", "nie", "był",
								  "była", "tak", "bez", "dla", "mam"};
			PrintWriter filteredWords = new PrintWriter("filtered_popular_words.txt");
			while (scan.hasNext()) {
			    String word = scan.next();
			    if (word.length()>=3 && (!Arrays.asList(prohibited).contains(word.toLowerCase()))) {
			    		filteredWords.print(word+ ", ");
			    }
			}
			filteredWords.close();
			scan.close();
			
			
			} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
