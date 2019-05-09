package my.footbalManager.service;

import my.footbalManager.model.Player;

import java.util.List;

public interface PlayerService {

    void testSave();

    void save(Player player);

    Player findById(Long id);

    List<Player> findAll();

    void update(Player player);

    void remove(Player player);
}
