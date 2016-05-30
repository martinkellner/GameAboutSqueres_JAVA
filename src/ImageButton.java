import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Trieda pre tlacidla v hre
 * Created by martin kellner on 26.5.2016.
 */
public class ImageButton extends Button {

    private String STYLE_NORMAL0 = "-fx-background-color: transparent;";

    /**
     *
     * Ak ma cestu ku obrazku tak nastavi obrazok ako pozadie a hore definovany STYLE_NORMAL, inak musi mat text, ten
     * nastavi a farbu podla toho ake cislo nesie text, teda text je string cislo
     * @param imageurl cesta k obrazku, moze byt prazdny retazec
     * @param size  urcuje sirku a vysku
     * @param text urcuje text v tlacidle, moze byt prazdny retazec
     */
    public ImageButton(String imageurl, double size, String text){

        setMinHeight(size);
        setMinWidth(size);

        if (imageurl != "") {
            Image image = new Image(getClass().getResourceAsStream(imageurl));
            setStyle(STYLE_NORMAL0);
            setGraphic(new ImageView(image));
        }
        else{
            if (Integer.valueOf(text)%2 == 0){
                setStyle("-fx-background-color: lightskyblue");
            }
            else{
                setStyle("-fx-background-color:lightgreen");
            }
        }
        setText(text);
    }
}