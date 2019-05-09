package my.footbalManager.service.impl;

import my.footbalManager.dao.TeamDAO;
import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import my.footbalManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
//@Transactional
public class TeamServiceImpl implements TeamService {

//    @Autowired
    private TeamDAO teamDAO;

    @Override
    public void save(Team team) {
        teamDAO.save(team);
    }

    @Override
    public Team findById(Long id) {
        return teamDAO.findById(id);
    }

    @Override
    public List<Team> findAllTeams() {
        return null;
    }

    @Override
    public List<Player> getListPlayersByTeam(Long teamId) {
        return null;
    }

    @Override
    public Player getCaptain(Long teamId) {
        return null;
    }

    @Override
    public void addExistingPlayer(Long teamId, Long playerId) {

    }

    @Override
    public void addNewPlayer(Long teamId, Player player) {

    }

    @Override
    public void assignCaptain(Long teamId, Long playerId) {

    }
}
