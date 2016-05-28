import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
/**
 * Created by martin on 26.5.2016.
 */
public class Arrow extends Circle{

    private char direction;
    private Image image = new Image("images/arrow.png");
    private Playground playground;

    public Arrow(double i, double j, char direction, Playground playground){

        this.direction = direction;
        this.playground = playground;

        setCenterX(i*Math.round(playground.getWidth()/7) + Math.round(playground.getWidth()/7)/2);
        setCenterY(j*Math.round(playground.getHeight()/7) + Math.round(playground.getHeight()/7)/2);
        setRadius(Math.round(playground.getWidth()/7)-50);
        setFill(new ImagePattern(image));
        setRotation();
    }
    
    public char getDirection(){
        return direction;
    }

    private void setRotation(){

        if (direction == 'r') setRotate(0);
        if (direction == 'l') setRotate(180);
        if (direction == 'u') setRotate(270);
        if (direction == 'd') setRotate(90);
    }
}
