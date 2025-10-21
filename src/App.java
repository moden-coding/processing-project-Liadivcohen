import processing.core.*;

public class App extends PApplet {
    int circleX = 0;
    int circleY = 0;
    int cirleSpeed = 5;
    int rectX = 0;
    int rectY = 0;
    int herox = 50;

    float velocity;
    float accelration;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {

        accelration = .1f;
        velocity = 3;
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        background(100);
        velocity += accelration;
        circleY += velocity;
        if (circleY >= 415) {
            circleY = 415;
            velocity = 0;
        }
        if (circleY >= 415) {
             velocity = -10;
        }
        if (circleY <= 0 ){
            velocity = 10;
        }

        circle(250, circleY, 30);
        rect(herox, 430, 200, 50);
    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            herox -= 10;
        } else if (keyCode == RIGHT) {
            herox += 10;
        }

    }
}
