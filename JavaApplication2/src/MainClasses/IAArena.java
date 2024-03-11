/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;
import java.util.Random;


/**
 *
 * @author user
 */
public class IAArena {
    
    private CharacterTv regularShowFighter; 
    private CharacterTv avatarFighter; 
    private String winner; 
    private int combatSpeed = 3333; // ESTE ES EL TIEMPO POR TURNO
    // El enunciado del proyecto dice que toma en 10 segundos en procesar si hay o no ganador 
    // Es por ello combat speed lo setee 3333 porque suelen haber 3 turnos. 

    public IAArena() {
    }
    
    // LÓGICA de selección previa al combate
    public void prepareFight() {
        double randomValue = Math.random(); 
        System.out.println("Determinando el resultado del combate...");

        if (randomValue < 0.4) { // 40% de probabilidad de que exista un ganador
            System.out.println("¡Se llevará a cabo el combate!");
            fight();
        } else {
             try {
                if (randomValue < 0.67) { // 27% de probabilidad de empate (40% + 27% = 67%)
                    System.out.println("¡El combate termina en empate sin luchar!");
                    setWinner("Empate");
                } else { // 33% restante de probabilidad de que no se lleve a cabo el combate
                    System.out.println("El combate no se llevará a cabo.");
                }
                Thread.sleep(10000); // Esperamos 10 segundos de manipulación que mencionan en el enunciado.
            } catch (InterruptedException e) {
                System.out.println("Interrumpido mientras esperaba.");
                Thread.currentThread().interrupt();
            }
        }
        releaseFighters();
    }
    
     private void releaseFighters() {
        setRegularShowFighter(null);
        setAvatarFighter(null);
        System.out.println("Los luchadores han sido liberados de la IA Arena.");
    }
     
     public void fight() {
        this.setWinner("LUCHANDO");
        System.out.println("La pelea ha comenzado.");

        int round = 0;
        while (getRegularShowFighter().getHitPoints() > 0 && getAvatarFighter().getHitPoints() > 0) {
            System.out.println("\nRound " + ++round);

            if (getRegularShowFighter().getSpeedVelocity() >= getAvatarFighter().getSpeedVelocity()) {
                System.out.println("Regular Show Fighter ataca primero.");
                int damage = calculateDamage(getRegularShowFighter(), getAvatarFighter());
                System.out.println("Regular Show Fighter hace " + damage + " de daño a Avatar Fighter.");
                getAvatarFighter().takeDamage(damage);
                if (getAvatarFighter().getHitPoints() <= 0) break;

                System.out.println("Avatar Fighter contraataca.");
                damage = calculateDamage(getAvatarFighter(), getRegularShowFighter());
                System.out.println("Avatar Fighter hace " + damage + " de daño a Regular Show Fighter.");
                getRegularShowFighter().takeDamage(damage);
                if (getRegularShowFighter().getHitPoints() <= 0) break;
            } else {
                System.out.println("Avatar Fighter ataca primero.");
                int damage = calculateDamage(getAvatarFighter(), getRegularShowFighter());
                System.out.println("Avatar Fighter hace " + damage + " de daño a Regular Show Fighter.");
                getRegularShowFighter().takeDamage(damage);
                if (getRegularShowFighter().getHitPoints() <= 0) break;

                System.out.println("Regular Show Fighter contraataca.");
                damage = calculateDamage(getRegularShowFighter(), getAvatarFighter());
                System.out.println("Regular Show Fighter hace " + damage + " de daño a Avatar Fighter.");
                getAvatarFighter().takeDamage(damage);
                if (getAvatarFighter().getHitPoints() <= 0) break;
            }

            // Espera entre rondas basada en combatSpeed
            try {
                Thread.sleep(getCombatSpeed());
            } catch (InterruptedException e) {
                System.out.println("La pelea fue interrumpida.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        // Decidir el ganador
        determineWinner();
    }

    private void determineWinner() {
        if (getRegularShowFighter().getHitPoints() > 0) {
            this.setWinner("Regular Show Fighter Wins!");
        } else if (getAvatarFighter().getHitPoints() > 0) {
            this.setWinner("Avatar Fighter Wins!");
        } else {
            this.setWinner("Empate");
        }

        System.out.println("\nResultado final: " + getWinner());
    }
    
    private int calculateDamage(CharacterTv attacker, CharacterTv defender) {
        // Daño base con la lógica que el ataque no puede ser completo porque sino lo matariamos de one. 
        int baseDamage = (attacker.getSpeedVelocity() + (attacker.getAgility() / 2)) / 2;

        // Inicializamos el daño
        int damage = baseDamage;

        switch (attacker.getHability()) {
            case "Ataque Crítico":
                //INCREMENTE EL DAÑO BASE DE X1.5
                System.out.println(attacker.getHability() + " activada. Daño aumentado.");
                damage = (int) (baseDamage * 1.5);
                break;
            case "Curación":
                // RECUPERA EN VIDA LA MITAD DE LO QUE LO ATACARÍA 
                int healAmount = (int) (baseDamage * 0.5); 
                System.out.println(attacker.getHability() + " activada. " + attacker.getName() + " se cura " + healAmount + " HP.");
                attacker.heal(healAmount);
                damage = 0; // NO ENVIARÍA DAÑO EN ESE CASO!!
                break;
            case "Parálisis":
                // Se le disminuye la agilidad al enemigo en un 50%
                System.out.println(attacker.getHability() + " activada. " + defender.getName() + " paralizado, perdió 50% de la agilidad.");
                defender.setAgility(defender.getAgility() / 2);
                break;
            case "Congelamiento":
                // Se le disminuye la velocidad al enemigo en un 50%
                System.out.println(attacker.getHability() + " activada. " + defender.getName() + " congelado y su velocidad se reduce.");
                defender.setSpeedVelocity(defender.getSpeedVelocity() / 2); // Example effect: Reduce defender's speed.
                break;
            default:
                System.out.println("Sin habilidad especial activada.");
                break;
        }

        // Devolvemos el daño despues de procesado las habilidades extras
        return damage;
    }
    
    /**
     * @return the regularShowFighter
     */
    public CharacterTv getRegularShowFighter() {
        return regularShowFighter;
    }

    /**
     * @param regularShowFighter the regularShowFighter to set
     */
    public void setRegularShowFighter(CharacterTv regularShowFighter) {
        this.regularShowFighter = regularShowFighter;
    }

    /**
     * @return the avatarFighter
     */
    public CharacterTv getAvatarFighter() {
        return avatarFighter;
    }

    /**
     * @param avatarFighter the avatarFighter to set
     */
    public void setAvatarFighter(CharacterTv avatarFighter) {
        this.avatarFighter = avatarFighter;
    }

    /**
     * @return the winner
     */
    public String getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(String winner) {
        this.winner = winner;
    }

    /**
     * @return the combatSpeed
     */
    public int getCombatSpeed() {
        return combatSpeed;
    }
    
      public void setCombatSpeed(int combatSpeed) {
        this.combatSpeed = combatSpeed;
    }
}
