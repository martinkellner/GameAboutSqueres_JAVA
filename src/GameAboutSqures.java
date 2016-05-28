import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;

/**
 * Hlavna trieda, aplikacia
 * Created by martin on 26.5.2016.
 */
public class GameAboutSqures extends Application {

    private Squere[][]	array;
    private ArrayList<Squere> arrayListSqures;
    private Arrow[][] arrows;
    private ImageButton	back;
    private Ball[][] balls;
    private static BorderPane borderPane;
    private ImageButton	grid;
    private ArrayList<ImageButton> buttons;
    private ArrayList<Character> lastDir;
    private ArrayList<ArrayList<Squere>> lastSteps;
    private ArrayList<ArrayList<Character>>	lastStepsDir;
    private int	level;
    private LevelPanel	levelPanel;
    private java.io.File[]	levels;
    private Playground	playground;
    private Stage primaryStage;
    private ImageButton	restart;
    private boolean	runAnimation;
    private VBoxRight vBoxRight;
    private Stage newStage;
    public static void main(String[] args){launch(args);}

    /**
     * Funkcia nainicializuje komponenty grafiky, taktiez polia a JavaCollections a
     * nastavi akcie pre klikania a tlacidla
     * @param primaryStage hlavna plocha
     * @throws Exception vyhodenie vynimky
     */

    @Override
    public void start(Stage primaryStage) throws Exception {

        array = new Squere[7][7];
        arrows = new Arrow[7][7];
        balls = new Ball[7][7];
        arrayListSqures = new ArrayList<>();
        level = 0;
        runAnimation = false;
        lastSteps = new ArrayList<>();
        lastStepsDir = new ArrayList<>();
        lastDir = new ArrayList<>();

        borderPane = new BorderPane();
        borderPane.setPrefSize(700,600);
        playground = new Playground(borderPane);
        vBoxRight = new VBoxRight(borderPane);
        borderPane.setLeft(playground);
        borderPane.setRight(vBoxRight);
        levelPanel = new LevelPanel();
        inicializeLevels();
        readFile(0);

        back = vBoxRight.getBack();
        back.setDisable(true);
        back.setOnMousePressed(event -> {
            backStepAnimation();
        });

        restart = vBoxRight.getRestart();
        restart.setOnMousePressed(event -> {
            try {
                restartLevel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        newStage = levelPanel.getNewStage();
        grid = vBoxRight.getGrid();
        grid.setOnMousePressed(event -> {
            primaryStage.hide();
            newStage.show();
        });

        buttons = levelPanel.getButtons();
        for (ImageButton button: buttons) button.setOnMousePressed(event -> {
            try {
                actionForButton(buttons.indexOf(button));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        newStage.setOnCloseRequest(event -> {
            levelPanel.hideStage();
            primaryStage.show();
        });

        playground.setOnMouseClicked(event -> {
            if (!runAnimation){
                for (int i = 0; i < array.length;i++){
                    for(int j = 0; j < array[i].length;j++){
                        if (array[i][j] != null && array[i][j].isClicked(event.getX(),event.getY())){
                            animation(selectSqueres(i,j));
                        }
                    }
                }
            }
        });

        this.primaryStage = primaryStage;
        Scene scene = new Scene(borderPane);
        this.primaryStage.setScene(scene);
        this.primaryStage.setTitle("Game About Squeres");
        this.primaryStage.setResizable(false);
        this.primaryStage.show();

    }

    /**
     * Pri kliknuti na tlacidlo v ponuke levels sa spusti pozadovany level prisluchajuci tlacidlu
     * @param ind cislo levelu
     * @throws IOException vyhodenie vynimky pri nenajdeni suboru
     */
    private void actionForButton(int ind) throws IOException {

        level = ind;
        restartLevel();
        levelPanel.hideStage();
        primaryStage.show();

    }

    /**
     * Aktualizuje pole array na zaklade polohy kociek v graf. ploche
     */
     private void aktualizeArray(){

        array = new Squere[7][7];

        for (Squere squere: arrayListSqures){
            int j = (int) (squere.getX()/Math.round(playground.getWidth()/7));
            int i = (int) (squere.getY()/Math.round(playground.getHeight()/7));
            System.out.println(i + " " + j);
            array[i][j] = squere;
        }
    }

    /**
     * Zisti si sa kocky mozu hybat, ak nie tak zatrasie kockou a
     * ak ano posunie ich o smerom kocky na ktoru bolo kliknute. Taktiez si zapameta kroky pre krok spat.
     * @param arrayList kocky ktore sa budu posuvat
     */
    private void animation(ArrayList<Squere> arrayList){

        runAnimation = true;
        Squere last = arrayList.get(arrayList.size()-1);

        boolean canMove = true;
        char dir = arrayList.get(0).getDirection();
        for (Squere s: arrayList) if (!s.canMove(dir)) canMove = false;

        if (canMove){

            ArrayList<Character> arrayList1 = new ArrayList<>();
            lastSteps.add(arrayList);
            lastDir.add(dir);
            for (Squere s: arrayList){
                arrayList1.add(s.getDirection());
            }
            lastStepsDir.add(arrayList1);
        }


        Timeline animation0 = new Timeline(new KeyFrame(Duration.millis(2),event -> {
            for (Squere s: arrayList) s.move(dir);
        }));

        animation0.setCycleCount(86);
        animation0.setOnFinished(event -> {
            runAnimation = false;
            back.setDisable(false);
            aktualizeArray();
            checkPosition();
            if (checkGame()){
                levelFinishAimation();
            }
        });

        Timeline animation1 = new Timeline(new KeyFrame(Duration.millis(10),event -> {
            if (last.getShakeBool()){
                last.shake1();
            }
            else{
                last.shake0();
            }
        }));

        animation1.setCycleCount(32);
        animation1.setOnFinished(event -> {
            runAnimation = false;
        });

        if (canMove){
            animation0.play();
        } else {
            animation1.play();
        }
    }

    /**
     * Posunie kocky na ich predchazajuce miesto, ak su zapametane nejake kroky spat. Nastavi kockam predchadzajuci smer
     */
    private void backStepAnimation(){

        if (!lastSteps.isEmpty()){
            back.setDisable(true);
            runAnimation = true;
            ArrayList<Squere> squeres = lastSteps.get(lastSteps.size()-1);
            char dir = returnChar(lastDir.get(lastDir.size()-1));
            ArrayList<Character> characters = lastStepsDir.get(lastStepsDir.size()-1);

            Timeline animation = new Timeline(new KeyFrame(Duration.millis(2),event -> {
                for (Squere s: squeres){
                    s.move(dir);
                }
            }));

            animation.setCycleCount(86);
            animation.setOnFinished(event -> {
                runAnimation = false;
                lastSteps.remove(lastSteps.size()-1);
                lastStepsDir.remove(lastStepsDir.size()-1);
                lastDir.remove(lastDir.size()-1);

                for (Squere squere: squeres){
                    squere.setDirection(characters.get(squeres.indexOf(squere)));
                    squere.setRot();
                }

                if (!lastDir.isEmpty()){
                    back.setDisable(false);
                }
                aktualizeArray();
                checkPosition();

            });
            animation.play();
        }
        else{
            back.setDisable(true);
        }
    }

    /**
     * Skontroluje ci je level dokonceny.
     * @return vrati true ak je level dokonceny, false ak nie.
     */
    private boolean	checkGame(){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] != null && balls[i][j] !=null && array[i][j].getColor() != balls[i][j].getColor()){
                    return false;
                }
                else if (array[i][j] != null && balls[i][j] == null){
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * Nastavi tien ak sa nachadza kocka na lopte, spusti animaciu na otocenie sipky ak je kocka na sipke a oramuje
     * kocku a
     */
    private void checkPosition(){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] != null && balls[i][j] != null){
                    array[i][j].setColorShadow(balls[i][j].getColor());
                }
                else if (array[i][j] != null){
                    array[i][j].setTransparentShadow();
                }

                if (array[i][j] != null && arrows[i][j] != null){
                    if (array[i][j].getDirection() != arrows[i][j].getDirection()){
                        rotateAnimation(array[i][j],arrows[i][j].getDirection());
                        array[i][j].setStrokeSquere(Color.GREY);
                    }
                    else{
                        array[i][j].setStrokeSquere(Color.GREY);
                    }
                }
                else if (array[i][j] != null){
                    array[i][j].setStrokeSquere(Color.TRANSPARENT);
                }
            }
        }
    }

    /**
     * nainicializuje pole files, kde ulozi levely.
     */
    private void inicializeLevels(){

        levels = new File[16];
        for (int i = 0; i < 10; i++) levels[i] = new File("levels/level0"+String.valueOf(i)+".txt");
        for (int i = 0; i < 6; i++) levels[10+i] = new File("levels/level1"+String.valueOf(i)+".txt");
    }

    /**
     * Animacia na otocenie kociek pri uspesnom dokonceni levelu
     */
    private void levelFinishAimation(){

        runAnimation = true;

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(2),event -> {
            for (Squere squere: arrayListSqures){
                squere.rotate();
            }
        }));
        animation.setCycleCount(360);
        animation.setOnFinished(event -> {

            back.setDisable(true);
            if (level != 15){
                try {
                    nextLevel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {

            }
        });
        animation.play();

    }

    /**
     * Nacita dalsi level
     * @throws IOException pri nenajdeni suboru
     */
     private void nextLevel() throws IOException {
        level++;
        restartLevel();
        runAnimation = false;
    }

    /**
     *
     * @param i
     * @throws IOException
     */
    private void readFile(int i) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(levels[i])));
        String line = "";

        while ((line = bufferedReader.readLine()) != null){

            Color c;
            if (line.charAt(3) == 'r'){
                c = Color.LIGHTCORAL;
            }
            else if(line.charAt(3) == 'b'){
                c = Color.LIGHTSKYBLUE;
            }
            else if(line.charAt(3) == 'o'){
                c = Color.ORANGE;
            }
            else{
                c = Color.LIGHTGREEN;
            }

            if (line.charAt(0) == 's'){
                int x = Integer.parseInt(String.valueOf(line.charAt(1)));
                int y = Integer.parseInt(String.valueOf(line.charAt(2)));
                Squere newSquere = new Squere(x,y,c,line.charAt(4),playground);
                arrayListSqures.add(newSquere);
                playground.addSquere(newSquere);
            }
            else if (line.charAt(0) == 'b'){
                int x = Integer.parseInt(String.valueOf(line.charAt(1)));
                int y = Integer.parseInt(String.valueOf(line.charAt(2)));
                Ball newBall = new Ball(y,x,c,playground);
                balls[x][y] = newBall;
                playground.addBall(newBall);
            }
            else if (line.charAt(0) == 'a'){
                int x = Integer.parseInt(String.valueOf(line.charAt(1)));
                int y = Integer.parseInt(String.valueOf(line.charAt(2)));
                Arrow newArrow = new Arrow(y,x,line.charAt(3),playground);
                arrows[x][y] = newArrow;
                playground.addArrow(newArrow);
            }
        }
        aktualizeArray();
        checkPosition();
        bufferedReader.close();
    }

    public void	restartLevel() throws IOException {
        playground.reset();
        arrayListSqures.clear();
        array = new Squere[7][7];
        balls = new Ball[7][7];
        arrows = new Arrow[7][7];
        lastDir.clear();
        lastSteps.clear();
        lastStepsDir.clear();
        readFile(level);
        runAnimation = false;
    }

    private char returnChar(char dir){
        if (dir == 'l') return 'r';
        if (dir == 'r') return 'l';
        if (dir == 'u') return 'd';
        if (dir == 'd') return 'u';
        return ' ';
    }

    private void rotateAnimation(Squere s, char direction){

        runAnimation = true;
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(2),event -> {
            s.rotateArrow();
        }));

        animation.setCycleCount(s.countCycle(direction));
        animation.setOnFinished(event -> {
            runAnimation = false;
            s.setDirection(direction);
            s.setRot();
        });
        animation.play();
    }

    private ArrayList<Squere> selectSqueres(int i, int j) {

        ArrayList<Squere> squeres = new ArrayList<>();
        squeres.add(array[i][j]);
        char direction = array[i][j].getDirection();
        int k = 0;
        int s = 0;

        while(true){

            if (direction == 'l') {
                k--;
            }
            else if (direction == 'r'){
                k++;
            }
            else if (direction == 'u'){
                s--;
            }
            else if (direction == 'd'){
                s++;
            }

            if (-1 < i+s && i+s < array.length && -1 < j+k && j+k < array.length && array[i+s][j+k] != null){
                squeres.add(array[i+s][j+k]);
            }else {
                break;
            }
        }
        return squeres;
    }
}
