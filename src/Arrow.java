import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
/**
 * Trieda pre sipku na ktorej sa meni smer
 * Created by martin kellner on 26.5.2016.
 */
public class Arrow extends Circle{

    private char direction;
    private Image image = new Image("images/arrow.png");
    private Playground playground;

    /**
     * Pomocou i a j vypocita x a y sipku natoci a nastavi pozadie
     * @param i reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param j reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param direction urcuje smer natocenia
     * @param playground Pane kde sa vykresluju, poskytuje informacie sirky, vysky
     */
    public Arrow(double i, double j, char direction, Playground playground){

        this.direction = direction;
        this.playground = playground;

        setCenterX(i*Math.round(playground.getWidth()/7) + Math.round(playground.getWidth()/7)/2);
        setCenterY(j*Math.round(playground.getHeight()/7) + Math.round(playground.getHeight()/7)/2);
        setRadius(Math.round(playground.getWidth()/7)-50);
        setFill(new ImagePattern(image));
        setRotation();
    }

    /**
     * Vrati smer
     * @return direction - reprezentuje smer
     */
    public char getDirection(){
        return direction;
    }

    /**
     * nastavi spravnu rotaciu podla smeru
     */
    private void setRotation(){
        if (direction == 'r') setRotate(0);
        if (direction == 'l') setRotate(180);
        if (direction == 'u') setRotate(270);
        if (direction == 'd') setRotate(90);
    }
}
