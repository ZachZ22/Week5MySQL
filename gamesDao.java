package dao;

import entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gamesDao {




// Create a game
public void createGame(String name) throws SQLException {
    String sql = "INSERT INTO game (name) VALUES (?)";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = DbConnection.getInstance().getConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1, name);


        statement.executeUpdate();


    }finally {
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
}
// Get a game, This will show a list of games in game
public List<Game> getGames() throws SQLException{
    String sql = "SELECT * FROM game";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    List<Game> games = new ArrayList<>();

    try {
        connection = DbConnection.getInstance().getConnection();
        statement = connection.prepareStatement(sql);
        rs = statement.executeQuery();


        while(rs.next()){

            long gameId = rs.getLong("game_id");
            String name = rs.getString("name");
            Game game = new Game(gameId,name);
            games.add(game);

        }
        return games;


    }finally {

        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
        if(rs != null) {
            rs.close();
        }
    }
}

// This will update the game by the game ID
public void updateGame(long id, String name) throws SQLException{

    String  sql = "UPDATE game SET name = ? WHERE game_id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = DbConnection.getInstance().getConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setLong(2, id);


        statement.executeUpdate();


    }finally {

        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }



}

//This will delete the game by game ID
public void deleteGame(long gameId) throws SQLException{
    String sql = "DELETE FROM game WHERE game_id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = DbConnection.getInstance().getConnection();
        statement = connection.prepareStatement(sql);
        statement.setLong(1, gameId);


        statement.executeUpdate();


    }finally {

        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
}



}
