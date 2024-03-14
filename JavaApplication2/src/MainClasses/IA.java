/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import GUIClasses.ControlMainUI;
import Helpers.ImageUtils;
import MainPackage.App;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author angel
 */
public class IA extends Thread {

    private Administrator administrator;
    private CharacterTv regularShowFighter;
    private CharacterTv avatarFighter;
    private int victoriesRegularShow = 0;
    private int victoriesAvatar = 0;

    private final Semaphore mutex;

    private long time;
    private int round;

    public IA() {
        this.administrator = App.getApp().getAdmin();
        this.mutex = App.getApp().getMutex();
        this.time = App.getApp().getBattleDuration();
        this.round = 0;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.mutex.acquire();

                this.round += 1;

                ControlMainUI.getHome().getWinnerLabelID().setText("");
                ControlMainUI.getHome().getIaStatusLabel().setText("Determinando el resultado del combate...");
                updateCardsUI(getRegularShowFighter(), getAvatarFighter());

                ControlMainUI.getHome().getRoundLabel().setText("Round: " + String.valueOf(round));

                Thread.sleep((long) (this.getTime() * 1000 * 0.7));

                double aux = Math.random();

                if (aux <= 0.4) {
                    ControlMainUI.getHome().getIaStatusLabel().setText("¡Hay un ganador!");
                    CharacterTv winner = getWinnerCharacter(this.regularShowFighter, this.avatarFighter);
                    ControlMainUI.getHome().getWinnerLabelID().setText(winner.getCharacterId());

                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));

                } else if (aux > 0.40 && aux <= 0.67) {
                    ControlMainUI.getHome().getIaStatusLabel().setText("¡El combate termina en empate!");
                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));

                    this.getAdministrator().getRegularShow().getQueue1().enqueue(this.regularShowFighter);
                    this.getAdministrator().getAvatar().getQueue1().enqueue(this.avatarFighter);
                } else {
                    ControlMainUI.getHome().getIaStatusLabel().setText("El combate no se llevará a cabo.");
                    Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.6));

                    this.getAdministrator().getRegularShow().getQueue4().enqueue(this.regularShowFighter);
                    this.getAdministrator().getAvatar().getQueue4().enqueue(this.avatarFighter);
                }

                clearFightersUI();

                Thread.sleep((long) ((getTime() * 1000 * 0.3) * 0.4));
                this.mutex.release();
                Thread.sleep(100);

            } catch (InterruptedException ex) {
                Logger.getLogger(IA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearFightersUI() {
        ControlMainUI.getHome().getIaStatusLabel().setText("Esperando nuevos personajes...");
        ControlMainUI.getHome().getWinnerLabelID().setText("");
        ControlMainUI.getHome().getRegularShowFighter().clearFightersLabels();
        ControlMainUI.getHome().getAvatarFighter().clearFightersLabels();
    }

    private CharacterTv getWinnerCharacter(CharacterTv regularShowCharacter, CharacterTv avatarCharacter) {
        double aux = Math.random();

        if (aux <= 0.5) {
            this.victoriesRegularShow += 1;
            ControlMainUI.getHome().getTvPanelUI1().getVictoriesLabel().setText(
                    String.valueOf(this.victoriesRegularShow)
            );

            return regularShowCharacter;
        }
        this.victoriesAvatar += 1;
        ControlMainUI.getHome().getTvPanelUI2().getVictoriesLabel().setText(
                String.valueOf(this.victoriesAvatar)
        );
        return avatarCharacter;
    }

    private void updateCardsUI(CharacterTv regularShowCharacter, CharacterTv avatarCharacterTv) {
        ImageUtils imageUtils = new ImageUtils();

        ImageIcon regularShowCardIA = imageUtils.loadScaledImage(
                regularShowCharacter.getUrlSource(), 150, 200
        );

        ImageIcon avatarCardIA = imageUtils.loadScaledImage(
                avatarCharacterTv.getUrlSource(), 150, 200
        );

        ControlMainUI.getHome().getRegularShowFighter().getFighterCard().setIcon(regularShowCardIA);
        ControlMainUI.getHome().getRegularShowFighter().getCharacterIDLabel().setText(regularShowCharacter.getCharacterId());

        ControlMainUI.getHome().getAvatarFighter().getFighterCard().setIcon(avatarCardIA);
        ControlMainUI.getHome().getAvatarFighter().getCharacterIDLabel().setText(avatarCharacterTv.getCharacterId());
    }

    /**
     * @return the regularShowFighter
     */
    public CharacterTv getRegularShowFighter() {
        return regularShowFighter;
    }

    /**
     * @param regularShowFighter the regularShowFighter to set
     */
    public void setRegularShowFighter(CharacterTv regularShowFighter) {
        this.regularShowFighter = regularShowFighter;
    }

    /**
     * @return the avatarFighter
     */
    public CharacterTv getAvatarFighter() {
        return avatarFighter;
    }

    /**
     * @param avatarFighter the avatarFighter to set
     */
    public void setAvatarFighter(CharacterTv avatarFighter) {
        this.avatarFighter = avatarFighter;
    }

    /**
     * @return the administrator
     */
    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * @param administrator the administrator to set
     */
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(long time) {
        this.time = time;
    }

}
