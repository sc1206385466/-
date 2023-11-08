package DJi;
// 本来想使用现有的包来将经纬度坐标转换为投影坐标系（墨卡托坐标），但导包一直出现问题，故而弃之。

//import com.vividsolutions.jts.geom.Coordinate;
//import com.vividsolutions.jts.geom.GeometryFactory;
//import com.vividsolutions.jts.geom.Point;
//import com.vividsolutions.jts.geom.Polygon;
//import org.osgeo.proj4j.*;
//
//import java.util.Scanner;
//
//public class JTSGeometry_CoordinateTransformation {
//    // 定义用户输入函数
//    public static double input() {
//        Scanner sc = new Scanner(System.in);
//        return sc.nextDouble();
//    }
//
//    public static void main(String[] args) {
//        // 创建要判断的点
//        System.out.println("请输入点的经度：");
//        double longitude = input();
//        System.out.println("请输入点的纬度：");
//        double latitude = input();
//
//        // 经纬度转换为平面坐标
//        CoordinateReferenceSystem sourceCrs = ProjectionFactory.fromPROJ4Specification("+proj=longlat +datum=WGS84 +no_defs");
//        CoordinateReferenceSystem targetCrs = ProjectionFactory.fromPROJ4Specification("+proj=merc +a=6378137 +b=6378137 +lat_ts=0.0 +lon_0=0.0 +x_0=0.0 +y_0=0 +k=1.0 +units=m +nadgrids=@null +no_defs");
//        CoordinateTransformFactory transformFactory = new CoordinateTransformFactory();
//        CoordinateTransform transform;
//        try {
//            transform = transformFactory.createTransform(sourceCrs, targetCrs);
//        } catch (Proj4jException e) {
//            System.out.println("坐标转换出错：" + e.getMessage());
//            return;
//        }
//        ProjCoordinate sourceCoordinate = new ProjCoordinate(longitude, latitude);
//        ProjCoordinate targetCoordinate = new ProjCoordinate();
//        transform.transform(sourceCoordinate, targetCoordinate);
//
//        // 创建要判断的点的平面坐标对象
//        Coordinate pointCoordinate = new Coordinate(targetCoordinate.x, targetCoordinate.y);
//        GeometryFactory geometryFactory = new GeometryFactory();
//        Point point = geometryFactory.createPoint(pointCoordinate);
//
//        // 创建区域的几何对象
//        Coordinate[] polygonCoordinates = new Coordinate[]{
//                new Coordinate(0.0, 0.0),
//                new Coordinate(12.0, 0.0),
//                new Coordinate(9.0, 4.0),
//                new Coordinate(3.0, 4.0),
//                new Coordinate(0.0, 0.0),
//        };
//        Polygon polygon = geometryFactory.createPolygon(polygonCoordinates);
//
//        // 判断点是否在区域内
//        boolean contains = polygon.contains(point);
//        System.out.println("Point is inside polygon: " + contains);
//    }





//import org.locationtech.proj4j.CRSFactory;
//import org.locationtech.proj4j.CoordinateReferenceSystem;
//import org.locationtech.proj4j.CoordinateTransform;
//import org.locationtech.proj4j.CoordinateTransformFactory;
//import org.locationtech.proj4j.ProjCoordinate;
//import org.locationtech.proj4j.io.Proj4FileReader;
//import org.locationtech.proj4j.io.Proj4FileWriter;
//import org.locationtech.proj4j.units.Unit;
//import org.locationtech.proj4j.util.ProjectionUtil;
//
//public class JTSGeometry_CoordinateTransformation {
//    public static void main(String[] args) {
//        // 定义源坐标系和目标坐标系的投影字符串
//        String sourceProjectionStr = "+proj=longlat +datum=WGS84 +no_defs";
//        String targetProjectionStr = "+proj=utm +zone=50 +datum=WGS84 +units=m +no_defs";
//
//        // 创建坐标系工厂并解析投影字符串
//        CRSFactory crsFactory = new CRSFactory();
//        CoordinateReferenceSystem sourceCRS = crsFactory.createFromParameters("sourceCRS", sourceProjectionStr);
//        CoordinateReferenceSystem targetCRS = crsFactory.createFromParameters("targetCRS", targetProjectionStr);
//
//        // 创建坐标转换工厂并获取坐标转换对象
//        CoordinateTransformFactory transformFactory = new CoordinateTransformFactory();
//        CoordinateTransform transform = transformFactory.createTransform(sourceCRS, targetCRS);
//
//        // 创建源坐标点
//        ProjCoordinate sourceCoordinate = new ProjCoordinate(123.456, 45.678);
//
//        // 进行坐标转换
//        ProjCoordinate targetCoordinate = new ProjCoordinate();
//        transform.transform(sourceCoordinate, targetCoordinate);
//
//        // 输出转换后的坐标
//        System.out.println("转换后的坐标 X: " + targetCoordinate.x);
//        System.out.println("转换后的坐标 Y: " + targetCoordinate.y);
//    }
//}




//

//}