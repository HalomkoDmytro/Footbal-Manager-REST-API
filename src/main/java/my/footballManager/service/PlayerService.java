package my.footballManager.service;

import my.footballManager.model.Player;
import my.footballManager.model.Team;

import java.util.List;

/**
 * This class provides service logic for {@link Player}.
 */
public interface PlayerService {

    /**
     * Store instance of {@link Player}.
     * @param player
     */
    void save(Player player);

    /**
     * Return an {@link Player} instance by id.
     * @param id player id
     * @return player instance
     */
    Player findById(Long id);

    /**
     * Return list {@link Player}players.
     * @return players list
     */
    List<Player> findAll();

    /**
     * Get {@link Player}captain from the {@link Team}
     * @param teamId
     * @return
     */
    Player getCaptain(Long teamId);
}
