package com.fprojects.googlemap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Button;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Timer;
import java.util.TimerTask;
import androidx.browser.*;
import androidx.exifinterface.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> map = new HashMap<>();
	private double id = 0;
	private double num1 = 0;
	private double num = 0;
	private HashMap<String, Object> mapVar = new HashMap<>();
	private HashMap<String, Object> neww = new HashMap<>();
	private boolean isSeeMore = false;
	
	private ArrayList<HashMap<String, Object>> savemap = new ArrayList<>();
	private ArrayList<String> project = new ArrayList<>();
	private ArrayList<String> newProject = new ArrayList<>();
	
	private LinearLayout bg;
	private LinearLayout linear_head;
	private LinearLayout linear_title;
	private EditText edittext2;
	private EditText edittext1;
	private TextView textview1;
	private LinearLayout linear_bot;
	private ImageView logo;
	private TextView splash_title;
	private ProgressBar progressbar1;
	private LinearLayout linear_button;
	private Button button_next;
	
	private Intent i = new Intent();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = (LinearLayout) findViewById(R.id.bg);
		linear_head = (LinearLayout) findViewById(R.id.linear_head);
		linear_title = (LinearLayout) findViewById(R.id.linear_title);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear_bot = (LinearLayout) findViewById(R.id.linear_bot);
		logo = (ImageView) findViewById(R.id.logo);
		splash_title = (TextView) findViewById(R.id.splash_title);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear_button = (LinearLayout) findViewById(R.id.linear_button);
		button_next = (Button) findViewById(R.id.button_next);
	}
	
	private void initializeLogic() {
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						i.setClass(getApplicationContext(), LoginActivity.class);
						startActivity(i);
					}
				});
			}
		};
		_timer.schedule(t, (int)(2000));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}