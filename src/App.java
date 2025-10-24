import processing.core.*;

public class App extends PApplet {
    int circleX, circleY;
    int circleSpeed = 5;
    int heroy = 415;
    int herox = 50;
    int herow = 200;
    int heroh = 50;

    int increaseSpeed;

    int scene = 1;

    float velocity;
    float accelration;

    int score = 0;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        textSize(25);
        accelration = .1f;
        int circleSpeed = 5;
        resetGame();
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        if (scene == 1) {
            gameplay();
              text ("Bounce: " + score, 0, 50);

              text ("Circle Speed = " +   circleSpeed, 0, 75);
              
              

        } else if (scene == 2) {
            background(0);
            text("Game over", 50, 250);
            text("Press space bar to play again", 50, 285);
        }
    }

    public void gameplay() {
        background(100);
        velocity += accelration;
        circleY += velocity;
    
        if (circleY >= heroy && circleX >= herox && circleX <= herox + herow) { // code: if it doesn't touch padel
                                                                                // then just go off the screen
            println("bounce");
            velocity = -10;

            println(score);
            score ++;

            println("increase speed");
            circleSpeed = 5;
            
           
        }

        if (circleY >= 500) {
            scene = 2;
        }
       
        circle(circleX, circleY, 30);
        rect(herox, heroy, herow, heroh);
    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            herox -= 10;
        } else if (keyCode == RIGHT) {
            herox += 10;
        }

        if (key == ' ') {
            scene = 1;
            resetGame();

        }
    }

    public void resetGame() {
        circleX = 250;
        circleY = 250;
        velocity = 3;
        herox = 50;
        heroy = 415;
        score = 0;

    }
}
