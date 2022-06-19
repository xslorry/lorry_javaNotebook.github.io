



# IO流

![image-20220501132242555](IO流.assets/image-20220501132242555-16513825635441.png)

![image-20220501133055705](IO流.assets/image-20220501133055705-16513830570982.png)

![image-20220501134602212](IO流.assets/image-20220501134602212-16513839634023.png)

![image-20220501134834235](IO流.assets/image-20220501134834235-16513841152124.png)

## ==**目录也是文件**==

![image-20220501135851549](IO流.assets/image-20220501135851549-16513847325085.png)

![image-20220501140449404](IO流.assets/image-20220501140449404-16513850901386.png)

# InputStream

常用子类

https://www.cainiaojc.com/java/java-fileinputstream.html

1. FileInputStream：文件输入流

   ![image-20220501142824023](IO流.assets/image-20220501142824023.png)

   

2. BufferedInputStream：缓冲字节输入流

3. ObjectInputStream：对象字节输入流

## OutputStream

![image-20220503103325608](IO流.assets/image-20220503103325608-16515452064878.png)



三种写入的方式：

![image-20220503103842118](IO流.assets/image-20220503103842118-16515455230519.png)

拷贝文件的时候需要用第三种方法，不然会有多余的字节产生。

![image-20220503104040284](IO流.assets/image-20220503104040284-165154564127710.png)



# FileReader和FileWriter

==按照字符来操作io==

![image-20220503105205524](IO流.assets/image-20220503105205524-165154632652911.png)



![image-20220503105449399](IO流.assets/image-20220503105449399-165154649057712.png)

为啥执行close()方法执行后才会写入数据，因为底层会调用writerBytes方法

flush()方法底层也是调用的这个，close()方法等于flush()+关闭

# 节点流和处理流

![image-20220503150230744](IO流.assets/image-20220503150230744-165156135179413.png)

![image-20220503150606979](IO流.assets/image-20220503150606979-165156156774714.png)

![image-20220505114347924](IO流.assets/image-20220505114347924-16517222289491.png)

![image-20220505121811748](IO流.assets/image-20220505121811748-16517242926402.png)

1. BufferedReader 和 BufferedWriter 是按照字符操作
2. 不能操作二进制文件[声音、视频]可能会造成文件损坏

![image-20220505125657890](IO流.assets/image-20220505125657890-16517266195403.png)

字节流的处理方法能操作文件（字符是由字节组成的），反之不行。

![image-20220506120836926](IO流.assets/image-20220506120836926-16518101186435.png)



## ObjectOutputStream和ObjectInputStream

![image-20220506120918058](IO流.assets/image-20220506120918058-16518101591336.png)

## ObjectOutputStream

常用方法：

- write() - 将字节数据写入输出流
- writeBoolean() - 以布尔形式写入数据
- writeChar() - 以字符形式写入数据
- writeInt() - 以整数形式写入数据
- writeUTF-以字符串形式写入数据
- writeObject() - 将对象写入输出流

## ObjectIutputStream

**InputStream类提供了由其子类实现的不同方法。以下是一些常用的方法**

- read() - 从输入流中读取一个字节的数据
- read(byte[] array) - 从流中读取字节并存储在指定的数组中
- available() - 返回输入流中可用的字节数
- mark() - 标记输入流中数据所在的位置
- reset() -将控制点返回到流中设置标记的点
- markSupported()- 检查流中是否支持mark()和reset()方法
- skips() - 跳过和丢弃输入流中的指定字节数
- close() - 关闭输入流

![image-20220506124252926](IO流.assets/image-20220506124252926-16518121741317.png)

## 标准输入输出流

![image-20220506124929885](IO流.assets/image-20220506124929885-16518125707818.png)

Systeam.in 编译类型: InputStream，运行类型: BufferedInputStream 表示的是标准输入键盘

Systeam.out 编译类型: PrintStream，运行类型: PrintStream 表示的是标准输出 显示器

## 转换流 InputStreamReader和OutputStreamWriter

![image-20220506130535620](IO流.assets/image-20220506130535620-16518135366489.png)

InputStream是字节流的抽象类，Reader是字符流的抽象类，将字节流转换成字符流即：InputStreamReader

OutputStream是字节流的抽象类，Writer是字符流的抽象类，将字节流转换成字符流即：OutputStreamWriter

常用于在指定写入、读取数据的字符编码类型（**UTF8**或**UTF16**）。

```java
FileInputStream file = new FileInputStream(String path);
InputStreamReader input = new InputStreamReader(file, Charset cs);

入器。

//创建一个OutputStream
FileOutputStream file = new FileOutputStream(String path);

//创建一个OutputStreamWriter，指定字符编码
OutputStreamWriter output = new OutputStreamWriter(file, Charset cs);
```

## 打印流-PrintStream和PrintWriter

打印流只有输出流没有输入流

![image-20220507110540207](IO流.assets/image-20220507110540207-165189274130610.png)

![image-20220507110605092](IO流.assets/image-20220507110605092-165189276586111.png)

## Properties类





![image-20220508145819496](IO流.assets/image-20220508145819496-165199310093512.png)