import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
/**
 * Created by martin on 26.5.2016.
 */
public class Playground extends Pane {

    private ArrayList<Arrow> arrows;
    private Rectangle background;
    private ArrayList<Ball>	balls;
    private BorderPane borderPane;
    private ArrayList<Squere> squeres;

    Playground(BorderPane borderPane){}
    public void addArrow(Arrow a){}
    public void addBall(Ball b){}
    public void addSquere(Squere s){}
    public void paint(){}
    public void reset(){}
    private void setBackground(){}
}
