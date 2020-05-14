package fixtures;
import java.util.HashMap;
import java.util.Map;
import game.InputException;

public class Room extends Fixture {
	Map<String,Room> exits = new HashMap<String,Room>();
	
	
	public Room(String name, String shortDesc, String longDesc) {
		super(name,shortDesc,longDesc);	
	}
	
	public Map<String,Room> getExits() {
		return this.exits;
	}
	
	public Room getExit(String direction) throws InputException{
		if(this.exits.containsKey(direction)) {
			return this.exits.get(direction);
		} else {
			throw new InputException();
		}
	}
	
	public void setRightExits(Room exit) {
		exits.put("right", exit);
	}
	
	public void setLeftExits(Room exit) {
		exits.put("left", exit);
	}
	
	public void setDownstairs(Room exit) {
		if(exit.getName().equals("Unknown")) {
			exits.put("elevator", exit);
		} else {
			exits.put("downstairs", exit);
		}
	}
	public void setUpstairs(Room exit) {
		exits.put("upstairs", exit);
	}
	public void toBathroom(Room exit) {
		exits.put("bathroom", exit);
	}

}
