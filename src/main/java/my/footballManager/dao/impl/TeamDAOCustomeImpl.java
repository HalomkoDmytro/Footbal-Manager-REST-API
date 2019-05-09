package my.footballManager.dao.impl;

import my.footballManager.dao.TeamDAOCustome;
import my.footballManager.model.Player;
import my.footballManager.model.Team;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDAOCustomeImpl implements TeamDAOCustome {

    @Autowired
    private SessionFactory sessionFactory;

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
            throw new IllegalArgumentException(String.format("Captain should be a member of the team. Player id=%d not member of the team", playerId));
        }
    }
}
