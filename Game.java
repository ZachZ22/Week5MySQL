package entity;

public class Game {

    // Name and ID variables
    private long gameId;
    private String name;


    // Game constructor
    public Game(long gameId, String name){
        this.gameId = gameId;
        this.name = name;

    }



    public String getName() {
        return name;
    }

    public long getGameId() {
        return gameId;
    }



    public String toString(){
        return "Game [gameId=" + gameId + ", name=" + name + "]";
    }

}



