package DJi;

/**
 * 项目名: 判断点是否在多边形区域内部
 * 说明：使用JTS（Java Topology Suite）库中的within和contains方法均可用来判断点是否在多边形区域内部（该多边形可不规则）
 * 包版本：jts-1.13.jar
 * 作者: Sun Cheng
 * 日期: 2023-11-7 11：48
 * 地点: CJLU
 * 代码说明: 判断点是否在多边形区域内部
 */

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import java.util.Scanner;

public class JTSGeometryExample {

// jts库 可以判断任意坐标是否在任意多边形中，包括内凹的多边形。

    /******************* 定义需要判断的坐标输入函数 *******************/
    public static double input() {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        return x;
    }


    /******************* WGS1984经纬度坐标转换为投影坐标系平面墨卡托坐标 *******************/
    public static double[] Mercator(double WGS1984_lon, double WGS1984_lat) {   //若要把坐标改成经纬度，这边的经纬度位置关系还需要对应，还要更改，另一个文件的JTSGeometryExample_With_CoordinateTransform.java中的经纬度位置关系已经对应好了。
        double mercator_x = WGS1984_lon * 20037508.34 / 180;
        double mercator_y = Math.log(Math.tan((90 + WGS1984_lat) * Math.PI / 360)) / (Math.PI / 180);
        mercator_y = mercator_y * 20037508.34 / 180;
        System.out.println("经度：" + WGS1984_lon + "，纬度：" + WGS1984_lat + "，墨卡托坐标x：" + mercator_x + "，墨卡托坐标y：" + mercator_y);
        return new double[]{mercator_x, mercator_y};
    }

    public static void main(String[] args) {
        while (true) {
            // 创建要判断的点

//```````````````````````````````````````````````````````````````````````
            System.out.println("请输入点的坐标X轴：");
            double pointX = input();
            System.out.println("请输入点的坐标Y轴：");
            double pointY = input();
//        将待判断的经纬度坐标转换为墨卡托坐标
            double[] mercator = Mercator(pointX, pointY);
            double pointX_mercator = mercator[0];
            double pointY_mercator = mercator[1];
//            System.out.println("墨卡托坐标x：" + pointX_mercator + "，墨卡托坐标y：" + pointY_mercator);
//```````````````````````````````````````````````````````````````````````

            Coordinate pointCoordinate = new Coordinate(pointX, pointY); //Coordinate表示一个点的坐标，它包含了x和y两个属性


//            double latitude = 25.0;
//            double longitude = 30.0;
//        Coordinate pointCoordinate = new Coordinate(25.0, 30.0);
            GeometryFactory geometryFactory = new GeometryFactory(); //GeometryFactory是一个几何对象的工厂类，它可以创建几何对象，例如点、线、面等。
            Point point = geometryFactory.createPoint(pointCoordinate); //Point表示一个点，它包含了一个坐标属性

/******************* 创建区域的几何对象 *******************/
            Coordinate[] polygonCoordinates = new Coordinate[]{ //Coordinate数组表示一个多边形的顶点坐标

//                    new Coordinate(0.0, 0.0),
//                    new Coordinate(12.0, 0.0),
//                    new Coordinate(9.0, 4.0),
//                    new Coordinate(3.0, 4.0),
//                    new Coordinate(0.0, 0.0),
                    new Coordinate(0.0, 7.0),
                    new Coordinate(12.0, 10.0),
                    new Coordinate(9.0, 17.0),
                    new Coordinate(3.0, 8.0),
                    new Coordinate(0.0, 7.0)

            };
            Polygon polygon = geometryFactory.createPolygon(polygonCoordinates); //Polygon表示一个多边形，它包含了一个坐标数组属性

/******************* 判断点是否在区域内 *******************/
//            在JTS（Java Topology Suite）库中，within和contains方法都是用来判断一个几何形状与另一个几何形状的空间关系的，但它们的角度是相反的
//            contains方法是用来判断一个几何形状是否完全包含另一个几何形状。例如，如果你有一个多边形和一个点，你可以使用contains方法来检查这个多边形是否包含这个点。
            boolean contains = polygon.contains(point); //contains方法用于判断一个点是否在多边形内部
            System.out.println("Point is inside polygon-contains: " + contains);

//            within方法是用来判断一个几何形状是否完全在另一个几何形状内部。例如，如果你有一个点和一个多边形，你可以使用within方法来检查这个点是否在这个多边形内部。
            boolean isWithin = point.within(polygon); //within方法用于判断一个点是否在多边形内部
            System.out.println("Point is inside polygon-isWithin: " + isWithin);
//double yyyyyyy = 3.1415926535897932384626;
//            System.out.println("yyyyyyy: " + yyyyyyy);
            System.out.println("-----------------------------------------------");

        }
    }
}