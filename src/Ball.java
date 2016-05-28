import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by martin on 26.5.2016.
 */

public class Ball extends Circle {

    private Color color;

    Ball(double i, double j, Color color, Playground playground){

        this.color = color;

        setCenterX(i*Math.round(playground.getWidth()/7) + Math.round(playground.getWidth()/7)/2);
        setCenterY(j*Math.round(playground.getHeight()/7) + Math.round(playground.getHeight()/7)/2);
        setRadius(Math.round(playground.getWidth()/7)-50);
        setFill(color);
    }
    public Color getColor(){
        return color;
    }
}
