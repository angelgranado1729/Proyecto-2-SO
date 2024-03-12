/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import EDD.LinkedList;
import GUIClasses.ControlMainUI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author angel
 */
public class Administrator extends Thread {

    private final Semaphore mutex;
    private final TelevisionShow regularShow;
    private final TelevisionShow avatar;

    public Administrator(Semaphore mutex, LinkedList yellowCards1, LinkedList greenCards1, LinkedList redCards1,
            LinkedList yellowCards2, LinkedList greenCards2, LinkedList redCards2) {
        this.mutex = mutex;
        this.regularShow = new TelevisionShow("RegularShow", "/GUI/Assets/RegularShow",
                yellowCards1, greenCards1, redCards1);
        this.avatar = new TelevisionShow("Avatar", "/GUI/Assets/Avatar",
                yellowCards2, greenCards2, redCards2);
    }

    public void startSimulation() {

        for (int i = 0; i < 20; i++) {
            regularShow.createCharacter();
            avatar.createCharacter();
        }

        ControlMainUI.getHome().getTvPanelUI1().updateUIQueue(
                regularShow.getQueue1(),
                regularShow.getQueue2(),
                regularShow.getQueue3(),
                regularShow.getQueue4()
        );
        
        ControlMainUI.getHome().getTvPanelUI2().updateUIQueue(
                avatar.getQueue1(),
                avatar.getQueue2(),
                avatar.getQueue3(),
                avatar.getQueue4()
        );

    }

}
