## SimpleImmersiveBar

### 简介：

Android 极简实现沉浸式状态栏/导航栏

| Activity      | Fragment                          | Dialog       | DialogFragment |
| ------------- | --------------------------------- | ------------ | -------------- |
| &#10004; 支持 | &#10007; 不支持，结合Activity使用 | &#10004;支持 | &#10004; 支持  |

注： 未单独支持Fragment原因： 1. Fragment依赖于Activity展示，2. 实现思路基于window，Fragment没有自己的window

代码实现思路参考：

[Android 系统 Bar 沉浸式完美兼容方案](https://mp.weixin.qq.com/s/NvmOlJzEkdrJREueIFd_DA)

完善了Dialog/DialogFragment的沉浸式



#### 效果图：

https://github.com/FrizzleLiu/simple_immersive_bar/tree/main/app/gif/preview.gif

### 使用

##### 依赖：

```
implementation 'io.github.frizzleliu:immersivebar:1.0.1'
```



- Activity中：

  在`onCreate` 方法`setContentView`调用之前调用`immersiveBar()`即可

- Dialog中：

  - 方式一：继承`ImmersiveBottomBarDialog` 或者 `ImmersiveTopBarDialog`即可

  - 方式二：在`Dialog#onCreate()`中调用`immersiveStatusBar()/ immersiveNavigationBar()`并设置Dialog的Style为`ImmersiveBarDialog`示例如下：

    ```
    class ImmersiveBottomBarDialog : AlertDialog {
        constructor(context: Context) : super(context, R.style.ImmersiveBarDialog)
        }
    ```

    

  

- DialogFragment中：

  - 方式一：继承`ImmersiveBottomDialogFragment`或 `ImmersiveTopDialogFragment`

  - 方式二： `onViewCreated` 方法中调用`immersiveStatusBar()/immersiveNavigationBar` 注意如果是顶部的`DialogFragment` 需设置`Style`，示例如下：

    ```
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setStyle(STYLE_NORMAL, R.style.ImmersiveBarDialog)
        }
    ```

    

