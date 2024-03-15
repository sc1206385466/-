replit 运行 UAV-Flight-Area-Restrictions 方法

# 针对java

## 编译：
Flight Area Restriction_maven/src/jar/jts-1.13.jar 路径为上，编译失败怎么办

![img](data:image/svg+xml,%3csvg%20xmlns=%27http://www.w3.org/2000/svg%27%20version=%271.1%27%20width=%2724%27%20height=%2724%27/%3e)![AI](https://replit.com/public/images/ghostwriter/blurple-circle.svg)

根据您提供的信息，您遇到的问题是找不到`jts-1.13.jar`库，导致编译失败。

要解决这个问题，您需要确保在编译项目时正确指定`jts-1.13.jar`库的路径。您可以使用`-cp`参数来指定类路径，将`jts-1.13.jar`库包含在编译路径中。

以下是如何使用`-cp`参数来编译项目的示例命令：

```java
javac -cp "Flight Area Restriction_maven/src/jar/jts-1.13.jar" Flight\ Area\ Restriction_maven/src/main/java/DJi/JTSGeometryExample_With_CoordinateTransform.java
```

请注意，在上述命令中，`-cp`参数后面跟着`jts-1.13.jar`库的完整路径，确保路径正确。这样就可以解决找不到`jts-1.13.jar`库导致的编译失败问题。


## 运行
要运行Java应用程序，并确保正确加载jts-1.13.jar库，您需要使用`java`命令并指定类路径(`-cp`)以包含jts-1.13.jar库。

以下是如何在命令行中运行Java应用程序的示例命令：

```
java -cp "Flight Area Restriction_maven/src/jar/jts-1.13.jar:Flight Area Restriction_maven/src/main/java" DJi.JTSGeometryExample_With_CoordinateTransform
```

在上述命令中，`-cp`参数后跟着jts-1.13.jar库的完整路径以及Java应用程序的包含文件夹。DJi.JTSGeometryExample_With_CoordinateTransform指示要运行的主类。

通过运行上面的命令，您可以启动Java应用程序，并确保正确加载jts-1.13.jar库以及与该库有关的主类。

# 针对python

## 导包 （要先创建虚拟环境）
要解决这个问题，您可以尝试在Replit中使用虚拟环境来隔离项目的依赖关系。以下是在Replit中创建和激活虚拟环境的步骤：

1. 创建虚拟环境：

```
python3 -m venv venv
```

1. 激活虚拟环境：

```
source venv/bin/activate
```

1. 在虚拟环境中安装requirements.txt文件中所需的包：

```
pip install -r requirements.txt
```

通过使用虚拟环境，您可以绕过外部管理环境施加的限制，并成功为项目安装所需的包。

## 运行

```
huizhiquyutu.py
```

