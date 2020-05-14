package fixtures;
import java.util.HashMap;
import java.util.Map;

public class Item extends Fixture {
	
	public Item(String name, String shortDesc, String longDesc) {
		super(name,shortDesc,longDesc);	
	}
	
	Map<String,Item> items = new HashMap<String,Item>();
	
	public void useRemote(Item switchOn,Item tv) {
		items.put("tv", tv);
		items.put("tvremote", switchOn);		
	}
}
