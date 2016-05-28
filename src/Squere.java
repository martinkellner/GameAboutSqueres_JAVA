import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * Created by martin on 26.5.2016.
 */
public class Squere extends Rectangle{

    private Circle circle;
    private Color color;
    private char direction;
    private Image image;
    private Playground playground;
    private DropShadow shadow;
    private boolean	shakeBool;

    Squere(double j, double i, Color color, char direction, Playground playground){

        this.color = color;
        this.direction = direction;
        this.playground = playground;
        this.shakeBool = false;
        this.image = new Image(getClass().getResourceAsStream("images/arrowM.png"));
        setWidth(Math.round(playground.getWidth()/7));
        setHeight(Math.round(playground.getHeight()/7));
        setX(i*Math.round(playground.getHeight()/7));
        setY(j*Math.round(playground.getHeight()/7));
        setCircle();
        setFill(color);
        setRot();
        setShadow();
    }


    boolean	canMove(char dir){
        if (dir == 'l' && getX()-getWidth() < 0){
            return false;
        }
        else if(dir == 'r' && getX()+getWidth() >= playground.getWidth()){
            return false;
        }
        else if(dir == 'u' && getY()-getHeight() < 0){
            return false;
        }
        else if(dir == 'd' && getY()+getHeight() > playground.getHeight()){
            return false;
        }
        return true;
    }

    int	countCycle(char dir){
        int angle =0;
        if (direction == 'r'){
            if (dir == 'l') angle = 180;
            if (dir == 'u') angle = 270;
            if (dir == 'd') angle = 90;
        }
        if (direction == 'l'){
            if (dir == 'r') angle = 180;
            if (dir == 'u') angle = 90;
            if (dir == 'd') angle = 270;
        }
        if (direction == 'd'){
            if (dir == 'r') angle = 270;
            if (dir == 'l') angle = 90;
            if (dir == 'u') angle = 180;
        }
        if (direction == 'u'){
            if (dir == 'l') angle = 270;
            if (dir == 'r') angle = 90;
            if (dir == 'd') angle = 180;
        }
        return angle;
    }

    Circle getCircle(){
        return circle;
    }

    Color getColor(){
        return color;
    }

    char getDirection(){
        return direction;
    }

    boolean	getShakeBool(){
        return shakeBool;
    }

    boolean	isClicked(double x, double y){

        return (getX() < x && x < getX()+getWidth() && getY() < y && y < getY()+getHeight());
    }

    void move(char direction){

        if (direction == 'r'){
            setX(getX()+1);
            circle.setCenterX(circle.getCenterX()+1);
        }
        if (direction == 'l'){
            setX(getX()-1);
            circle.setCenterX(circle.getCenterX()-1);
        }
        if (direction == 'd'){
            setY(getY()+1);
            circle.setCenterY(circle.getCenterY()+1);
        }
        if (direction == 'u'){
            setY(getY()-1);
            circle.setCenterY(circle.getCenterY()-1);
        }
        // mozno kreslenie
    }

    void rotate(){
        setRotate(getRotate()+1);
        circle.setRotate(circle.getRotate()-1);
    }

    void rotateArrow(){
        circle.setRotate(circle.getRotate()+1);
    }
    private void setCircle(){

        circle = new Circle();
        circle.setFill(new ImagePattern(image));
        circle.setCenterX(getX()+getWidth()/2);
        circle.setCenterY(getY()+getHeight()/2);

        circle.setRadius(20);
    }

    void setColorShadow(Color color){
        shadow.setColor(color);
    }

    void setDirection(char direction1){
        this.direction = direction1;
    }

    void setRot(){
        if (direction == 'r') circle.setRotate(0);
        if (direction == 'l') circle.setRotate(180);
        if (direction == 'u') circle.setRotate(270);
        if (direction == 'd') circle.setRotate(90);
    }
    private void setShadow(){
        shadow = new DropShadow();
        shadow.setRadius(86);
        shadow.setColor(Color.TRANSPARENT);
        shadow.setOffsetY(0);
        shadow.setOffsetX(0);
        shadow.setSpread(0.7);
        setEffect(shadow);
    }
    void setStrokeSquere(Color color){

        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(3);
        setStroke(color);
    }
    void setTransparentShadow(){
        shadow.setColor(Color.TRANSPARENT);
    }

    void shake0(){
        setX(getX()+2);
        setY(getY()-2);
        shakeBool = true;
    }
    void shake1(){
        setX(getX()-2);
        setY(getY()+2);
        shakeBool = false;
    }
}