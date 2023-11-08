# Encoding: UTF-8
import matplotlib.pyplot as plt
def sum():
# 定义5个数
    num1 = 1
    num2 = 2
    num3 = 3
    num4 = 4
    num5 = 5
    # 计算它们的和
    total = num1 + num2 + num3 + num4 + num5
    return total

def huatu():
    # x =[0,12,9,3,0]
    # y=[0,0,4,4,0]

    # # 不规则四边形
    # x =[0,12,9,3,0]
    # y =[7,10,17,8,7]

    # 海宁坐标
    x = [30.361647,30.362318,30.362090,30.361494,30.361647]
    y = [120.397399,120.397969,120.398272,120.397736,120.397399]

    # # //    海宁区间经纬度调换顺序    (30.361494, 120.397736)->(30.362090, 120.398272)->(30.362318, 120.397969)->(30.361647, 120.397399)
    # x = [30.361494,30.362090,30.362318,30.361647,30.361494]
    # y = [120.397736,120.398272,120.397969,120.397399,120.397736]

    # plt.axis([0, 12, 0, 4])
    plt.plot(y,x,'r-o')

    # 在每个点上添加标记1234
    for i in range(len(x)-1):
        plt.text(y[i], x[i], str(i+1), fontsize=12, ha='center', va='center')
    plt.show()


if __name__ == '__main__':
    # 输出结果
    total = sum()
    print("这5个数的和为：", total)

    huatu()
    plt.pause(0)
# # BEGIN
# import java.lang.Math;

# public class Main {
#     public static void main(String[] args) {
#         double lon = 116.4074; // 经度
#         double lat = 39.9042; // 纬度
#         double x = lon * 20037508.34 / 180;
#         double y = Math.log(Math.tan((90 + lat) * Math.PI / 360)) / (Math.PI / 180);
#         y = y * 20037508.34 / 180;
#         System.out.println("经度：" + lon + "，纬度：" + lat + "，墨卡托坐标x：" + x + "，墨卡托坐标y：" + y);
#     }
# }
# # END

# public class Main {
#     public static void main(String[] args) {
#         double lon = 116.4074; // 经度
#         double lat = 39.9042; // 纬度
#         double x = lon * 20037508.34 / 180;
#         double y = Math.log(Math.tan((90 + lat) * Math.PI / 360)) / (Math.PI / 180);
#         y = y * 20037508.34 / 180;
#         System.out.println("经度：" + lon + "，纬度：" + lat + "，墨卡托坐标x：" + x + "，墨卡托坐标y：" + y);

#         // 定义区域的边界
#         double minX = 10000000;
#         double minY = 10000000;
#         double maxX = 20000000;
#         double maxY = 20000000;

#         // 检查点是否在区域内
#         boolean isInRegion = isPointInRegion(x, y, minX, minY, maxX, maxY);
#         System.out.println("点是否在区域内：" + isInRegion);
#     }

#     public static boolean isPointInRegion(double x, double y, double minX, double minY, double maxX, double maxY) {
#         return x >= minX && x <= maxX && y >= minY && y <= maxY;
#     }
# }



# public class Main {
#     public static void main(String[] args) {
#         Coordinate[] polygonCoordinates = new Coordinate[]{
#             new Coordinate(0.0, 7.0),
#             new Coordinate(12.0, 10.0),
#             new Coordinate(9.0, 17.0),
#             new Coordinate(3.0, 8.0),
#             new Coordinate(0.0, 7.0)
#         };

#         // 转换多边形的每个顶点坐标，并创建新的Coordinate对象
#         Coordinate[] transformedCoordinates = new Coordinate[polygonCoordinates.length];
#         for (int i = 0; i < polygonCoordinates.length; i++) {
#             double[] mercator = Mercator(polygonCoordinates[i].x, polygonCoordinates[i].y);
#             transformedCoordinates[i] = new Coordinate(mercator[0], mercator[1]);
#         }

#         // 打印转换后的坐标
#         for (Coordinate coordinate : transformedCoordinates) {
#             System.out.println("墨卡托坐标x：" + coordinate.x + "，墨卡托坐标y：" + coordinate.y);
#         }
#     }

#     public static double[] Mercator(double WGS1984_lon, double WGS1984_lat) {
#         double mercator_x = WGS1984_lon * 20037508.34 / 180;
#         double mercator_y = Math.log(Math.tan((90 + WGS1984_lat) * Math.PI / 360)) / (Math.PI / 180);
#         mercator_y = mercator_y * 20037508.34 / 180;
#         return new double[]{mercator_x, mercator_y};
#     }
# }