package my.footballManager.dao;


import my.footballManager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link TeamDAO} provides an API to access {@link Team} data.
 */
public interface TeamDAO extends JpaRepository<Team, Long>, TeamDAOCustome {
}
