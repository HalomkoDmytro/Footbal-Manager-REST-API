package my.footballManager.dao;

import my.footballManager.model.Player;
import my.footballManager.model.Team;

import java.util.List;

public interface TeamDAOCustome {
    /**
     * Returns all {@link Player} assigned to the {@link Team} stored in DB.
     *
     * @param teamId team id in DB
     * @return player List
     */
    List<Player> getListPlayersByTeam(Long teamId);

    /**
     * Change for existing {@link Player} playing {@link Team}
     *
     * @param teamId
     * @param playerId
     */
    void addExistingPlayer(Long teamId, Long playerId);

    /**
     * Create new {@link Player} and assigned to the {@link Team}
     *
     * @param teamId
     * @param player
     */
    void addNewPlayer(Long teamId, Player player);

    /**
     * Assigned {@link Player} as captain for {@link Team}
     *
     * @param teamId
     * @param playerId
     */
    void assignCaptain(Long teamId, Long playerId);
}
