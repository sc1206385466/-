# UAV-Flight-Area-Restrictions
本代码使用JTS（Java Topology Suite）库中的within和contains方法来判断点是否在多边形区域内部（该多边形可不规则），
其中包含两个主要程序，
JTSGeometryExample.java 是判断一点是否在平面坐标系上的，
JTSGeometryExample_With_CoordinateTransform.java 在前一代码的基础上增加了经纬度转换投影坐标（墨卡托坐标），实现判断经纬度是否在区域内的功能。
