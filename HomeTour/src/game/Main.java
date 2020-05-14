package game;
import java.util.Map;
import java.util.Scanner;
import fixtures.Item;
import fixtures.Room;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		RoomManager rm = new RoomManager();
		rm.init();
		Player player = new Player();
		player.currentRoom = rm.startingRoom;
		System.out.println("Enter anything but 'quit' to start and enter 'quit' at anytime to Quit. After game is started only enter exact commands like 'left'.");
		String command = scanner.nextLine();
		boolean tv = false;
		while(!command.contentEquals("quit")){	
			printRoom(player);
			
			String current = player.currentRoom.getName();
			
//			current.equals("Living Room") ? itemUse() :System.out.println("No items to use.");
			if(current.equals("Living Room")) {
				if(!tv) {
					System.out.println("Tv is off... Use remote to turn on TV? 'y' or 'n'.");
				} else {
					System.out.println("Tv is on... Turn off? 'y' or 'n'.");
				}
				command = collectInput();
				if(command.equals("y") && !tv) {
					tv = true;
					System.out.println("The TV turned on! Choose a direction now!");
				} else if(command.equals("y") && tv) {
					tv = false;
					System.out.println("The TV turned off! Choose a direction now!");
				} else {
					System.out.println("Still in living room. Choose a direction now!");
				}
			}
			printExits(player.currentRoom);
			System.out.println("Enter 'details' to learn more about the room.");
			command = collectInput();
			
			if (command.equals("quit")) {
				System.out.println("Thank you for coming to see my home Bye!");
				break;
			}	else if(command.equals("details")) {
				printDetails(player.currentRoom);
				System.out.println("Enter direction according!");
				command = collectInput();
			}
			
			parse(command,player);
			
			if(player.currentRoom.getName().equals("Unknown")){
				String[] descs = player.currentRoom.getDescs();
				for(String ele: descs) {
					System.out.println(ele);
				}
				break;
			}
		}	
		scanner.close();
	}

	private static void printDetails(Room rm) {
		System.out.println(rm.getDescs()[0]+rm.getDescs()[1]);
	}
	private static void printRoom(Player player) {
		System.out.println("You are now in Room: "+player.currentRoom.getName());
	}
	
	private static void printExits(Room rm) {
		Map<String,Room> rooms =  rm.getExits();
		rooms.forEach((k,v)-> System.out.println((k+": "+v.getName())));
	}
	
	private static String collectInput() {
		String command = scanner.nextLine();
		return command;
	}
		
	private static void parse(String command, Player player) {	
		Room currentRoom = player.currentRoom;
		
		try {
			Room nextRoom = currentRoom.getExit(command);
			if(nextRoom != null) {
				player.currentRoom = nextRoom;
			}
			}catch(InputException ex) {
				ex.printStackTrace();
			}finally {
				
			}
	}
}
