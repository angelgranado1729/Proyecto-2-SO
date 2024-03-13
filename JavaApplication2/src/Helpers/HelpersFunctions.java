/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import FileFunctions.FileFunctions;
import MainClasses.Administrator;
import MainClasses.IAArena;
import MainPackage.App;
import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class HelpersFunctions {

    public final static String[] priority = {"Yellow", "Green", "Red"};

    public static void loadParams() {
        App app = App.getInstance();
        FileFunctions fileFunctions = new FileFunctions();
        fileFunctions.read(App.getSelectedFile());

        Administrator admin = new Administrator(app.getMutex(),
                fileFunctions.getYellowRegularShow(), fileFunctions.getGreenRegularShow(), fileFunctions.getRedRegularShow(),
                fileFunctions.getYellowAvatar(), fileFunctions.getGreenAvatar(), fileFunctions.getRedAvatar());

        app.setAdmin(admin);
        app.getAdmin().startSimulation();

    }
}
