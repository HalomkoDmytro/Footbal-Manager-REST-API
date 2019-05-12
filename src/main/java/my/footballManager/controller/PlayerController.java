package my.footballManager.controller;

import my.footballManager.model.Player;
import my.footballManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    public ResponseEntity<?> save(@RequestBody Player player) {
        playerService.save(player);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> get(@PathVariable("id") long id) {
        Player player = playerService.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> listPlayers() {
        List<Player> players = playerService.findAll();
        return ResponseEntity.ok().body(players);
    }

    @GetMapping("/players/captain/{teamId}")
    public ResponseEntity<Player> getCaptain(@PathVariable("teamId") long teamId) {
        Player player = playerService.getCaptain(teamId);
        return ResponseEntity.ok().body(player);
    }
}
