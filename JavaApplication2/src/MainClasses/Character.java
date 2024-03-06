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
public class Character extends Thread {
    private int chapterId;
    private int hitPoints; 
    private int speedVelocity;
    private int agility;
    private String hability;
    private int priorityLevel; 
    private String urlSource; 

    public Character(int chapterId, int hitPoints, int speedVelocity, int agility,String hability, String urlSource) {
        this.chapterId = chapterId;
        this.hitPoints = hitPoints;
        this.speedVelocity = speedVelocity;
        this.agility = agility;
        this.urlSource = urlSource;
        this.hability = hability;
        this.priorityLevel = this.checkPriority();
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

    
   private int calculatePoints(int value, int[] thresholds, int[] points) {
        for (int i = 0; i < thresholds.length; i++) {
            if (value < thresholds[i]) {
                return points[i];
            }
        }
        return points[points.length - 1];
    }

    private int checkPriority() {
        int[] hpThresholds = {30, 60, 90, Integer.MAX_VALUE};
        int[] speedAgilityThresholds = {25, 50, 75, Integer.MAX_VALUE};
        int[] points = {1, 2, 3, 4};

        int qualityPoints = 0;
        
        // Usando el método helper para calcular puntos para HP, PV (speedVelocity) y AG (agility)
        qualityPoints += calculatePoints(this.hitPoints, hpThresholds, points);
        qualityPoints += calculatePoints(this.speedVelocity, speedAgilityThresholds, points);
        qualityPoints += calculatePoints(this.agility, speedAgilityThresholds, points);
        
        switch (this.hability) {
            case "Parálisis":
            case "Congelamiento":
                qualityPoints += 2;
                break;
            case "Curación":
            case "Aumento de Agilidad":
                qualityPoints += 3;
                break;
            case "Ataque crítico":
            case "Aumento de Velocidad":
                qualityPoints += 4;
                break;
        }
        
        if (qualityPoints >= 5 && qualityPoints <= 8) {
            return 3;
        } else if (qualityPoints >= 9 && qualityPoints <= 12) {
            return 2;
        } else if (qualityPoints >= 13 && qualityPoints <= 16) {
            return 1;
        }
        
        return qualityPoints;
    }

}
