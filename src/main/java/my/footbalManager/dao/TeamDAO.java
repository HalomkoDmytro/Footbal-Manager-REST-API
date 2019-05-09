package my.footbalManager.dao;


import my.footbalManager.model.Player;
import my.footbalManager.model.Team;

import java.util.List;

/**
 * {@link TeamDAO} provides an API to access {@link Team} data.
 */
public interface TeamDAO {

    /**
     * Store instance of {@link Team} into DB.
     * Set a generated id to team.
     * @param team new instance of team
     */
    void save(Team team);

    /**
     * Return an {@link Team} instance by id from DB.
     * @param id team id in DB
     * @return team instance
     */
    Team findById(Long id);

    /**
     * Returns all teams stored in DB.
     * @return teams list
     */
    List<Team> findAllTeams();

    /**
     * Returns all {@link Player} assigned to the {@link Team} stored in DB.
     * @param teamId team id in DB
     * @return player List
     */
    List<Player> getListPlayersByTeam(Long teamId);

    /**
     * Return {@link Player} who is appointed captain at {@link Team}
     * @param teamId id team
     * @return captain of this team
     */
    Player getCaptain(Long teamId);

    /**
     * Change for existing {@link Player} playing {@link Team}
     * @param teamId
     * @param playerId
     */
    void addExistingPlayer(Long teamId, Long playerId);

    /**
     * Create new {@link Player} and assigned to the {@link Team}
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
