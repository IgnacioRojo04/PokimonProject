/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package League.Controller;

import Player.Model.Entity.Leader;
import Player.Model.Repository.JDBC.LeaderDAOJDBC;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juanm
 */
public class LeagueController {
    
    private List<Leader> leadersList;
    
    
      public LeagueController(LeaderDAOJDBC leaderDAO) {
        // Inicializa la lista de líderes llamando al método listar
        this.leadersList = leaderDAO.listarNombreLideres();
    }
        
    public void markLeaderAsDefeated(int leaderId) {
        for (Leader leader : leadersList) {
            if (leader.getId() == leaderId) {
                leader.setDefeated(true);
                System.out.println("Felicidades haz derrotado al Líder " + leader.getName() + " , ya fue marcado como derrotado, sigue con los demás lideres antes de que se recuperen.");
                break;
            }
        }
    }
    
    public List<Leader> getNonDefeatedLeaders() {
    List<Leader> nonDefeatedLeaders = new ArrayList<>(); // Lista para almacenar los líderes no derrotados

    // Recorrer cada líder en la lista de líderes
    for (Leader leader : leadersList) {
        // Si el líder no está derrotado, lo añadimos a la lista de no derrotados
        if (!leader.isDefeated()) {
            nonDefeatedLeaders.add(leader);
        }
    }

    return nonDefeatedLeaders; // Retornamos la lista de líderes no derrotados
}
     
    public List<Leader> getDefeatedLeaders() {
        List<Leader> DefeatedLeaders = new ArrayList<>(); // Lista para almacenar los líderes no derrotados

    // Recorrer cada líder en la lista de líderes
    for (Leader leader : leadersList) {
        // Si el líder no está derrotado, lo añadimos a la lista de no derrotados
        if (leader.isDefeated() == true) {
            DefeatedLeaders.add(leader);
        }
    }

    return DefeatedLeaders; // Retornamos la lista de líderes no derrotados
    }
    
    
    
}
