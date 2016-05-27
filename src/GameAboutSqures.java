import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by martin on 26.5.2016.
 */
public class GameAboutSqures extends Application {

    private Squere[][]	array;
    private ArrayList<Squere>	arrayListSqures;
    private Arrow[][]	arrows;
    private ImageButton	back;
    private Ball[][]	balls;
    private static BorderPane borderPane;
    private ImageButton	grid;
    private Character	lastDir;
    private ArrayList<Squere> lastSteps;
    private ArrayList<ArrayList<Character>>	lastStepsDir;
    private int	level;
    private LevelPanel	levelPanel;
    private java.io.File[]	levels;
    private Playground	playground;
    private Stage primaryStage;
    private ImageButton	restart;
    private boolean	runAnimation;
    private VBoxRight vBoxRight;

    @Override
    public void start(Stage primaryStage) throws Exception {

        array = new Squere[7][7];
        arrows = new Arrow[7][7];
        balls = new Ball[7][7];
        arrayListSqures = new ArrayList<>();

        borderPane = new BorderPane();
        borderPane.setPrefSize(700,600);
        playground = new Playground(borderPane);
        vBoxRight = new VBoxRight();
        borderPane.setLeft(playground);
        borderPane.setRight(playground);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game About Squeres");
        primaryStage.show();





    }
    private void actionForButton(int ind){

    }
    private void aktualizeArray(){

    }
    private void animation(ArrayList<Squere> arrayList){}
    private void backStepAnimation(){}
    private boolean	checkGame(){return true;}
    private void checkPosition(){}
    private void inicializeLevels(){}
    private void levelFinishAimation(){}
    private static void	main(java.lang.String[] args){}
    private void nextLevel(){}
    private void readFile(int i){}
    public void	restartLevel(){}
    private Color returnColor(char c){return Color.YELLOW;}
    private char returnChar(char dir){return dir;};
    private void rotateAnimation(Squere s, char direction){}
    private ArrayList<Squere> selectSqueres(int i, int j){return new ArrayList<>();}


}
