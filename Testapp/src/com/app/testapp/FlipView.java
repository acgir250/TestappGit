package com.app.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class FlipView extends Activity {

	private ViewFlipper flipview_flipper = null;
	private float lastx;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flip_view);
		intializingComponents();
	}

	private void intializingComponents() {
		try {
			flipview_flipper = (ViewFlipper) findViewById(R.id.view_flipper);

		} catch (Exception e) {
			Log.e("<<Error Handling>>", e.toString());
		}
	}

	public boolean onTouchEvent(MotionEvent touchevent) {
		switch (touchevent.getAction()) {
		case MotionEvent.ACTION_DOWN:
			lastx = touchevent.getX();
			break;
		case MotionEvent.ACTION_UP:
			float currentX = touchevent.getX();
			if (lastx < currentX) {
				if (flipview_flipper.getDisplayedChild() == 0)
					break;
				flipview_flipper.setInAnimation(this, R.anim.in_from_left);
				flipview_flipper.setOutAnimation(this, R.anim.out_to_right);
				// Show the next Screen
				flipview_flipper.showNext();

			}
			if (lastx > currentX) {
				if (flipview_flipper.getDisplayedChild() == 1)
					break;
				flipview_flipper.setInAnimation(this, R.anim.in_from_left);
				flipview_flipper.setOutAnimation(this, R.anim.out_to_right);
				//Show the previous screen
				flipview_flipper.showPrevious();
			}
			break;
		}
		return false;
	}

}
