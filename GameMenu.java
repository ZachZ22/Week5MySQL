package games;

import dao.gamesDao;
import entity.Game;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GameMenu {

    private Scanner scanner = new Scanner(System.in);
    private gamesDao gamesDao = new gamesDao();


    // Main Method to run the games menu
    public void start() {
        while (true) {
        printInstructions();

        System.out.println("Enter a selection: ");
        String choice = scanner.nextLine();

            try {
                if (choice.isBlank()) {
                    break;
                }
                switch (choice) {
                    case "1":
                        createGame();
                        break;
                    case "2":
                        updateGame();
                        break;
                    case "3":
                        showGames();
                        break;
                    case "4":
                        deleteGame();
                        break;
                  default:
                        System.out.println("Invalid selection, Try again.");
                        break;
                }


            }catch (SQLException e){
                System.out.println("Error: " + e.toString());
                break;
            }
        }





    }

    // This will delete a game by calling the method from gamesDao
    private void deleteGame() throws SQLException{

        showGames();
        System.out.println("Enter game id to delete");
        long id = Long.parseLong(scanner.nextLine());
        gamesDao.deleteGame(id);

        showGames();

    }
    // This will show games by calling the method from gamesDao
    private void showGames() throws SQLException {

       List<Game>games = gamesDao.getGames();
        games.stream().forEach(System.out::println);

    }
    // This will update a game by calling the method from gamesDao
    private void updateGame() throws SQLException {

        System.out.print("Enter the Game ID: ");
        showGames();
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Enter the new Game name");
        String name = scanner.nextLine();

        gamesDao.updateGame(id, name);
        showGames();



    }

    // This will create a game by calling the method from gamesDao
    private void createGame() throws SQLException {

        System.out.print("Enter a game name: ");
        String name = scanner.nextLine();
        gamesDao.createGame(name);

    }

    // This will print a menu to make a selection from.
    private void printInstructions() {
        System.out.println("*************************");
        System.out.println("*******GAMES MENU********");
        System.out.println("*************************");
        System.out.println("Here are the options");
        System.out.println("1) Create a Game");
        System.out.println("2) Update a Game");
        System.out.println("3) List all Games");
        System.out.println("4) Delete a Game");

    }
}
