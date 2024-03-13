/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import EDD.LinkedList;
import GUIClasses.ControlMainUI;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angel
 */
public class Administrator extends Thread {

    private final Semaphore mutex;
    private final TelevisionShow regularShow;
    private final TelevisionShow avatar;
    private int numRound = 0;

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
            getRegularShow().createCharacter();
            getAvatar().createCharacter();
        }

        ControlMainUI.getHome().getTvPanelUI1().updateUIQueue(getRegularShow().getQueue1(),
                getRegularShow().getQueue2(),
                getRegularShow().getQueue3(),
                getRegularShow().getQueue4()
        );

        ControlMainUI.getHome().getTvPanelUI2().updateUIQueue(getAvatar().getQueue1(),
                getAvatar().getQueue2(),
                getAvatar().getQueue3(),
                getAvatar().getQueue4()
        );

        ControlMainUI.getHome().setVisible(true);

        try {
            mutex.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                updateReinforcementQueue(this.regularShow);
                updateReinforcementQueue(this.avatar);

                if (numRound == 2) {
                    tryCreateCharacters();
                    numRound = 0;
                }

                CharacterTv regularShowFighter = chooseFighters(this.getRegularShow());
                CharacterTv avatarFighter = chooseFighters(this.getAvatar());

                //------------------
                //TODO: Pasarle los fighters a la IA
                // Aca 0j0
                //------------------
                
                
                updateUIqueue();
                mutex.release();
                Thread.sleep(500);
                mutex.acquire();

                risePriorities(this.getRegularShow());
                risePriorities(this.getAvatar());

                this.numRound += 1;
                updateUIqueue();

            } catch (InterruptedException ex) {
                Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void risePriorities(TelevisionShow tvShow) {

    }

    private CharacterTv chooseFighters(TelevisionShow tvShow) {
        if (tvShow.getQueue1().isEmpty()) {
            tvShow.updateQueue1();
        }
        CharacterTv fighter = tvShow.getQueue1().dequeue();
        fighter.setCounter(0);
        return fighter;
    }

    private void updateUIqueue() {
        ControlMainUI.updateUIQueue("regularshow",
                this.getRegularShow().getQueue1(),
                this.getRegularShow().getQueue2(),
                this.getRegularShow().getQueue3(),
                this.getRegularShow().getQueue4());
        ControlMainUI.updateUIQueue("avatar",
                this.getAvatar().getQueue1(),
                this.getAvatar().getQueue2(),
                this.getAvatar().getQueue3(),
                this.getAvatar().getQueue4());
    }

    private void updateReinforcementQueue(TelevisionShow tvShow) {
        if (!(tvShow.getQueue4().isEmpty())) {
            double randomNum = Math.random();

            if (randomNum <= 0.4) {
                CharacterTv character = tvShow.getQueue4().dequeue();
                character.setCounter(0);
                tvShow.getQueue1().enqueue(character);
            }
        }
    }

    private void tryCreateCharacters() {
        double randomNum = Math.random();

        if (randomNum <= 0.8) {
            getRegularShow().createCharacter();
            getAvatar().createCharacter();
        }
    }

    /**
     * @return the regularShow
     */
    public TelevisionShow getRegularShow() {
        return regularShow;
    }

    /**
     * @return the avatar
     */
    public TelevisionShow getAvatar() {
        return avatar;
    }

}
