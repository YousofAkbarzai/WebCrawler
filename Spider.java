package SpiderMan;
import java.util.*;
public class Spider {
	// web crawler definition
	private static final int MAX_PAGES = 25;
	private int visitCount;
	private List<String> pagesVisited;
	private List<String> pagestoVisit;
    
	public Spider (int visitcount, List<String> pagesvisited, List<String> pagestogo) {
	    this.visitCount = visitcount;
		this.pagesVisited = pagesvisited;
		this.pagestoVisit = pagestogo;
	}
	
	public int getVisitCount () {
		return visitCount;
	}
	
	public List<String> getPagesVisited () {
		return pagesVisited;
	}
	
	public void incrVisitCount () {
		if (visitCount == MAX_PAGES) {
			System.out.println(toString());
			System.out.println("Reached Max Pages");
			System.exit(0);
		}
		visitCount++;
	}
	
	public void addPagesVisited (String page) {
		 pagesVisited.add(page);
	}
	
	public List<String> getPagestogo () {
		return pagestoVisit;
	}
	
	public void addtopagestogo (String page) {
		pagestoVisit.add(page);
	}
	
	
	
	public String toString () {
		return "# of pages visited: " + visitCount + "\n" + pageStream();
	}
	private String pageStream() {
		String string = "";
		for (int i = 0; i < pagesVisited.size(); i++) {
			string = string + pagesVisited.get(i) + "\n";
		}
		return string;
	}

}
