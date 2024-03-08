/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import FileFunctions.FileFunctions;
import MainClasses.IAArena;
import MainClasses.TelevisionShow;
import MainPackage.App;
import java.util.concurrent.Semaphore;

/**
 *
 * @author user
 */
public class HelpersFunctions {

    public static void loadParams() {
        App app = App.getInstance();
        FileFunctions fileFunctions = new FileFunctions();
        fileFunctions.read(App.getSelectedFile());
        
        TelevisionShow regularShow = new TelevisionShow(
                fileFunctions.getYellowRegularShow(), 
                fileFunctions.getGreenRegularShow(), 
                fileFunctions.getRedRegularShow());
        
    
        TelevisionShow avatarShow = new TelevisionShow(
                fileFunctions.getYellowAvatar(), 
                fileFunctions.getGreenAvatar(), 
                fileFunctions.getRedAvatar());
        
        app.setRegularShow(regularShow);
        app.setAvatarShow(avatarShow);
        
        IAArena iaArena = new IAArena();
        iaArena.setAvatarFighter(app.getAvatarShow().getGreenAvailable()[22]);
        iaArena.setRegularShowFighter(app.getRegularShow().getGreenAvailable()[24]);
        app.setIaArena(iaArena);
    }
}
