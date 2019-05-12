package my.footbalManager.dao;

import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * {@link PlayerDAO} provides an API to access {@link Player} data.
 */
public interface PlayerDAO extends JpaRepository<Player, Long> {

    /**
     * Return {@link Player} who is appointed captain at {@link Team}
     *
     * @param teamId id team
     * @return captain of this team
     */
    @Query("select t.captain from Team t where t.id = :teamId")
    Player getCaptain(Long teamId);
}
