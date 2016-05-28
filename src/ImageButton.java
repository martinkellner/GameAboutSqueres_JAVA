import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by martin on 26.5.2016.
 */
public class ImageButton extends Button {

    private String STYLE_NORMAL0 = "-fx-background-color: transparent;";
    private String STYLE_NORMAL1 = "-fx-background-color: green;";
    private String STYLE_PRESSED = "-fx-background-color:transparent;";


    public ImageButton(String imageurl, double size, String text){

        setMinHeight(size);
        setMinWidth(size);

        if (imageurl != "") {
            Image image = new Image(getClass().getResourceAsStream(imageurl));
            setStyle(STYLE_NORMAL0);
            setGraphic(new ImageView(image));
        }
        else{
            setStyle(STYLE_NORMAL1);
            setText(text);
        }
    }

    public String getSt(){
        return STYLE_PRESSED;
    }
}
