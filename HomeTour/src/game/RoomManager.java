package game;
import fixtures.Room;
import fixtures.Item;
import java.util.HashMap;
import java.util.Map;

public class RoomManager {
	Room startingRoom;
	Room[] rooms = new Room[4];
	
	public void init() {
	    Room foyer = new Room(
			"The Foyer",
			"A small foyer",
			"Small foyer thats leads either to the dining room on the left or the living room to the right.");
			this.rooms[0] = foyer;
	        this.startingRoom = foyer;
	    Room livingRoom = new Room(
	    	"Living Room", "The living room","A room with a tv and with the foyer on the left and the kitchen on the right");
	    	rooms[1] = livingRoom;
	    Room kitchen = new Room(
	    	"The Kitchen","A medium sized kitchen.","A kitchen with food cooking. The dining room is to the right and the living room to the left");
	    	rooms[3] = kitchen;
	    Room diningRoom = new Room(
	    	"Dining Room", "The dining room","A room with tables and chairs with the kitchen on the right and the foyer on the left.");
	    	rooms[2] = diningRoom;
	    Room basement = new Room(
	    		"Basement","A big basement","This basement holds a washer and dyer machine and all sorts of utilities... There seems to be an elavator.");
	    Room myBedroom = new Room(
	    		"The Attic","Brantch's bedroom","Two twin beds are pulled together and two labtops are opened on one of the beds. The attic is a mess.");
	    Room hell = new Room(
	    		"Unknown","You are dead now the evelator goes straight down(Hell).","Never take an elevator down below a basement... what were you expecting?");
	    Room bathroomL = new Room(
	    		"A bathroom","A medium sized bathroom","There's a toilet, sink, shower and tub. A Standard bathroom.");
	    Room bathroomD = new Room(
	    		"A bathroom","A medium sized bathroom","There's a toilet, sink, shower and tub. A Standard bathroom.");
	    Item tv = new Item(
	    		"A TV","A nice TV","You can use the remote to turn on");
	    Item remote = new Item(
	    		"A remote","A black remote","You can use the remote to turn on the TV");
	    
	    
	    foyer.setRightExits(livingRoom);
	    foyer.setLeftExits(diningRoom);
	    livingRoom.setLeftExits(foyer);
	    livingRoom.setRightExits(kitchen);
	    kitchen.setLeftExits(livingRoom);
	    kitchen.setRightExits(diningRoom);
	    kitchen.setDownstairs(basement);
	    diningRoom.setLeftExits(kitchen);
	    diningRoom.setRightExits(foyer);
	    basement.setUpstairs(kitchen);
	    basement.setDownstairs(hell);
	    livingRoom.setUpstairs(myBedroom);
	    myBedroom.setDownstairs(livingRoom);
	    livingRoom.toBathroom(bathroomL);
	    bathroomL.setLeftExits(livingRoom);
	    diningRoom.toBathroom(bathroomD);
	    bathroomD.setRightExits(diningRoom);
	    remote.useRemote(remote,tv);
	    
	}
}
