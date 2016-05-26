import com.sun.prism.paint.Color;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by martin on 26.5.2016.
 */
public class Squere extends Rectangle{

    private Circle circle;
    private Color color;
    private char direction;
    private String directions;
    private Image image;
    private Playground playground;
    private DropShadow shadow;
    private boolean	shakeBool;

    Squere(double i, double j, javafx.scene.paint.Color color, char direction, Playground playground){}

    boolean	canMove(char dir){}
    int	countCycle(char dir){}
    Circle getCircle(){}
    Color getColor(){}
    char getDirection(){}
    boolean	getShakeBool(){}
    boolean	isClicked(double x, double y){}
    void move(char direction){}
    void rotate(){}
    void rotateArrow(){}
    private void setCircle(){}
    void setColorShadow(Color color){}
    void setDirection(char direction1){}
    void setRot(){}
    private void setShadow(){}
    void setStrokeSquere(Color color){}
    void setTransparentShadow(){}
    void shake0(){}
    void shake1(){}

}
