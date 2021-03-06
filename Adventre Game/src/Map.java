
public class Map
	{

		static Room[][] map = new Room[10][10];

		public Room[][] getMap()
			{
				return map;
			}

		public void setMap(Room[][] map)
			{
				Map.map = map;
			}

		public static void generateRoom(int x, int y, String roomType, double doorWeight)
			{

				map[x][y] = new Room(roomType, generateDoors(x, y, doorWeight), null, "Just a Generic Room");

			}

		public static String[] generateDoors(int x, int y, double doorWeight)
			{

				String north = "north";
				String west = "west";
				String south = "south";
				String east = "east";
				String[] directions = { north, west, south, east };

				String[] doors = new String[4];
				// First set all rooms as random
				// System.out.println("setting rooms to random for room at
				// "+x+", "+y);
				for (int i = 0; i < directions.length; i++) {
					if ((int) (Math.random() * 100)+1 <= (int) ((1-doorWeight)*100)) {
						doors[i] = directions[i];
						// System.out.println("randomly created door facing
						// "+directions[i]);
					}
				}
				// Second , check all adjacent rooms, and if one exists, make
				// the doors consistent

				// NORTH
				if (y != 0) {
					// if room above, set to that room
					if (map[x][y - 1] != null) {

						if (map[x][y - 1].getDoors()[2] == south) {
							doors[0] = north;
						} else {
							doors[0] = null;
						}
						// System.out.println("Door facing North made
						// consistent");
					}
				} else {
					// if no room allowed, make it null
					doors[0] = null;
					// System.out.println("No room existed north, door door made
					// consistently nonexistent");
				}

				// WEST
				if (x != 0) {
					// if room to left, set to that room
					if (map[x - 1][y] != null) {

						if (map[x - 1][y].getDoors()[3] == east) {
							doors[1] = west;
						} else {
							doors[1] = null;
						}
						// System.out.println("Door facing West made
						// consistent");
					}
				} else {
					// if no room allowed, make it null
					doors[1] = null;
					// System.out.println("No room existed west, door door made
					// consistently nonexistent");
				}

				// SOUTH
				if (y != map[0].length - 1) {
					if (map[x][y + 1] != null) {
						// if room below, set to that room

						if (map[x][y + 1].getDoors()[0] == south) {
							doors[2] = south;
						} else {
							doors[2] = null;
						}
						// System.out.println("Door facing South made
						// consistent");
					}
				} else {
					// if no room allowed, make it null
					doors[2] = null;
					// System.out.println("No room existed south, door door made
					// consistently nonexistent");
				}

				// EAST
				if (x != map.length - 1) {
					if (map[x + 1][y] != null) {
						// if room below, set to that room

						if (map[x + 1][y].getDoors()[1] == west) {
							doors[3] = east;
						} else {
							doors[3] = null;
						}
						// System.out.println("Door facing East made
						// consistent");
					}
				} else {
					// if no room, make it null
					doors[3] = null;
					// System.out.println("No room existed east, door door made
					// consistently nonexistent");
				}

				// System.out.println("Final doors;
				// "+doors[0]+":"+doors[1]+":"+doors[2]+":"+doors[3]);

				return doors;

			}

	}
