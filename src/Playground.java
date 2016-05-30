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

    /**
     * Nainicializuje collectios, kde si bude ukladat objekty na vykreslenie. Nastavi vysku, sirku a zavola funkcie na
     * nastavenie pozadia, potom sa vytresli pomocou funkcie paint()
     * @param borderPane
     */
    public Playground(BorderPane borderPane){

        arrows = new ArrayList<>();
        balls = new ArrayList<>();
        squeres = new ArrayList<>();

        setWidth(Math.round(6*borderPane.getPrefWidth()/7));
        setHeight(borderPane.getPrefHeight());
        setMaxWidth(Math.round(6*borderPane.getPrefWidth()/7));
        setMaxHeight(borderPane.getPrefHeight());
        setBackground();
        paint();

    }

    /**
     * Prida objekt typu Arrow do listu arrows a prekresli plochu
     * @param a obejkt typu Arrow
     */
    public void addArrow(Arrow a){
        arrows.add(a);
        paint();
    }

    /**
     * Prida objekt typu Ball do listu balls a prekresli plochu
     * @param b obejkt typu Ball
     */
    public void addBall(Ball b){
        balls.add(b);
        paint();
    }

    /**
     * Prida objekt typu Squere do listu squeres a prekresli plochu
     * @param s obejkt typu Arrow
     */
    public void addSquere(Squere s){
        squeres.add(s);
        paint();
    }

    /**
     * vykresli pozadia a vsetky zapamatane objekty v listoch
     */
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

    /**
     * Vymaze obsah listov.
     */
    public void reset(){
        arrows.clear();
        balls.clear();
        squeres.clear();
    }

    /**
     * Nastavi pozadie a jeho farbu
     */
    private void setBackground(){
        background = new Rectangle();
        background.setX(0);
        background.setY(0);
        background.setHeight(getHeight());
        background.setWidth(getWidth());
        background.setFill(Color.web("#FFFFCC"));
    }
}