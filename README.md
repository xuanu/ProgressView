# ProgressView
圆形的进度条，多种定制

![image](https://github.com/xuanu/ProgressView/raw/master/screenshots/QQ截图20170321112255.png)

### 实现方式
1. 在控件中心画短边圆
2. 在圆内画进度弧

### 可定义属性
 ```
    <declare-styleable name="CircleProgressView">
        <attr name="bgColor" format="color"></attr>
        <attr name="progressColor" format="color"></attr>
        <attr name="isClockWise" format="boolean"></attr>
        <attr name="startAngle" format="float"></attr>
        <attr name="arcMargin" format="dimension"></attr>
        <attr name="total" format="integer"></attr>
        <attr name="progress" format="integer"></attr>
    </declare-styleable>
 ```
 ![image](https://github.com/xuanu/ProgressView/raw/master/screenshots/QQ截图20170321112255_PxCook.png)
 ```
 1. isClockWise,是否为顺时针开始画
 2. startAngle，开始的角度，默认-90
 3. total  一个圆的总数,分成多少份，默认10份
 4. progress 当前进度
 ```


### 添加依赖
 Add it in your root build.gradle at the end of repositories:

 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}Copy
 Step 2. Add the dependency

 	dependencies {
 	        compile 'com.github.xuanu:ProgressView:1.3'
 	}



