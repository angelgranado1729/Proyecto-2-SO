/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import MainClasses.Character;

public class FileFunctions {
    // Definimos arrays para cada categoría
    private static Character[] yellowRegularShow;
    private static Character[] greenRegularShow;
    private static Character[] redRegularShow;
    private static Character[] yellowAvatar;
    private static Character[] greenAvatar;
    private static Character[] redAvatar;

    public static void read(File file) {
        String line;

        // Contadores para cada categoría
        int countYellowRegularShow = 0;
        int countGreenRegularShow = 0;
        int countRedRegularShow = 0;
        int countYellowAvatar = 0;
        int countGreenAvatar = 0;
        int countRedAvatar = 0;

        // Determinar el tamaño de cada array
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentShow = null;
            while ((line = br.readLine()) != null) {
                if (!(line.isEmpty())) {
                    if (line.startsWith("[")) {
                        currentShow = line.substring(1, line.length() - 1);
                    } else {
                        // Verificamos el color y el show actual para incrementar el contador correspondiente
                        if (line.contains("yellow") && "Regular Show".equals(currentShow)) {
                            countYellowRegularShow++;
                        } else if (line.contains("green") && "Regular Show".equals(currentShow)) {
                            countGreenRegularShow++;
                        } else if (line.contains("red") && "Regular Show".equals(currentShow)) {
                            countRedRegularShow++;
                        } else if (line.contains("yellow") && "Avatar".equals(currentShow)) {
                            countYellowAvatar++;
                        } else if (line.contains("green") && "Avatar".equals(currentShow)) {
                            countGreenAvatar++;
                        } else if (line.contains("red") && "Avatar".equals(currentShow)) {
                            countRedAvatar++;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicializamos los arrays con el tamaño contado para cada uno
        setYellowRegularShow(new Character[countYellowRegularShow]);
        setGreenRegularShow(new Character[countGreenRegularShow]);
        setRedRegularShow(new Character[countRedRegularShow]);
        setYellowAvatar(new Character[countYellowAvatar]);
        setGreenAvatar(new Character[countGreenAvatar]);
        setRedAvatar(new Character[countRedAvatar]);

        // Índices para llenar los arrays
        int indexYellowRegularShow = 0;
        int indexGreenRegularShow = 0;
        int indexRedRegularShow = 0;
        int indexYellowAvatar = 0;
        int indexGreenAvatar = 0;
        int indexRedAvatar = 0;

        // Rellenar los arrays con las instancias de Character
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentShow = null;
            while ((line = br.readLine()) != null) {
                if (!(line.isEmpty())) {
                    if (line.startsWith("[")) {
                        currentShow = line.substring(1, line.length() - 1);
                    } else {
                        String[] parts = line.split(",");
                        String url = parts[5].split(";")[0]; // Para aislar la URL que es el ultimo elemento en cada fila. 

                        Character character = new Character(
                            // AQUÍ EL ID ES 0 PORQUE EL ID SE ESCOGE AL MOMENTO SELECCIÓN PARA ALGUNA COLA. 
                            // Es decir, por default ID 0
                            0, 
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Integer.parseInt(parts[3]),
                            parts[4],
                            url
                        );
                        
                        // Clasificar el personaje en el array correspondiente
                        if (line.contains("yellow.png") && "Regular Show".equals(currentShow)) {
                            getYellowRegularShow()[indexYellowRegularShow++] = character;
                        } else if (line.contains("green.png") && "Regular Show".equals(currentShow)) {
                            getGreenRegularShow()[indexGreenRegularShow++] = character;
                        } else if (line.contains("red.png") && "Regular Show".equals(currentShow)) {
                            getRedRegularShow()[indexRedRegularShow++] = character;
                        } else if (line.contains("yellow.png") && "Avatar".equals(currentShow)) {
                            getYellowAvatar()[indexYellowAvatar++] = character;
                        } else if (line.contains("green.png") && "Avatar".equals(currentShow)) {
                            getGreenAvatar()[indexGreenAvatar++] = character;
                        } else if (line.contains("red.png") && "Avatar".equals(currentShow)) {
                            getRedAvatar()[indexRedAvatar++] = character;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the yellowRegularShow
     */
    public static Character[] getYellowRegularShow() {
        return yellowRegularShow;
    }

    /**
     * @param aYellowRegularShow the yellowRegularShow to set
     */
    public static void setYellowRegularShow(Character[] aYellowRegularShow) {
        yellowRegularShow = aYellowRegularShow;
    }

    /**
     * @return the greenRegularShow
     */
    public static Character[] getGreenRegularShow() {
        return greenRegularShow;
    }

    /**
     * @param aGreenRegularShow the greenRegularShow to set
     */
    public static void setGreenRegularShow(Character[] aGreenRegularShow) {
        greenRegularShow = aGreenRegularShow;
    }

    /**
     * @return the redRegularShow
     */
    public static Character[] getRedRegularShow() {
        return redRegularShow;
    }

    /**
     * @param aRedRegularShow the redRegularShow to set
     */
    public static void setRedRegularShow(Character[] aRedRegularShow) {
        redRegularShow = aRedRegularShow;
    }

    /**
     * @return the yellowAvatar
     */
    public static Character[] getYellowAvatar() {
        return yellowAvatar;
    }

    /**
     * @param aYellowAvatar the yellowAvatar to set
     */
    public static void setYellowAvatar(Character[] aYellowAvatar) {
        yellowAvatar = aYellowAvatar;
    }

    /**
     * @return the greenAvatar
     */
    public static Character[] getGreenAvatar() {
        return greenAvatar;
    }

    /**
     * @param aGreenAvatar the greenAvatar to set
     */
    public static void setGreenAvatar(Character[] aGreenAvatar) {
        greenAvatar = aGreenAvatar;
    }

    /**
     * @return the redAvatar
     */
    public static Character[] getRedAvatar() {
        return redAvatar;
    }

    /**
     * @param aRedAvatar the redAvatar to set
     */
    public static void setRedAvatar(Character[] aRedAvatar) {
        redAvatar = aRedAvatar;
    }
    
    
}
