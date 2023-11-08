//
//import
//    import org.geotools.geometry.jts.JTSFactoryFinder;
//import org.geotools.referencing.CRS;
//import org.geotools.referencing.crs.DefaultGeographicCRS;
//import org.geotools.referencing.crs.DefaultProjectedCRS;
//import org.geotools.referencing.operation.DefaultCoordinateOperationFactory;
//import org.geotools.referencing.operation.transform.ProjectiveTransform;
//import org.opengis.geometry.coordinate.Position;
//import org.opengis.referencing.FactoryException;
//import org.opengis.referencing.crs.CoordinateReferenceSystem;
//import org.opengis.referencing.operation.CoordinateOperation;
//import org.opengis.referencing.operation.MathTransform;
//
//import com.vividsolutions.jts.geom.Coordinate;
//import com.vividsolutions.jts.geom.GeometryFactory;
//import com.vividsolutions.jts.geom.Point;
//    public class CoordinateTransformation {
//        public static void main(String[] args) throws FactoryException {
//            // 创建要判断的点的经纬度坐标
//            double longitude = 123.456; // 经度
//            double latitude = 45.678; // 纬度
//
//            // 定义源坐标系和目标坐标系
//            CoordinateReferenceSystem sourceCRS = DefaultGeographicCRS.WGS84; // WGS84坐标系（经纬度）
//            CoordinateReferenceSystem targetCRS = CRS.decode("EPSG:3857"); // Web墨卡托投影坐标系
//
//            // 创建坐标转换操作
//            CoordinateOperation coordinateOperation = new DefaultCoordinateOperationFactory().createOperation(sourceCRS, targetCRS);
//            MathTransform mathTransform = coordinateOperation.getMathTransform();
//
//            // 创建要判断的点的经纬度坐标对象
//            Coordinate sourceCoordinate = new Coordinate(longitude, latitude);
//            GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
//            Point point = geometryFactory.createPoint(sourceCoordinate);
//
//            // 将经纬度坐标转换为平面坐标
//            Point targetPoint = (Point) JTS.transform(point, mathTransform);
//
//            // 获取平面坐标
//            Coordinate targetCoordinate = targetPoint.getCoordinate();
//
//            // 输出平面坐标
//            System.out.println("平面坐标 X: " + targetCoordinate.x);
//            System.out.println("平面坐标 Y: " + targetCoordinate.y);
//        }
//    }
//
//}
