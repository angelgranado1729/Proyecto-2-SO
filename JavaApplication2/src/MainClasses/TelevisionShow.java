/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

/**
 *
 * @author user
 */
public class TelevisionShow {
     // Meter aqui las colas en vez de array para colas de prioridades
//    private Character[] highPriorityQueue;
//    private Character[] mediumPriorityQueue;
//    private Character[] lowPriorityQueue;
//    private Character[] strengtheningQueue;
   
    // AQUI - estan los personajes NO utilizados listos para ser escojidos, separados por color de tajeta.
    // Cuando se escojan se le debe MODIFICAR el ID porque por default es 0
      private Character[] yellowAvailable;
      private Character[] greenAvailable;
      private Character[] redAvailable;

    public TelevisionShow() {
    }

    public TelevisionShow(Character[] yellowAvailable, Character[] greenAvailable, Character[] redAvailable) {
        this.yellowAvailable = yellowAvailable;
        this.greenAvailable = greenAvailable;
        this.redAvailable = redAvailable;
    }

    /**
     * @return the yellowAvailable
     */
    public Character[] getYellowAvailable() {
        return yellowAvailable;
    }

    /**
     * @param yellowAvailable the yellowAvailable to set
     */
    public void setYellowAvailable(Character[] yellowAvailable) {
        this.yellowAvailable = yellowAvailable;
    }

    /**
     * @return the GreenAvailable
     */
    public Character[] getGreenAvailable() {
        return greenAvailable;
    }

    /**
     * @param greenAvailable the greenAvailable to set
     */
    public void setGreenAvailable(Character[] greenAvailable) {
        this.greenAvailable = greenAvailable;
    }

    /**
     * @return the redAvailable
     */
    public Character[] getRedAvailable() {
        return redAvailable;
    }

    /**
     * @param redAvailable the redAvailable to set
     */
    public void setRedAvailable(Character[] redAvailable) {
        this.redAvailable = redAvailable;
    }
    
    public void printAvailableCharacters() {
        System.out.println("Yellow Available Characters:");
        for (Character character : yellowAvailable) {
            if (character != null) { 
                System.out.println(character);
            }
        }
        
        System.out.println("\nGreen Available Characters:");
        for (Character character : greenAvailable) {
            if (character != null) { 
                System.out.println(character);
            }
        }
        
        System.out.println("\nRed Available Characters:");
        for (Character character : redAvailable) {
            if (character != null) { 
                System.out.println(character);
            }
        }
    }
       
}
