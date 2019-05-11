package my.footbalManager.service.impl;

import my.footbalManager.dao.PlayerDAO;
import my.footbalManager.dao.TeamDAO;
import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import my.footbalManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public void save(Team team) {
        teamDAO.save(team);
    }

    @Override
    public Team findById(Long id) {
        return teamDAO.findById(id);
    }

    @Override
    public List<Team> findAll() {
        return teamDAO.findAll();
    }

    @Override
    public List<Player> getListPlayersByTeam(Long teamId) {
        return teamDAO.getListPlayersByTeam(teamId);
    }

    @Override
    public void addExistingPlayer(Long teamId, Long playerId) {
        teamDAO.addExistingPlayer(teamId, playerId);
    }

    @Override
    public void addNewPlayer(Long teamId, Player player) {
        teamDAO.addNewPlayer(teamId, player);
    }

    @Override
    public void assignCaptain(Long teamId, Long playerId) {
        teamDAO.assignCaptain(teamId, playerId);
    }


}
