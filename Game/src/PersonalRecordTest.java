
import org.junit.Before;

import static org.junit.Assert.*;

public class PersonalRecordTest {
    PersonalRecord pr;
    @Before
    public void setUp() throws Exception{
        pr = new PersonalRecord();
    }
    @org.junit.Test
    public void addNewGame() {
        assertEquals(0,pr.getTotalAssists());
        assertEquals(0,pr.getTotalDeaths());
        assertEquals(0,pr.getTotalKills());
        Game g1 = new Game(2,3,5,"test1");
        Game g2 = new Game(5,6,7,"test2");
        pr.addNewGame(g1);
        assertEquals(2,pr.getTotalKills());
        assertEquals(3,pr.getTotalDeaths());
        assertEquals(5,pr.getTotalAssists());
        pr.addNewGame(g2);
        assertEquals(7,pr.getTotalKills());
        assertEquals(9,pr.getTotalDeaths());
        assertEquals(12,pr.getTotalAssists());
        assertEquals(2,pr.getGameKills("test1"));
        assertEquals(7,pr.getGameAssists("test2"));
    }

    @org.junit.Test
    public void updateGameKills() {
        Game g1 = new Game(1,2,3,"test1");
        Game g2 = new Game(7,0,2,"test2");
        pr.addNewGame(g1);
        pr.addNewGame(g2);
        assertEquals(1,pr.getGameKills("test1"));
        assertEquals(7,pr.getGameKills("test2"));
        pr.updateGameKills("test1",4);
        assertEquals(5,pr.getGameKills("test1"));
        assertEquals(12,pr.getTotalKills());
        pr.updateGameKills("test11",4);
        assertEquals(12,pr.getTotalKills());
    }

    @org.junit.Test
    public void updateGameDeaths() {
        Game g1 = new Game(1,2,3,"test1");
        Game g2 = new Game(7,0,2,"test2");
        pr.addNewGame(g1);
        pr.addNewGame(g2);
        assertEquals(2,pr.getGameDeaths("test1"));
        assertEquals(0,pr.getGameDeaths("test2"));
        pr.updateGameDeaths("test1",4);
        assertEquals(6,pr.getGameDeaths("test1"));
        assertEquals(6,pr.getTotalDeaths());
        pr.updateGameDeaths("test6",4);
        assertEquals(6,pr.getTotalDeaths());
    }

    @org.junit.Test
    public void updateGameAssists() {
        Game g1 = new Game(1,2,3,"test1");
        Game g2 = new Game(7,0,2,"test2");
        pr.addNewGame(g1);
        pr.addNewGame(g2);
        assertEquals(3,pr.getGameAssists("test1"));
        assertEquals(2,pr.getGameAssists("test2"));
        pr.updateGameAssists("test1",4);
        assertEquals(7,pr.getGameAssists("test1"));
        assertEquals(9,pr.getTotalAssists());
        pr.updateGameAssists("test5",56);
        assertEquals(9,pr.getTotalAssists());
    }

    @org.junit.Test
    public void clearRecord(){
        Game g1 = new Game(2,3,5,"test1");
        pr.addNewGame(g1);
        assertEquals(2,pr.getTotalKills());
        assertEquals(3,pr.getTotalDeaths());
        assertEquals(5,pr.getTotalAssists());
        pr.clearRecord();
        assertEquals(0,pr.getTotalAssists());
        assertEquals(0,pr.getTotalDeaths());
        assertEquals(0,pr.getTotalKills());
    }
    @org.junit.Test
    public void removeGame(){
        Game g1 = new Game(2,3,5,"test1");
        Game g2 = new Game(5,6,7,"test2");
        pr.addNewGame(g1);
        pr.addNewGame(g2);
        assertEquals(7,pr.getTotalKills());
        assertEquals(9,pr.getTotalDeaths());
        assertEquals(12,pr.getTotalAssists());
        assertEquals(2,pr.getGameKills("test1"));
        assertEquals(7,pr.getGameAssists("test2"));
        pr.removeGame("test1");
        assertEquals(7,pr.getTotalKills());
        assertEquals(9,pr.getTotalDeaths());
        assertEquals(12,pr.getTotalAssists());
        assertEquals(0,pr.getGameKills("test1"));
        assertEquals(0,pr.getGameDeaths("test1"));
        pr.removeGame("test2");
        assertEquals(0,pr.getGameKills("test2"));
        assertEquals(0,pr.getGameDeaths("test2"));
    }
}