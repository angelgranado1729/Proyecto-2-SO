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
      private Character[] blueAvailable;
      private Character[] redAvailable;

    public TelevisionShow() {
    }

    public TelevisionShow(Character[] yellowAvailable, Character[] blueAvailable, Character[] redAvailable) {
        this.yellowAvailable = yellowAvailable;
        this.blueAvailable = blueAvailable;
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
     * @return the blueAvailable
     */
    public Character[] getBlueAvailable() {
        return blueAvailable;
    }

    /**
     * @param blueAvailable the blueAvailable to set
     */
    public void setBlueAvailable(Character[] blueAvailable) {
        this.blueAvailable = blueAvailable;
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
        
        System.out.println("\nBlue Available Characters:");
        for (Character character : blueAvailable) {
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
