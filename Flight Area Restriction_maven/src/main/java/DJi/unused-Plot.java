// 想把区域画出来，但是导包也有问题，后面用python画了
//package DJi;
//
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//
//public class Plot extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        Canvas canvas = new Canvas(400, 300);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//
//        // 绘制矩形
//        gc.setFill(Color.BLUE);
//        gc.fillRect(50, 50, 200, 100);
//
//        // 绘制圆形
//        gc.setFill(Color.RED);
//        gc.fillOval(250, 150, 100, 100);
//
//        // 创建场景并设置到舞台
//        Scene scene = new Scene(new Group(canvas), 400, 300);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("绘图示例");
//        primaryStage.show();
//    }
//}
