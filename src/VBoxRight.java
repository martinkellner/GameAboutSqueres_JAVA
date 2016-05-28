import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 * Created by martin on 26.5.2016.
 */
public class VBoxRight extends VBox {
    private Rectangle background;
    private ImageButton	back;
    private ImageButton	grid;
    private ImageButton	restart;

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

    public ImageButton getBack(){
        return back;
    }
    public ImageButton	getGrid(){
        return grid;
    }
    public ImageButton	getRestart(){
        return restart;
    }

}
