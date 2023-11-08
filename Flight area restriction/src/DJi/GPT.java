package DJi;
/**
 * 作者: Sun Cheng
 * 日期: 2023-11-7 11：48
 * 地点: CJLU
 * 代码说明: 判断点是否在矩形内部
 */
// 2023.11.7 11：48
// @ cjlu
// @ suncheng
//
import java.util.Scanner;

public class GPT {
    public static boolean isPointInRectangle(double pointX, double pointY, double rectX1, double rectY1, double rectX2, double rectY2, double rectX3, double rectY3, double rectX4, double rectY4) {
        // 判断点是否在矩形范围内
        boolean isInside = false;

        // 使用射线法判断点是否在矩形内部
        int intersectionCount = 0; // 交点计数器
        double[] xPoints = {rectX1, rectX2, rectX3, rectX4}; // 矩形的四个顶点坐标
        double[] yPoints = {rectY1, rectY2, rectY3, rectY4}; // 矩形的四个顶点坐标

        // 循环处理矩形的每条边
        for (int i = 0; i < 4; i++) {
            double x1 = xPoints[i]; // 边的第一个顶点的 X 坐标
            double y1 = yPoints[i]; // 边的第一个顶点的 Y 坐标
            double x2 = xPoints[(i + 1) % 4]; // 边的第二个顶点的 X 坐标
            double y2 = yPoints[(i + 1) % 4]; // 边的第二个顶点的 Y 坐标

            // 检查边与射线的交点
            if ((y1 < pointY && y2 >= pointY) || (y1 >= pointY && y2 < pointY)) { // 边与射线平行或包含在射线中
                double intersectX = x1 + (pointY - y1) / (y2 - y1) * (x2 - x1); // 计算交点的 X 坐标

                // 如果交点在射线右侧，则增加交点计数
                if (intersectX > pointX) { // 交点在射线右侧
                    intersectionCount++; // 增加交点计数
                }
            }
        }

        // 如果交点计数为奇数，点在矩形内部
        if (intersectionCount % 2 == 1) { // 交点计数为奇数
            isInside = true; // 点在矩形内部
        }

        return isInside; // 返回点是否在矩形内部
    }

    // 定义用户输入函数
    public static double input() {
        Scanner sc = new Scanner(System.in);
        float x = sc.nextFloat();
        return x;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入点的坐标X轴：");
//            double pointX = 9.0;
            double pointX = input();
            System.out.println("请输入点的坐标Y轴：");
//            double pointY = 4.0;
            double pointY = input();
            double rectX1 = 0.0;
            double rectY1 = 0.0;
            double rectX2 = 12.0;
            double rectY2 = 0.0;
            double rectX3 = 9.0;
            double rectY3 = 4.0;
            double rectX4 = 3.0;
            double rectY4 = 4.0;

            if (isPointInRectangle(pointX, pointY, rectX1, rectY1, rectX2, rectY2, rectX3, rectY3, rectX4, rectY4)) {
                System.out.println("点在矩形范围内-true");
            } else {
                System.out.println("点不在矩形范围内-false");
                System.out.println("--------------------------------------");


                // 判断是否按下 'q' 键并退出循环
//                System.out.println("按下 'q' 键退出程序");
//                Scanner  sc= new Scanner(System.in);
//                if (sc.nextLine().equalsIgnoreCase("q")) {
//                    break;
//                }
            }
        }
    }
}