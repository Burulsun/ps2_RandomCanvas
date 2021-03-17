package Random2D;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import java.security.SecureRandom;
import java.util.Stack;

public class RandomShapeController {

    @FXML
    private Canvas canvasArea;

    GraphicsContext graphicsContext;


    private SecureRandom random = new SecureRandom();

    private int num;

    private int[] arr1;
    private int[] arr2;
    private int[] arrCircle ;
    private int[] arrCircle2 ;
    private int[] arrEllipse;
    private int[] arrEllipse2;
    Stack<Shape> stack = new Stack();

    public void initialize() {

        graphicsContext = canvasArea.getGraphicsContext2D();

        num = random.nextInt(10) + 1;
        arr1 = new int[num];
        arr2 = new int[num];

//        arrCircle  = new int[num];
//        arrCircle2  = new int[num];
//        arrEllipse  = new int[num];
//        arrEllipse2  = new int[num];

        for (int i = 0; i < num; i++) {
            Rectangle rectangle = new Rectangle();
//            Ellipse ellipse = new Ellipse();
//            Circle circle = new Circle();

            rectangle.setFill(randomColor());
            rectangle.setStrokeWidth(random.nextInt(20));
            rectangle.setStroke(randomColor());
            rectangle.setWidth(random.nextInt(50));
            rectangle.setHeight(random.nextInt(80));
            rectangle.setX(random.nextInt(500)+50);
            rectangle.setY(random.nextInt(500)+50);
            Rectangle tempRect = new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
            tempRect.setFill(randomColor());
            stack.push(tempRect);


//            ellipse.setRadiusX(random.nextInt(100));
//            ellipse.setRadiusY(random.nextInt(100));
//            ellipse.setCenterX(random.nextInt(500)+50);
//            ellipse.setCenterY(random.nextInt(500)+50);
//
//            ellipse.setFill(randomColor());
//            ellipse.setStrokeWidth(random.nextInt(20));
//            ellipse.setStroke(randomColor());
//
//
//            circle.setCenterX(random.nextInt(300) + 50);
//            circle.setCenterY(random.nextInt(300) + 50);
//            circle.setRadius(random.nextInt(100));
//            circle.setFill(randomColor());
//            circle.setStrokeWidth(random.nextInt(20));
//            circle.setStroke(randomColor());









//            pane.getChildren().add(circle);
//            pane.getChildren().add(circle);
//            pane.getChildren().add(ellipse);

            arr1[i] = 1 + random.nextInt(5);
            arr2[i] = 1 + random.nextInt(5);
            arrCircle[i] = 1 + random.nextInt(5);
            arrCircle2[i] = 1 + random.nextInt(5);
            arrEllipse[i] = 1 + random.nextInt(5);
            arrEllipse2[i] = 1 + random.nextInt(5);

            Timeline timelineAnimation = new Timeline(

                    new KeyFrame(Duration.millis(15), e -> moveShape(rectangle, num))
            );

            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
            timelineAnimation.play();



        }


    }

    private void moveShape(Rectangle r, int i) {


            r.setWidth(r.getWidth() + arr1[i]);
            r.setHeight(r.getHeight() + arr2[i]);
            if (r.getX() + r.getWidth() > canvasArea.getWidth() || r.getX() + r.getHeight() < 0) arr1[i] = -arr1[i];
            if (r.getY() + r.getHeight() > canvasArea.getHeight() || r.getY() + r.getHeight() < 0) arr2[i] = -arr2[i];

//            Circle c = (Circle) pane.getChildren().get(i);
//            c.setCenterX(c.getCenterX() + arrCircle[i]);
//            c.setCenterY(c.getCenterY() + arrCircle2[i]);
//            if (c.getCenterX() + c.getRadius() > pane.getWidth() || c.getCenterX() - c.getRadius() < 0) arrCircle[i] = -arrCircle[i];
//            if (c.getCenterY() + c.getRadius() > pane.getHeight() || c.getCenterY() - c.getRadius() < 0) arrCircle2[i] = -arrCircle2[i];
//
//            Ellipse e = (Ellipse) pane.getChildren().get(i);
//            e.setCenterX(e.getCenterX() + arrEllipse[i]);
//            e.setCenterY(e.getCenterY() + arrEllipse2[i]);
//            if (e.getCenterX() + e.getRadiusX() > pane.getWidth() || e.getCenterX() - e.getRadiusX() < 0) arrEllipse[i] = -arrEllipse[i];
//            if (e.getCenterY() + e.getRadiusY() > pane.getHeight() || e.getCenterY() - e.getRadiusY() < 0) arrEllipse2[i] = -arrEllipse2[i];




    }
    private Color randomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                (double) random.nextInt(101) / 100);
    }
}

