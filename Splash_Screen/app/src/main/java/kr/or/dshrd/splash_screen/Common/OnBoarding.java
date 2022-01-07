package kr.or.dshrd.splash_screen.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.or.dshrd.splash_screen.HelperClass.SliderAdapter;
import kr.or.dshrd.splash_screen.Main_page;
import kr.or.dshrd.splash_screen.R;

public class OnBoarding extends AppCompatActivity {

    // 변수 선언
    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;

    Button letsGetStarted;

    Animation animation;

    int currentPos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);

        // Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        // Call Adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);

    }

    public void skip(View view){

        startActivity(new Intent(this, Main_page.class));
        finish();

    }
    public void next(View view){

        viewPager.setCurrentItem(currentPos + 1);

    }


    // dots
    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);

        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.design_default_color_secondary));
        }

    }

    // 하단 버튼 (OnBoarding의 마지막 화면에서 버튼 출력) 처리 및 dot색깔 바꾸기
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);

            currentPos = position;



            //  하단 버튼 표시 여부
            if (position == 0){
                letsGetStarted.setVisibility(viewPager.INVISIBLE);
            }
            else if (position == 1){
                letsGetStarted.setVisibility(viewPager.INVISIBLE);
            }
            else if (position == 2){
                letsGetStarted.setVisibility(viewPager.INVISIBLE);
            }
            else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.button_anim);
                letsGetStarted.setAnimation(animation);

                letsGetStarted.setVisibility(viewPager.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}


