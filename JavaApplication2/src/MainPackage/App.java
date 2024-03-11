/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPackage;

import FileFunctions.FileFunctions;
import GUIClasses.ControlMainUI;
import GUIClasses.Home;
import Helpers.HelpersFunctions;
import MainClasses.IAArena;
import MainClasses.TelevisionShow;
import java.io.File;

/**
 *
 * @author user
 */
public class App {
     // FIle params
    private static String selectedPath = "test//params.txt";
    private static File selectedFile = new File(selectedPath);
    private static FileFunctions fileFunctions = new FileFunctions();

    // General params
    private static int battleDuration;

    // General variables
    private TelevisionShow regularShow; 
    private TelevisionShow avatarShow; 
    private IAArena iaArena; 


    private static App app;

    /**
     * Devuelve una instancia única de la aplicación.
     *
     * @return La instancia única de la aplicación.
     */
    public static synchronized App getInstance() {
        if (getApp() == null) {
            setApp(new App());
        }
        return getApp();
    }

    public void start() {
        
        HelpersFunctions.loadParams();
        // Inicia la simulacion
        ControlMainUI.getHome().setVisible(true);
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/rigby-yellow.png");
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/archie-red.png");
//        
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/rigby-green.png");
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/archie-red.png");
//        
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/archie-red.png");
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/rigby-yellow.png");
//        
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/ang-green.png");
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/ang-green.png");
//        
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/ang-green.png");
//        ControlMainUI.getHome().getQueueUICN1().addCard("/GUI/Assets/ang-green.png");
        
//        app.getIaArena().prepareFight();
    }

    /**
     * @return the selectedPath
     */
    public static String getSelectedPath() {
        return selectedPath;
    }

    /**
     * @param aSelectedPath the selectedPath to set
     */
    public static void setSelectedPath(String aSelectedPath) {
        selectedPath = aSelectedPath;
    }

    /**
     * @return the selectedFile
     */
    public static File getSelectedFile() {
        return selectedFile;
    }

    /**
     * @param aSelectedFile the selectedFile to set
     */
    public static void setSelectedFile(File aSelectedFile) {
        selectedFile = aSelectedFile;
    }

    /**
     * @return the fileFunctions
     */
    public static FileFunctions getFileFunctions() {
        return fileFunctions;
    }

    /**
     * @param aFileFunctions the fileFunctions to set
     */
    public static void setFileFunctions(FileFunctions aFileFunctions) {
        fileFunctions = aFileFunctions;
    }

    /**
     * @return the battleDuration
     */
    public static int getBattleDuration() {
        return battleDuration;
    }

    /**
     * @param aBattleDuration the battleDuration to set
     */
    public static void setBattleDuration(int aBattleDuration) {
        battleDuration = aBattleDuration;
    }

    /**
     * @return the app
     */
    public static App getApp() {
        return app;
    }

    /**
     * @param aApp the app to set
     */
    public static void setApp(App aApp) {
        app = aApp;
    }

    /**
     * @return the regularShow
     */
    public TelevisionShow getRegularShow() {
        return regularShow;
    }

    /**
     * @param regularShow the regularShow to set
     */
    public void setRegularShow(TelevisionShow regularShow) {
        this.regularShow = regularShow;
    }

    /**
     * @return the avatarShow
     */
    public TelevisionShow getAvatarShow() {
        return avatarShow;
    }

    /**
     * @param avatarShow the avatarShow to set
     */
    public void setAvatarShow(TelevisionShow avatarShow) {
        this.avatarShow = avatarShow;
    }

    /**
     * @return the iaArena
     */
    public IAArena getIaArena() {
        return iaArena;
    }

    /**
     * @param iaArena the iaArena to set
     */
    public void setIaArena(IAArena iaArena) {
        this.iaArena = iaArena;
    }

    
    

}
