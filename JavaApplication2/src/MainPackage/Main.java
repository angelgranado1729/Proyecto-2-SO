/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MainPackage;

import GUIClasses.Home;
import MainClasses.Character;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
//
//        Home home = new Home();
//        home.setVisible(true);
         Character chapter = new Character(1, 120, 50, 50, "Parálisis", "/GUI/Assets/12-mitch-brown.png");
        chapter.start();
    }
    
}
