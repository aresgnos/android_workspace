package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SplashScreen;

import kr.or.dshrd.splash_screen.Common.OnBoarding;

public class MainActivity extends AppCompatActivity {

    // 이 페이지 안에서만 사용하는 변수
    private  static  int SPLASH_SCREEN =5000;

    // 애니변수 지정
    Animation topanim, bottomanim;
    ImageView image;
    TextView ttitle, ttitle2;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 상단 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main); // activity 화면을 보여주는 명령

        // 변수에 애니메이션 설정하기
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // hooks (연결)
        image = findViewById(R.id.imageview);
        ttitle = findViewById(R.id.title1);
        ttitle2 = findViewById(R.id.title2);

        // 이미지와 텍스트에 애니메이션 연결
        image.setAnimation(topanim);
        ttitle.setAnimation(bottomanim);
        ttitle2.setAnimation(bottomanim);

        // 다음페이지 넘길 Splash 적용
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

                if(isFirstTime) {

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();


                    // intent = 화면을 전환하는 단위
                    Intent intent = new Intent(MainActivity.this, OnBoarding.class);
                    startActivity(intent);
                    finish();

                }
                else{
                    Intent intent = new Intent(MainActivity.this, Main_page.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_SCREEN);

    }
}