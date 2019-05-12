package my.footballManager.service;

import my.footballManager.model.Player;
import my.footballManager.model.Team;

import java.util.List;

/**
 * This class provides service logic for {@link Team}.
 */
public interface TeamService {

    /**
     * Store instance of {@link Team}.
     * @param team new instance of team
     */
    void save(Team team);

    /**
     * Return an {@link Team} instance by id.
     * @param id team id
     * @return team instance
     */
    Team findById(Long id);

    /**
     * Returns all teams.
     * @return teams list
     */
    List<Team> findAll();

    /**
     * Returns all {@link Player} assigned to the {@link Team}.
     * @param teamId team id
     * @return player List
     */
    List<Player> getListPlayersByTeam(Long teamId);

    /**
     * Change for existing {@link Player} playing {@link Team}
     * @param teamId
     * @param playerId
     */
    void addExistingPlayer(Long teamId, Long playerId);

    /**
     * Create new {@link Player} and assigned to the {@link Team}.
     * @param teamId
     * @param player
     */
    void addNewPlayer(Long teamId, Player player);

    /**
     * Assigned {@link Player} as captain for {@link Team}
     * @param teamId
     * @param playerId
     */
    void assignCaptain(Long teamId, Long playerId);

}
