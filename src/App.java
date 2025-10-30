import processing.core.*;

public class App extends PApplet {
    // ball
    float circleX, circleY;
    

    // high score
    float highscore = -1;
    float previousScore = 0;

    // padle
    float heroy = 415;
    float herox = 50;
    float herow = 200;
    float heroh = 50;
    float speed = 3;

    boolean left, right;

    // game start
    float ballHit = 0;
    float score = 0;
    float scene = 1;

    float velocityY; // vertical speed
    float velocityX; // horizontal speed
    float accelration;
    float speedMultiplier = 1; 
    float R=0;
    float G=0;
    float B=0;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        textSize(25);
        accelration = .1f;
        resetGame();
       

        left = false;
        right = false;


    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        
 
        if (scene == 1) {
            gameplay();
            text("Bounce: " + score, 0, 50);
            text("Circle Speed = " + speedMultiplier, 0, 75);

        } else if (scene == 2) {
            background(0);
            text("Game over", 50, 250);
            text("Press space bar to play again", 50, 285);
            text("You score is: " + score, 50, 350);
            text ("Your highscore is: " + highscore,50, 315);
        }
        // makes the padel move smoothly

        if (left == true && herox > 0) {
            herox -= 10;

        }
        if (right == true && herox < width - herow) {
            herox += 10;

        }

        if (score > highscore){
            highscore = score;
        }

    }

    public void gameplay() {
        background(100);
        velocityY += accelration;
        circleY += velocityY;
        circleX += velocityX;

        //Deticts if the ball went off or on the side of the screen, if it does makes it switch directions

        if (circleY <= 0) { 
            velocityY = abs(velocityY); // abs = absolute value if was -5 it becomes 5, if was 5 it stays as 5
        }
        if (circleX <= 0 || circleX >= width) { 
            velocityX = -velocityX; 

        }

        if (circleY >= heroy && circleX >= herox && circleX <= herox + herow) { // if it doesn't touch padel, then just
                                                                                // go off the screen

                                                                                
            // When the ball hits the padel, than it chooses a random point to go to. When bounces gets to 3 increase speed.
            ballHit += 1; 
            velocityX = random(-3, 3);
            R=random (0,255);
            G=random (0,255);
            B=random (0,255);

            println("bounce");
            velocityY = -10 * speedMultiplier;
            if (ballHit % 3 == 0) {
                speedMultiplier += 0.2; 
            }
            println(score);
            score++;

        }
        // keeps track of high score
        
        if (circleY >= 500) {
             if (score > highscore){
                highscore = score;
        } else{
            score=ballHit;
        }


        scene = 2;
    }
    fill (R,G,B);
    circle(circleX, circleY, 30);
    fill(255);
    rect(herox, heroy, herow, heroh);
}

    public void keyPressed() {

        //The controls and what happens when you press them

        if (keyCode == LEFT) {
            left = true;
        }
        if (keyCode == RIGHT) {
            right = true;

        }

        if (key == ' ') {
            scene = 1;
            resetGame();

        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            left = false;

        }
        if (keyCode == RIGHT) {
            right = false;

        }

    }

    public void resetGame() {
        circleX = 250;
        circleY = 250;
        velocityY = 0;
        velocityX = 0;
        speedMultiplier = 1;
        herox = 50;
        heroy = 415;
        score = 0;

    }
}
