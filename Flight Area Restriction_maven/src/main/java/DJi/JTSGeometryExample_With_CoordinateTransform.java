package DJi;

/**
 * 项目名: 判断经纬度坐标是否在多边形区域内部
 * 说明：使用JTS（Java Topology Suite）库中的within和contains方法均可用来判断点是否在多边形区域内部（该多边形可不规则）
 * 包版本：jts-1.13.jar
 * 作者: Sun Cheng
 * 日期: 2023-11-7 20：58
 * 地点: CJLU
 * 代码说明: 判断经纬度是否在多边形区域内部
 */

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import java.util.Scanner;

// jts库 可以判断任意坐标是否在任意多边形中，包括内凹的多边形。

public class JTSGeometryExample_With_CoordinateTransform {

    /******************* 定义需要判断的坐标输入函数 *******************/
    public static double input() {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        return x;
    }

    /******************* WGS1984经纬度坐标转换为投影坐标系平面墨卡托坐标 *******************/
    /******************* 转换公式详见：https://blog.csdn.net/weixin_42845306/article/details/110313133 *******************/
    public static double[] Mercator(double WGS1984_lon, double WGS1984_lat) {
        double mercator_x = WGS1984_lon * 20037508.34 / 180;
        double mercator_y = Math.log(Math.tan((90 + WGS1984_lat) * Math.PI / 360)) / (Math.PI / 180);
        mercator_y = mercator_y * 20037508.34 / 180;
        System.out.println("经度：" + WGS1984_lon + "，纬度：" + WGS1984_lat + "，墨卡托坐标x：" + mercator_x + "，墨卡托坐标y：" + mercator_y);
        return new double[]{mercator_x, mercator_y};
    }

    public static void main(String[] args) {
        while (true) {
//             创建要判断的点
//```````````````````````````````````````````````````````````````````````
            System.out.println("请输入点的经度：");
            double pointX = input();
            System.out.println("请输入点的纬度：");
            double pointY = input();
//        将待判断的经纬度坐标转换为墨卡托坐标
            double[] mercator = Mercator(pointX, pointY);
            double pointX_mercator = mercator[0];
            double pointY_mercator = mercator[1];
//            System.out.println("墨卡托坐标x：" + pointX_mercator + "，墨卡托坐标y：" + pointY_mercator);
//```````````````````````````````````````````````````````````````````````

            Coordinate pointCoordinate = new Coordinate(pointX_mercator, pointY_mercator); //Coordinate表示一个点的坐标，它包含了x和y两个属性


//            double latitude = 25.0;
//            double longitude = 30.0;
//        Coordinate pointCoordinate = new Coordinate(25.0, 30.0);
            GeometryFactory geometryFactory = new GeometryFactory(); //GeometryFactory是一个几何对象的工厂类，它可以创建几何对象，例如点、线、面等。
            Point point = geometryFactory.createPoint(pointCoordinate); //Point表示一个点，它包含了一个坐标属性

/******************* 创建区域的几何对象 *******************/
            Coordinate[] polygonCoordinates = new Coordinate[]{ //Coordinate数组表示一个多边形的顶点坐标

////                  等腰梯形
//                    new Coordinate(0.0, 0.0),
//                    new Coordinate(12.0, 0.0),
//                    new Coordinate(9.0, 4.0),
//                    new Coordinate(3.0, 4.0),
//                    new Coordinate(0.0, 0.0),

////                  不规则四边形坐标
//                    new Coordinate(0.0, 7.0),
//                    new Coordinate(12.0, 10.0),
//                    new Coordinate(9.0, 17.0),
//                    new Coordinate(3.0, 8.0),
//                    new Coordinate(0.0, 7.0)

//    海宁区间经纬度①-④    (30.361647, 120.397399)->(30.362318, 120.397969)->(30.362090, 120.398272)->(30.361494, 120.397736)

////                  海宁区间经纬度坐标
//                    new Coordinate(30.361647, 120.397399), // Google地图导出的经纬度坐标是先纬度后经度，即（纬度，经度）。
//                    new Coordinate(30.362318, 120.397969),
//                    new Coordinate(30.362090, 120.398272),
//                    new Coordinate(30.361494, 120.397736),
//                    new Coordinate(30.361647, 120.397399)

//                  将海宁区间的经纬度横纵坐标调转一下，改成（经度，纬度）
                    new Coordinate(120.397399, 30.361647), // 为了后期处理方面，这里调转一下，改成（经度，纬度）
                    new Coordinate(120.397969, 30.362318),
                    new Coordinate(120.398272, 30.362090),
                    new Coordinate(120.397736, 30.361494),
                    new Coordinate(120.397399, 30.361647)


            };
/******************* 坐标转换-将闭合区域的经纬度坐标转换为墨卡托坐标 *******************/
            Coordinate[] transformedCoordinates = new Coordinate[polygonCoordinates.length];
            for (int i = 0; i < polygonCoordinates.length; i++) {
                double[] mercator_area = Mercator(polygonCoordinates[i].x, polygonCoordinates[i].y);
                transformedCoordinates[i] = new Coordinate(mercator_area[0], mercator_area[1]);
            }

///******************* 输出polygonCoordinates数组中的每个对象——测试用  *******************/
//            System.out.println("墨卡托坐标为：");
//            for (int i = 0; i < transformedCoordinates.length; i++) {
//                System.out.println(transformedCoordinates[i]);
//            }
            Polygon polygon = geometryFactory.createPolygon(transformedCoordinates); //Polygon表示一个多边形，它包含了一个坐标数组属性

/******************* 判断点是否在区域内 *******************/
//            在JTS（Java Topology Suite）库中，within和contains方法都是用来判断一个几何形状与另一个几何形状的空间关系的，但它们的角度是相反的
//            contains方法是用来判断一个几何形状是否完全包含另一个几何形状。例如，如果你有一个多边形和一个点，你可以使用contains方法来检查这个多边形是否包含这个点。
            boolean contains = polygon.contains(point); //contains方法用于判断一个点是否在多边形内部
            System.out.println("Point is inside polygon-contains: " + contains);

//            within方法是用来判断一个几何形状是否完全在另一个几何形状内部。例如，如果你有一个点和一个多边形，你可以使用within方法来检查这个点是否在这个多边形内部。
            boolean isWithin = point.within(polygon); //within方法用于判断一个点是否在多边形内部
            System.out.println("Point is inside polygon-isWithin: " + isWithin);
            System.out.println("-----------------------------------------------");

        }
    }
}
