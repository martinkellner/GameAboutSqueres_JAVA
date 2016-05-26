import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by martin on 26.5.2016.
 */

public class Ball extends Circle {

    private Color color;
    private double size;

    Ball(double i, double j, Color color, Playground playground){}
    public Color getColor(){return color;}
}
