package my.footbalManager.service;

import my.footbalManager.model.Player;

import java.util.List;

public interface PlayerService {

    void save(Player player);

    Player findById(Long id);

    List<Player> findAll();

    Player getCaptain(Long teamId);
}
