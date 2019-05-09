package my.footbalManager.dao;

import my.footbalManager.model.Player;

import java.util.List;

/**
 * {@link PlayerDAO} provides an API to access {@link Player} data.
 */
public interface PlayerDAO {

    void testSave();

    /**
     * Store instance of {@link Player} into DB.
     * Set a generated id to player.
     * @param player
     */
    void save(Player player);

    /**
     * Return an {@link Player} instance by id from DB.
     * @param id player id in DB
     * @return player instance
     */
    Player findById(Long id);

    /**
     * Returns all players stored in DB.
     * @return players list
     */
    List<Player> findAll();

    /**
     * Receives stored {@link Player} instance and update in DB.
     * @param player stored player with updated fields
     */
    void update(Player player);

    /**
     * Removes stored player from DB.
     * @param player stored player instance
     */
    void remove(Player player);
}
