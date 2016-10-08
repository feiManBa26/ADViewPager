# ADViewPager 本文重点介绍了自定义ViewPager，在以后的项目中进行快速开发，避免了写很多繁琐的代码，使得维护起来更便利。
效果图:
![image](https://github.com/GitPhoenix/ADViewPager/blob/master/screen/screen.gif)

1.在布局文件中加入ADViewPager
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.github.phoenix.activitiy.MainActivity">

    <com.github.phoenix.widget.ADViewPager
        android:id="@+id/viewPager_main_ad"
        android:layout_width="match_parent"
        android:layout_alignParentTop="true"
        android:layout_height="180dp"/>

</RelativeLayout>

2.待轮播图路径请求成功时，根据需求在代码中设置参数
viewPager.setIndicatorDrawableChecked(R.drawable.shape_dot_checked) //当前指示点
                .setIndicatorDrawableUnchecked(R.drawable.shape_dot_unchecked) //非当前指示点
                .setAutoPlay(true) //是否开启自动轮播
                .setDisplayIndicator(true) //是否显示指示器
                .setIndicatorGravity(Gravity.CENTER) //指示器位置
                .setImageUri(imageUrls)  //图片路径
                .setBannerHref(imageHref)  //点击图片跳转的路径
                .setTargetActivity(BaseWebActivity.class)  //点击图片跳转的webView页面
                .startPlay();
                
当轮播图资源路径为空时设置默认显示的图片，只需设置ADViewPager的背景图即可
<com.github.phoenix.widget.ADViewPager
        android:id="@+id/viewPager_main_ad"
        android:layout_width="match_parent"
        android:layout_alignParentTop="true"
        android:background="@mipmap/ic_launcher"
        android:layout_height="180dp"/>
