import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Trieda pre lopticku v hre
 * Created by martin on 26.5.2016.
 */

public class Ball extends Circle {

    private Color color;

    /**
     * Pomocou i a j vypocita x a y sipku natoci a nastavi pozadie
     * @param i reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param j reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param color urcuje farbu
     * @param playground Pane kde sa vykresluju, poskytuje informacie sirky, vysky
     */
    Ball(double i, double j, Color color, Playground playground){

        this.color = color;

        setCenterX(i*Math.round(playground.getWidth()/7) + Math.round(playground.getWidth()/7)/2);
        setCenterY(j*Math.round(playground.getHeight()/7) + Math.round(playground.getHeight()/7)/2);
        setRadius(Math.round(playground.getWidth()/7)-50);
        setFill(color);
    }

    /**
     * Vrati farbu gulicky
     * @return color - farba gulicky
     */
    public Color getColor(){
        return color;
    }
}
