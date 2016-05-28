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

    public Playground(BorderPane borderPane){

        arrows = new ArrayList<>();
        balls = new ArrayList<>();
        squeres = new ArrayList<>();

        setWidth(6*borderPane.getPrefWidth()/7);
        setHeight(borderPane.getPrefHeight());
        setBackground();
        paint();

    }

    public void addArrow(Arrow a){
        arrows.add(a);
        paint();
    }

    public void addBall(Ball b){
        balls.add(b);
        paint();
    }

    public void addSquere(Squere s){
        squeres.add(s);
        paint();
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
        background.setHeight(getHeight());
        background.setWidth(getWidth());
        background.setFill(Color.web("#FFFFCC"));
    }
}