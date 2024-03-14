/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import FileFunctions.FileFunctions;
import MainClasses.Administrator;
import MainClasses.IA;
import MainPackage.App;

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

        app.setIa(new IA());

        Administrator admin = new Administrator(
                app.getIa(),
                app.getMutex(),
                fileFunctions.getYellowRegularShow(), fileFunctions.getGreenRegularShow(), fileFunctions.getRedRegularShow(),
                fileFunctions.getYellowAvatar(), fileFunctions.getGreenAvatar(), fileFunctions.getRedAvatar());

        app.setAdmin(admin);
        app.getAdmin().getIa().setAdministrator(admin);
        app.getAdmin().startSimulation();

    }
}
