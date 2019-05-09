package my.footbalManager.dao.impl;

import my.footbalManager.dao.PlayerDAO;
import my.footbalManager.model.Player;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository("playerDAO")
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void testSave(){
        System.out.println("test save");
        Player player = new Player();
        player.setBirthday(new Date());
        player.setFirstName("Peter");
        player.setLastName("parcker");
        player.setPosition("pos");
        sessionFactory.getCurrentSession().save(player);
    }

    public void save(Player player) {
        Objects.requireNonNull(player);
        sessionFactory.getCurrentSession().save(player);
    }

    public Player findById(Long id) {
        Objects.requireNonNull(id);
        return sessionFactory.getCurrentSession()
                .find(Player.class, id);
    }

    public List<Player> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("select p from Player p", Player.class)
                .getResultList();
    }

    public void update(Player player) {
        Objects.requireNonNull(player);
        sessionFactory.getCurrentSession().merge(player);
    }

    public void remove(Player player) {
        Objects.requireNonNull(player);
        Player removingPlayer = (Player) sessionFactory.getCurrentSession().merge(player);
        sessionFactory.getCurrentSession().delete(removingPlayer);
    }
}
