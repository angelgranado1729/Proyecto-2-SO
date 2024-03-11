/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CharacterTv extends Thread {

    private int chapterId;
    private String nameCharacter;
    private int hitPoints;
    private int speedVelocity;
    private int agility;
    private String hability;
    private int priorityLevel;
    private String urlSource;

    public CharacterTv(int chapterId, String nameCharacter, int hitPoints,
            int speedVelocity, int agility, String hability, String urlSource) {
        this.chapterId = chapterId;
        this.nameCharacter = nameCharacter;
        this.hitPoints = hitPoints;
        this.speedVelocity = speedVelocity;
        this.agility = agility;
        this.urlSource = urlSource;
        this.hability = hability;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(35);
            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido: " + ex.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception ex) {
            System.out.println("Excepción en el hilo: " + ex.getMessage());
        }
    }

    public String toString() {
        return "Character{"
                + "chapterId=" + getChapterId()
                + ", hitPoints=" + getHitPoints()
                + ", speedVelocity=" + getSpeedVelocity()
                + ", agility=" + getAgility()
                + ", hability='" + getHability() + '\''
                + ", priorityLevel=" + getPriorityLevel()
                + ", urlSource='" + getUrlSource() + '\''
                + '}';
    }

    public void takeDamage(int damage) {
        // Reducir los hitPoints en la mitad del daño recibido
        this.hitPoints -= (damage / 2);

        // Asegurarse de que los hitPoints no caigan bajo cero
        if (this.hitPoints < 0) {
            this.hitPoints = 0;
        }
    }

    public void heal(int healthPoints) {
        // Incrementar los hitPoints en la cantidad especificada
        this.hitPoints += healthPoints;

        int maxHP = 160;
        if (this.hitPoints > maxHP) {
            this.hitPoints = maxHP;
        }
    }

    /**
     * @return the chapterId
     */
    public int getChapterId() {
        return chapterId;
    }

    /**
     * @param chapterId the chapterId to set
     */
    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * @return the speedVelocity
     */
    public int getSpeedVelocity() {
        return speedVelocity;
    }

    /**
     * @param speedVelocity the speedVelocity to set
     */
    public void setSpeedVelocity(int speedVelocity) {
        this.speedVelocity = speedVelocity;
    }

    /**
     * @return the agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * @param agility the agility to set
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * @return the hability
     */
    public String getHability() {
        return hability;
    }

    /**
     * @param hability the hability to set
     */
    public void setHability(String hability) {
        this.hability = hability;
    }

    /**
     * @return the priorityLevel
     */
    public int getPriorityLevel() {
        return priorityLevel;
    }

    /**
     * @param priorityLevel the priorityLevel to set
     */
    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    /**
     * @return the urlSource
     */
    public String getUrlSource() {
        return urlSource;
    }

    /**
     * @param urlSource the urlSource to set
     */
    public void setUrlSource(String urlSource) {
        this.urlSource = urlSource;
    }

    /**
     * @return the nameCharacter
     */
    public String getNameCharacter() {
        return nameCharacter;
    }

    /**
     * @param nameCharacter the nameCharacter to set
     */
    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }
    
    

}
