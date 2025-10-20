import processing.core.*;

public class App extends PApplet {
    int circleX = 0;
    int circleY = 0;
    int rectX = 0;
    int rectY = 0;
    int herox = 50;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {

    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        background(100);
        circle(250, circleY, 30);
        circleY += 2;
        rect(herox, 430, 200, 50);
    }

    public void keyPressed() {
        rect(herox, 430, 200, 50);
        if (keyCode == LEFT){
             herox -= 5;
        }else if (keyCode == RIGHT){
        herox += 5;
     }
        
        

    }
}
