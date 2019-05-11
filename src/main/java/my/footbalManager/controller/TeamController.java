package my.footbalManager.controller;

import my.footbalManager.model.Player;
import my.footbalManager.model.Team;
import my.footbalManager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<?> save(@RequestBody Team team) {
        teamService.save(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> get(@PathVariable("id") long id) {
        Team team = teamService.findById(id);
        return ResponseEntity.ok().body(team);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAll() {
        List<Team> teams = teamService.findAll();
        return ResponseEntity.ok().body(teams);
    }

    @PutMapping("/teams/{teamId}/{playerId}")
    public ResponseEntity<?> addExcistingPlayerToTheTeam(@PathVariable("teamId") long teamId,
                                                         @PathVariable("playerId") long playerId) {
        teamService.addExistingPlayer(teamId, playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/teams/captain/{teamId}/{playerId}")
    public ResponseEntity<?> assignCaptainToTheTeam(@PathVariable("teamId") long teamId,
                                                         @PathVariable("playerId") long playerId) {
        teamService.assignCaptain(teamId, playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("teams/{id}")
    public ResponseEntity<?> addNewUserToTheTeam(@PathVariable("id") long teamId,
                                                 @RequestBody Player player) {
        teamService.addNewPlayer(teamId, player);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/teams/{teamId}/players")
    public ResponseEntity<List<Player>> getPlayersFromTeam(@PathVariable("teamId") long teamId) {
        List<Player> listPlayersByTeam = teamService.getListPlayersByTeam(teamId);
        return ResponseEntity.ok().body(listPlayersByTeam);
    }
}
