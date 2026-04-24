// import java.util.*;

// class Player {
//     String name;
//     int position;

//     Player(String name) {
//         this.name = name;
//         this.position = 0;
//     }
// }

// class SnakeLadder {
//     private Map<Integer, Integer> snakes = new HashMap<>();
//     private Map<Integer, Integer> ladders = new HashMap<>();
//     private Queue<Player> players = new LinkedList<>();
//     private int boardSize = 100;

//     public SnakeLadder() {
//         snakes.put(99, 10);
//         snakes.put(70, 55);

//         ladders.put(3, 22);
//         ladders.put(5, 50);
//     }

//     public void addPlayer(Player p) {
//         players.add(p);
//     }

//     private int rollDice() {
//         return new Random().nextInt(6) + 1;
//     }

//     public void startGame() {
//         while (true) {
//             Player current = players.poll();
//             int dice = rollDice();

//             int newPos = current.position + dice;

//             if (snakes.containsKey(newPos)) {
//                 newPos = snakes.get(newPos);
//             } else if (ladders.containsKey(newPos)) {
//                 newPos = ladders.get(newPos);
//             }

//             if (newPos <= boardSize) {
//                 current.position = newPos;
//             }

//             System.out.println(current.name + " -> " + current.position);

//             if (current.position == boardSize) {
//                 System.out.println(current.name + " wins!");
//                 break;
//             }

//             players.add(current);
//         }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         SnakeLadder game = new SnakeLadder();

//         game.addPlayer(new Player("A"));
//         game.addPlayer(new Player("B"));

//         game.startGame();
//     }
// }
