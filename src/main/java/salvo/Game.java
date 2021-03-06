package salvo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private Date date;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<GamePlayer> gamePlayers = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    Set<Score> scores = new HashSet<>();

    public Game() {
        this.date = new Date();
    }

    //getters
    public long getId() { return id; }

    public Date getDate() {
        return date;
    }

    @JsonIgnore
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    @JsonIgnore
    public Set<Score> getScores() {
        return scores;
    }

    public void setDate(int num_seconds) {

        Date newDate = Date.from(date.toInstant().plusSeconds(num_seconds));
        this.date = newDate;
    }

    public void showGamePlayers() {
        System.out.println(gamePlayers);
    }

    public void addGamePlayer(GamePlayer gamePlayer) {
        gamePlayers.add(gamePlayer);
    }
}