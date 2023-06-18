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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.view.View;
import android.graphics.Typeface;
import androidx.browser.*;
import androidx.exifinterface.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class CreditsActivity extends AppCompatActivity {
	
	private String fontName = "";
	private String typeace = "";
	private String pp = "";
	
	private LinearLayout toolbar;
	private LinearLayout bg;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private CircleImageView circleimageview1;
	private LinearLayout linear7;
	private LinearLayout linear16div;
	private TextView c_txt;
	private LinearLayout linear10;
	private LinearLayout div1;
	private TextView u_txt;
	private LinearLayout linear12;
	private LinearLayout div2;
	private TextView textview10;
	private LinearLayout linear14;
	private LinearLayout linear9;
	private TextView textview5;
	private TextView f_txt;
	private TextView textview4;
	private LinearLayout linear13;
	private TextView text;
	private TextView textview7;
	private TextView textview8;
	private LinearLayout linear15;
	private TextView textview12;
	private TextView textview11;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.credits);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		toolbar = (LinearLayout) findViewById(R.id.toolbar);
		bg = (LinearLayout) findViewById(R.id.bg);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear16div = (LinearLayout) findViewById(R.id.linear16div);
		c_txt = (TextView) findViewById(R.id.c_txt);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		div1 = (LinearLayout) findViewById(R.id.div1);
		u_txt = (TextView) findViewById(R.id.u_txt);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		div2 = (LinearLayout) findViewById(R.id.div2);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		textview5 = (TextView) findViewById(R.id.textview5);
		f_txt = (TextView) findViewById(R.id.f_txt);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		text = (TextView) findViewById(R.id.text);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview11 = (TextView) findViewById(R.id.textview11);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pp = "https://t.me/fprojects_tech";
				androidx.browser.customtabs.CustomTabColorSchemeParams defaultColors = new androidx.browser.customtabs.CustomTabColorSchemeParams.Builder()
				    .setToolbarColor(androidx.core.content.ContextCompat.getColor(_view.getContext(), R.color.colorPrimary))
				    .setSecondaryToolbarColor(androidx.core.content.ContextCompat.getColor(_view.getContext(), R.color.colorPrimaryDark))
				    .build();
				androidx.browser.customtabs.CustomTabsIntent.Builder customTabsBuilder = new androidx.browser.customtabs.CustomTabsIntent.Builder();
				customTabsBuilder.setDefaultColorSchemeParams(defaultColors);
				customTabsBuilder.build().launchUrl(_view.getContext(), Uri.parse(pp));
			}
		});
	}
	
	private void initializeLogic() {
		_changeActivityFont("opensans_semibold");
		
		getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
		
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
		c_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
		f_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
		u_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
		text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _changeActivityFont (final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
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