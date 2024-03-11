/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClasses;

import EDD.Queue;

/**
 *
 * @author user
 */
public class TelevisionShow {
    
    
    private Queue<CharacterTv> queue1 = new Queue<CharacterTv>();
    private Queue<CharacterTv> queue2 = new Queue<CharacterTv>();
    private Queue<CharacterTv> queue3 = new Queue<CharacterTv>();
    private Queue<CharacterTv> queue4 = new Queue<CharacterTv>();
    private String packageImg;
    private String logoUrl;
    
    
    
    public TelevisionShow(String packageImg) {
        this.packageImg = packageImg;
        this.logoUrl = this.packageImg + "/logo.png";
    }
    
    public CharacterTv createCharacter() {
        double randomValue = Math.random(); 
        
        
    }
    
    
    
    
    public void createInitialCharacters(){
        
    }
    
    
    
    
    
    
    
    
    

    /**
     * @return the queue1
     */
    public Queue<CharacterTv> getQueue1() {
        return queue1;
    }

    /**
     * @param queue1 the queue1 to set
     */
    public void setQueue1(Queue<CharacterTv> queue1) {
        this.queue1 = queue1;
    }

    /**
     * @return the queue2
     */
    public Queue<CharacterTv> getQueue2() {
        return queue2;
    }

    /**
     * @param queue2 the queue2 to set
     */
    public void setQueue2(Queue<CharacterTv> queue2) {
        this.queue2 = queue2;
    }

    /**
     * @return the queue3
     */
    public Queue<CharacterTv> getQueue3() {
        return queue3;
    }

    /**
     * @param queue3 the queue3 to set
     */
    public void setQueue3(Queue<CharacterTv> queue3) {
        this.queue3 = queue3;
    }

    /**
     * @return the queue4
     */
    public Queue<CharacterTv> getQueue4() {
        return queue4;
    }

    /**
     * @param queue4 the queue4 to set
     */
    public void setQueue4(Queue<CharacterTv> queue4) {
        this.queue4 = queue4;
    }

    /**
     * @return the packageImg
     */
    public String getPackageImg() {
        return packageImg;
    }

    /**
     * @param packageImg the packageImg to set
     */
    public void setPackageImg(String packageImg) {
        this.packageImg = packageImg;
    }

    /**
     * @return the logoUrl
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * @param logoUrl the logoUrl to set
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

}
