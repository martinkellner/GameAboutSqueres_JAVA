import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**Trieda pre ponuku levelov
 * Created by martin on 26.5.2016.
 */
public class LevelPanel extends GridPane{

    private ArrayList<ImageButton> buttons;
    private Stage newStage;

    /**
     * Vytvori ponuku levelov, nastavi farby a velkost a vytvori tlacidla, ktore si zapamata v ArrayList -e, vytvori novu
     * scenu a do nej vlozi vytvoreny gridpanel a vytvori novy stage kde nastavi ako scenu vytvorenu scenu.
     */
    public LevelPanel(){

        buttons = new ArrayList<>();
        newStage = new Stage();

        setWidth(86*4+60);
        setHeight(86*4+60);
        setVgap(10);
        setHgap(10);
        setStyle("-fx-background-color: lightcoral");

        int k = 0;
        for (int i =0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                ImageButton imageButton = new ImageButton("",86,String.valueOf(k));
                buttons.add(imageButton);
                add(imageButton,j,i);
                k++;
            }
        }

        Scene scene = new Scene(this);
        newStage = new Stage();
        newStage.setTitle("Levels");
        newStage.setScene(scene);

    }

    /**
     * Vrati list tlacidiel
     * @return ArrayList buttons
     */
    public ArrayList<ImageButton> getButtons(){

        return buttons;
    }

    /**
     * Vrati vytvoreny stage
     * @return Stage newStage
     */
    public Stage getNewStage(){

        return newStage;
    }

    /**
     * Zatvori stage.
     */
    public void hideStage(){

        newStage.hide();
        newStage.close();
    }

    /**
     * Zobrazi stage.
     */
    public void showStage(){
        newStage.show();
    }
}