import java.util.*;

public class PersonalRecord {
    private Set<Game> games = new HashSet<>();
    private Map<String, Game> record = new HashMap<>();
    private int totalKills = 0;
    private int totalDeaths = 0;
    private int totalAssists = 0;


    public void addNewGame(Game game) {
        games.add(game);
        record.put(game.getGameID(),game);
        this.totalKills += game.getKills();
        this.totalAssists += game.getAssists();
        this.totalDeaths += game.getDeaths();
    }
    public int getGameKills(String id){
        if(record.containsKey(id))
            return record.get(id).getKills();
        else
            return 0;
    }
    public int getGameDeaths(String id){
        if(record.containsKey(id))
            return record.get(id).getDeaths();
        else
            return 0;
    }
    public int getGameAssists(String id){
        if(record.containsKey(id))
            return record.get(id).getAssists();
        else
            return 0;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public int getTotalKills() {
        return totalKills;
    }

    //3 methods below update our in game KDA
    //also update total KDA
    public void updateGameKills(String id, int numKills){
        if(record.containsKey(id)){
            record.get(id).updateKills(numKills);
            this.totalKills += numKills;
        }
        else
            return;
    }
    public void updateGameDeaths(String id, int numDeaths){
        if(record.containsKey(id)){
            record.get(id).updateDeaths(numDeaths);
            this.totalDeaths += numDeaths;
        }
        else
            return;
    }
    public void updateGameAssists(String id, int numAssists){
        if(record.containsKey(id)) {
            record.get(id).updateAssists(numAssists);
            this.totalAssists += numAssists;
        }
        else
            return;
    }

    public void clearRecord(){
        //reset our record
        this.games = new HashSet<>();
        this.record = new HashMap<>();
        totalKills = 0;
        totalDeaths = 0;
        totalAssists = 0;
    }
    public void removeGame(String id){
        //remove a game from our history
        //won't change our total KDA
        Iterator<Game> g = games.iterator();
        while(g.hasNext()){
            if(g.next().getGameID().equals(id))
                games.remove(g);
        }
        record.remove(id);
    }
}
