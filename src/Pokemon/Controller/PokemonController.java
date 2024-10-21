
package Pokemon.Controller;

import Pókemon.Model.Repository.JDBC.PokemonDAOJDBC;
import Pókemon.View.PokemonView;


public class PokemonController {
    
    public PokemonView pokemonView;
    public PokemonDAOJDBC pokemonDAO;

    public PokemonController() {
        this.pokemonView = new PokemonView();
        this.pokemonDAO = new PokemonDAOJDBC();
        
    }
    
    //metodo para crear el pokemon
    
 //   for (int i = 0; i < 20; i++) {
//                // Generar valores aleatorios para los campos
//                int pokemonId = random.nextInt(151) + 1; // Pokémon id (de 1 a 151)
//                int rareza = random.nextInt(5) + 1; // Rareza (de 1 a 5)
//                int nivel = random.nextInt(100) + 1; // Nivel (de 1 a 100)
//                int entrenadorId = random.nextInt(19) + 1; // Entrenador id (de 1 a 19)
//
//                // Calcular el precio en base a la rareza y el nivel
//                double multiplicador = 1.0 + (rareza - 1) * 0.50;
//                double precio = nivel * multiplicador;
//   System.out.println("Registro " + (i + 1) + " insertado: Pokémon ID " + pokemonId + ", Entrenador ID " + entrenadorId);
    //}
}
