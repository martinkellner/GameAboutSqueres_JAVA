import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
/**
 * Created by martin on 26.5.2016.
 */
public class Playground extends Pane {

    private ArrayList<Arrow> arrows;
    private Rectangle background;
    private ArrayList<Ball>	balls;
    private ArrayList<Squere> squeres;

    Playground(BorderPane borderPane){

        arrows = new ArrayList<>();
        balls = new ArrayList<>();
        squeres = new ArrayList<>();

        setWidth(borderPane.getWidth()/7);
        setHeight(borderPane.getHeight());
        setBackground();

    }

    public void addArrow(Arrow a){
        arrows.add(a);
    }

    public void addBall(Ball b){
        balls.add(b);
    }

    public void addSquere(Squere s){
        squeres.add(s);
    }

    public void paint(){
        getChildren().clear();
        getChildren().add(background);

        for (Arrow arrow: arrows) getChildren().add(arrow);
        for (Ball ball: balls) getChildren().add(ball);
        for (Squere squere: squeres){
            getChildren().add(squere);
            getChildren().add(squere.getCircle());
        }
    }

    public void reset(){
        arrows.clear();
        balls.clear();
        squeres.clear();
    }
    private void setBackground(){

        background = new Rectangle();
        background.setX(0);
        background.setY(0);
        background.setWidth(getWidth());
        background.setHeight(getHeight());
        background.setFill(Color.CORAL);
    }
}