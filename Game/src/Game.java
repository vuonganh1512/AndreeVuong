public class Game {
    private int kills;
    private int deaths;
    private int assists;
    private String gameID;
    public Game(int kills, int deaths, int assists, String gameID ){
        this.assists = assists;
        this.kills = kills;
        this.deaths = deaths;
        this.gameID = gameID;
    }

    public int getAssists() {
        return assists;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getKills() {
        return kills;
    }

    public String getGameID() {
        return gameID;
    }
    //In a game Kills, Assists and Deaths can only increase
    public void updateKills(int numKills) {
        this.kills += numKills;
    }

    public void updateAssists(int numAssists) {
        this.assists += numAssists;
    }

    public void updateDeaths(int numDeaths) {
        this.deaths += numDeaths;
    }
}