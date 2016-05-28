import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by martin on 26.5.2016.
 */
public class LevelPanel extends GridPane{

    private ArrayList<ImageButton> buttons;
    private Stage newStage;

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

    public ArrayList<ImageButton> getButtons(){
        return buttons;

    }

    public Stage getNewStage(){
        return newStage;
    }

    public void hideStage(){
        newStage.hide();
        newStage.close();
    }

    public void showStage(){
        newStage.show();
    }


}
