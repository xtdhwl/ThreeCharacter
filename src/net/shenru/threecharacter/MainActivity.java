package net.shenru.threecharacter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView mLogoView;
	private boolean mLayouFlag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLogoView = (ImageView) findViewById(R.id.logo);

		mLogoView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				if (!mLayouFlag) {
					mLayouFlag = true;
					startAnimation();
				}
			}
		});
		mLogoView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startAboutActivity();
			}
		});
	}

	// 开始动画
	private void startAnimation() {
		TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -100, Animation.RELATIVE_TO_SELF, 0);
		animation.setDuration(2000);
		mLogoView.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				startPlayActivity();
			}
		});
	}

	private void startAboutActivity() {
		Intent it = new Intent(this, AboutActivity.class);
		startActivity(it);
	}

	private void startPlayActivity() {
		Intent it = new Intent(this, PlayActivity.class);
		startActivity(it);
	}
}
