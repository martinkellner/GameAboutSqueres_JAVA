import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Trieda pre panel s talcidlami.
 * Created by martin on 26.5.2016.
 */
public class VBoxRight extends VBox {

    private ImageButton	back;
    private ImageButton	grid;
    private ImageButton	restart;

    /**
     * Nastavi velkost, farbu panelu, vytvori tlacidla.
     * @param borderPane
     */
    VBoxRight(BorderPane borderPane){

        back = new ImageButton("images/back.png",100,"");
        grid = new ImageButton("images/grid.png",100,"");
        restart = new ImageButton("images/restart.png",100,"");

        setHeight(borderPane.getPrefHeight());
        setWidth(borderPane.getPrefWidth()/7);
        setStyle("-fx-background-color: #FFFFCC");
        getChildren().add(restart);
        getChildren().add(back);
        getChildren().add(grid);
        setAlignment(Pos.CENTER);
    }

    /**
     * Vrati tlacidlo back
     * @return premenna back
     */
    public ImageButton getBack(){

        return back;
    }
    /**
     * Vrati tlacidlo grid
     * @return premenna grid
     */
    public ImageButton	getGrid(){

        return grid;
    }
    /**
     * Vrati tlacidlo restart
     * @return premenna restart
     */
    public ImageButton	getRestart(){
        return restart;
    }

}
