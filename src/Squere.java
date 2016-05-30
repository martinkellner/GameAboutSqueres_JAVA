import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * Trieda pre pohybujucu sa kocku.
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

    /**
     * Pomocou i a j vypocita x a y sipku ktorej obrazok nacita aj spravne natoci, sipka je pozadie Circle ktoru nastavi,
     * dalej nainicializuje premenne a nastavi tien (default: transparent)
     * @param i reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param j reprezentuje pozicu v poli v Triede GameAboutSqueres
     * @param direction reprezentuje smer natocenia sipky v kocke, teda aj urcuje smer pohybu
     * @param color urcuje farbu
     * @param playground Pane kde sa vykresluju, poskytuje informacie sirky, vysky
     */
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

    /**
     * Zisti ci sa kocka moze pohnut.
     * @param dir - smer kam by sa mala hybat.
     * @return vrati false ak sa nemoze pohnut, inak true
     */
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

    /**
     * Vrati o kolko stupnov sa ma zmenit uhol aby sipka v kocke mala smer dir.
     * @param dir urceje smer.
     * @return Vrati ciselnu hodnotu, pocet stupnov.
     */
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

    /**
     * Vrati instanciu kruhu v kocke.
     * @return premenna circle
     */
    Circle getCircle(){

        return circle;
    }

    /**
     * Vrati farbu.
     * @return premennu color.
     */
    Color getColor(){

        return color;
    }

    /**
     * Vrati farbu kocky.
     * @return premenna color
     */
    char getDirection(){

        return direction;
    }

    /**
     * Vrati premennu shakeBool, ktora sa vyuziva na striedanie pri animacii trasenia kocky
     * @return premenna shakeBool
     */
    boolean	getShakeBool(){
        return shakeBool;
    }

    /**
     * Zisti ci x,y suradnice sa nachadzaju v kocke, pouziva sa pri zistovanii ci bolo kliknute na kocku.
     * @param x - suradnica kliknutia
     * @param y - suradnica kliknutia
     * @return False, ak nebolo kliknute na kocku, inak true
     */
    boolean	isClicked(double x, double y){

        return (getX() < x && x < getX()+getWidth() && getY() < y && y < getY()+getHeight());
    }

    /**
     * Posunie kocku v smere urcenom paramertrom direction
     * @param direction smer pohybu
     */
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
    }

    /**
     * Otoci o jeden stupen kocku aj kruh( teda sipku ), pouziva sa pri animacii ukoncenia levelu
     */
    void rotate(){
        setRotate(getRotate()+1);
        circle.setRotate(circle.getRotate()-1);
    }

    /**
     * Otoci sipku v kocke o jeden stupen.
     */
    void rotateArrow(){
        circle.setRotate(circle.getRotate()+1);
    }

    /**
     * Nainicializuje premennu circle, ako pozadie nastavi obrazok sipky a nastavi velkost a suradnice na stred kocky.
     */
    private void setCircle(){

        circle = new Circle();
        circle.setFill(new ImagePattern(image));
        circle.setCenterX(getX()+getWidth()/2);
        circle.setCenterY(getY()+getHeight()/2);
        circle.setRadius(20);
    }

    /**
     * Nastavi farbu tiena
     * @param color - farba
     */
    void setColorShadow(Color color){

        shadow.setColor(color);
    }

    /**
     * Nastavi premennu direction.
     * @param direction1 - hodnota na ktoru sa ma nastavit
     */
    void setDirection(char direction1){

        this.direction = direction1;
    }

    /**
     * Nastavi rotaciu sipky, teda ju otoci bez animacie.
     */
    void setRot(){
        if (direction == 'r') circle.setRotate(0);
        if (direction == 'l') circle.setRotate(180);
        if (direction == 'u') circle.setRotate(270);
        if (direction == 'd') circle.setRotate(90);
    }

    /**
     * Nainicializuje shadow nastavi velkost a prida ako effekt kocky.
     */
    private void setShadow(){
        shadow = new DropShadow();
        shadow.setRadius(86);
        shadow.setColor(Color.TRANSPARENT);
        shadow.setOffsetY(0);
        shadow.setOffsetX(0);
        shadow.setSpread(0.6);
        setEffect(shadow);
    }

    /**
     * Nastavi oramovanie a farbu oramovania kocky.
     * @param color - farba
     */
     void setStrokeSquere(Color color){

        setStrokeType(StrokeType.INSIDE);
        setStrokeWidth(3);
        setStroke(color);
    }

    /**
     * Nastavi farbu tiena na priehliadnu.
     */
    void setTransparentShadow(){
        shadow.setColor(Color.TRANSPARENT);
    }

    /**
     * Pouziva sa pri traseni, pohne kockou jednym smerom.
     */
    void shake0(){
        setX(getX()+2);
        setY(getY()-2);
        shakeBool = true;
    }

    /**
     * Pouziva sa pri traseni, pohne kockou druhym smerom.
     */
    void shake1(){
        setX(getX()-2);
        setY(getY()+2);
        shakeBool = false;
    }
}