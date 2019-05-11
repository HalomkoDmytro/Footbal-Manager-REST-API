package my.footbalManager.dao.impl;

import my.footbalManager.dao.TeamDAO;
import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Team team) {
        sessionFactory.getCurrentSession().save(team);
    }

    public Team findById(Long id) {
        return sessionFactory.getCurrentSession().find(Team.class, id);
    }

    @Transactional(readOnly = true)
    public List<Team> findAll() {
        List<Team> teams = sessionFactory.getCurrentSession()
                .createQuery("select t from Team t", Team.class)
                .getResultList();
        sessionFactory.getCurrentSession().flush();
        return teams;
    }

    public List<Player> getListPlayersByTeam(Long teamId) {
        Team team = sessionFactory.getCurrentSession().find(Team.class, teamId);
        return team.getPlayers();

    }

    public void addExistingPlayer(Long teamId, Long playerId) {
        Team team = sessionFactory.getCurrentSession().get(Team.class, teamId);
        Player player = sessionFactory.getCurrentSession().get(Player.class, playerId);
        team.addPlayerToTeam(player);
        sessionFactory.getCurrentSession().merge(player);
    }

    public void addNewPlayer(Long teamId, Player player) {
        Team team = sessionFactory.getCurrentSession().get(Team.class, teamId);
        team.addPlayerToTeam(player);
        team.addPlayerToTeam(player);
        sessionFactory.getCurrentSession().merge(team);
    }

    public void assignCaptain(Long teamId, Long playerId) {
        Team team = sessionFactory.getCurrentSession().get(Team.class, teamId);
        Player player = sessionFactory.getCurrentSession().get(Player.class, playerId);
        if (team.getPlayers().contains(player)) {
            team.assignCaptain(player);
            sessionFactory.getCurrentSession().merge(player);
        } else {
            throw new IllegalArgumentException(String.format("Captain should be a member of the team. Player with id=%d not member of the team", playerId));
        }
    }
}
