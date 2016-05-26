import javafx.application.Application;
import javafx.scene.layout.BorderPane;
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
    private Stage	primaryStage;
    private ImageButton	restart;
    private boolean	runAnimation;
    private VBoxRight vBoxRight;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    private void actionForButton(int ind){

    }
    private void aktualizeArray(){

    }
    private void animation(ArrayList<Squere> arrayList){}
    private void	backStepAnimation(){}
    private boolean	checkGame(){}
    private void	checkPosition(){}
    private void	inicializeLevels(){}
    private void	levelFinishAimation(){}
    private static void	main(java.lang.String[] args){}
    private void	nextLevel(){}
    private void	readFile(int i){}
    void	restartLevel(){}
    private javafx.scene.paint.Color returnColor(char c){}
    private char	returnChar(char dir){}
    private void	rotateAnimation(Squere s, char direction){}
    private java.util.ArrayList<Squere>	selectSqueres(int i, int j){}


}
