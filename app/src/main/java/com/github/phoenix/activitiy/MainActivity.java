package com.github.phoenix.activitiy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.github.phoenix.R;
import com.github.phoenix.base.BaseWebActivity;
import com.github.phoenix.widget.ADViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String[] imageUrls = {"http://img13.360buyimg.com/n8/jfs/t2494/199/2974963318/623734/7b6fe7e5/572c1618N7ee89e63.jpg",
            "http://img13.360buyimg.com/n8/jfs/t2827/183/199606439/285948/d507257d/5707b5f3N0df2f00b.jpg",
            "http://img12.360buyimg.com/n7/jfs/t1255/168/901893672/288658/677b172c/555c00d6N0d7c93c4.jpg",
            "http://img11.360buyimg.com/n8/jfs/t2773/14/1006959733/136923/a687b77d/5731878cNd2855d6f.jpg",
            "http://img13.360buyimg.com/cms/s190x190_jfs/t2581/258/2147586971/249027/5b84a329/5757fc91Nd8bcb260.jpg"};

    private String[] imageHref = {"http://voice.hupu.com/nba/2075428.html"};

    @BindView(R.id.viewPager_main_ad)
    ADViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSubView();
    }

    private void setSubView() {
        viewPager.setIndicatorDrawableChecked(R.drawable.shape_dot_checked) //当前指示点
                .setIndicatorDrawableUnchecked(R.drawable.shape_dot_unchecked) //非当前指示点
                .setAutoPlay(true) //是否开启自动轮播
                .setDisplayIndicator(true) //是否显示指示器
                .setIndicatorGravity(Gravity.CENTER) //指示器位置
                .setImageUri(imageUrls)  //图片路径
                .setBannerHref(imageHref)  //点击图片跳转的路径
                .setTargetActivity(BaseWebActivity.class)  //点击图片跳转的webView页面
                .startPlay();

//        new GetBannerListTask().execute("");
    }

    /**
     * 异步任务,获取数据
     */
    class GetBannerListTask extends AsyncTask<String, Integer, Boolean> {
        String[] imageHref;
        String[] imageUrls;

        @Override
        protected Boolean doInBackground(String... params) {
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if (result) {
                viewPager.setIndicatorDrawableChecked(R.drawable.shape_dot_checked)
                        .setIndicatorDrawableUnchecked(R.drawable.shape_dot_unchecked)
                        .setAutoPlay(true)
                        .setDisplayIndicator(true)
                        .setIndicatorGravity(Gravity.CENTER)
                        .setImageUri(imageUrls)
                        .setBannerHref(imageHref)
                        .setTargetActivity(BaseWebActivity.class)
                        .startPlay();
            }
        }
    }
}
