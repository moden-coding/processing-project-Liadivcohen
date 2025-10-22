import processing.core.*;

public class App extends PApplet {
    int circleX = 250;
    int circleY = 250;
    int cirleSpeed = 5;
    int heroy = 415;
    int herox = 50;
    int herow = 200;

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
      
        if (circleY >= heroy && circleX >= herox && circleX <= herox + herow) { // code: if it doesn't touch padel then just go off the screen 
            print("bounce");
             velocity = -10;
        }
       // if (circleY == 0) { 
           // background (255);
      //  }

       
    
        circle(circleX, circleY, 30);
        rect(herox, heroy, herow, 50);
    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            herox -= 10;
        } else if (keyCode == RIGHT) {
            herox += 10;
        }

    }
}
