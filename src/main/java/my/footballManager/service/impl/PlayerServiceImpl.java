package my.footballManager.service.impl;

import my.footballManager.dao.PlayerDAO;
import my.footballManager.model.Player;
import my.footballManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public void save(Player player) {
        playerDAO.save(player);
    }

    @Override
    public Player findById(Long id) {
        return playerDAO.findById(id).get();
    }

    @Override
    public List<Player> findAll() {
        return playerDAO.findAll();
    }

    @Override
    public Player getCaptain(Long teamId) {
        return playerDAO.getCaptain(teamId);
    }
}
