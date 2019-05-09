package my.footbalManager.dao.impl;

import my.footbalManager.dao.TeamDAO;
import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Team team) {

    }

    public Team findById(Long id) {
        return null;
    }

    public List<Team> findAllTeams() {
        return null;
    }

    public List<Player> getListPlayersByTeam(Long teamId) {
        return null;
    }

    public Player getCaptain(Long teamId) {
        return null;
    }

    public void addExistingPlayer(Long teamId, Long playerId) {

    }

    public void addNewPlayer(Long teamId, Player player) {

    }

    public void assignCaptain(Long teamId, Long playerId) {

    }
}
