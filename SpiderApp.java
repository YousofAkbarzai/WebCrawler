package SpiderMan;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



public class SpiderApp {
	public static void main(String[] args) {
		//creates Spider crawler
		Spider crawler = new Spider (0, new ArrayList<String>(), new ArrayList<String>());
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hey there!\nI'm a spider and I'm in a real pickle!\nI need your help to crawl through webpages.\nWhere should I start?");
		String ans = scanner.next();
		System.out.println("Ok, I'm going to get started!\nI'll let you know how it goes when I'm finished!");
		scanner.close();
		
		crawler.addtopagestogo(ans);
		
		do  {
			crawler.addPagesVisited(crawler.getPagestogo().get(0));
			crawler.incrVisitCount();
			try {
				Document document = Jsoup.connect(crawler.getPagestogo().remove(0)).get();
				Elements urls = document.select("a[href]");
				for (Element link: urls) {
					if (!( (link.attr("href")).contains("https://") )) {
						continue;
					}
					crawler.addtopagestogo(link.attr("href"));
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		} while (!(crawler.getPagestogo().isEmpty()));
		
		
		System.out.println(crawler.toString());
		
		

		
	
		
		
		
		
		
	}
}
