package my.footbalManager.service;

import my.footbalManager.model.Player;
import my.footbalManager.model.Team;

import java.util.List;

public interface TeamService {

    void save(Team team);

    Team findById(Long id);

    List<Team> findAllTeams();

    List<Player> getListPlayersByTeam(Long teamId);

    Player getCaptain(Long teamId);

    void addExistingPlayer(Long teamId, Long playerId);

    void addNewPlayer(Long teamId, Player player);

    void assignCaptain(Long teamId, Long playerId);

}
