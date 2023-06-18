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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.textfield.*;
import android.widget.EditText;
import android.view.View;
import android.graphics.Typeface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.browser.*;
import androidx.exifinterface.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ViewdActivity extends AppCompatActivity {
	
	private double id = 0;
	private HashMap<String, Object> map = new HashMap<>();
	
	private LinearLayout toolbar;
	private LinearLayout background;
	private LinearLayout linear4;
	private LinearLayout div;
	private ImageView ic_cancel;
	private TextView textview1;
	private ImageView ic_delete;
	private ImageView ic_save;
	private ImageView ic_share;
	private LinearLayout linear5;
	private LinearLayout ebg;
	private TextView txt_time;
	private TextView textview2;
	private TextInputLayout textinputlayout1;
	private EditText edittext1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.viewd);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		toolbar = (LinearLayout) findViewById(R.id.toolbar);
		background = (LinearLayout) findViewById(R.id.background);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		div = (LinearLayout) findViewById(R.id.div);
		ic_cancel = (ImageView) findViewById(R.id.ic_cancel);
		textview1 = (TextView) findViewById(R.id.textview1);
		ic_delete = (ImageView) findViewById(R.id.ic_delete);
		ic_save = (ImageView) findViewById(R.id.ic_save);
		ic_share = (ImageView) findViewById(R.id.ic_share);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		ebg = (LinearLayout) findViewById(R.id.ebg);
		txt_time = (TextView) findViewById(R.id.txt_time);
		textview2 = (TextView) findViewById(R.id.textview2);
		textinputlayout1 = (TextInputLayout) findViewById(R.id.textinputlayout1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		
		ic_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		ic_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/GoogleMap/Saved Locations/".concat(String.valueOf((long)(id)))));
				finish();
			}
		});
		
		ic_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map.put("name", edittext1.getText().toString());
				map.put("time", txt_time.getText().toString());
				map.put("ll", textview2.getText().toString());
				FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/GoogleMap/Saved Locations/".concat(String.valueOf((long)(id)).concat("/".concat("project.json")))), new Gson().toJson(map));
				map.clear();
			}
		});
		
		ic_share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Currently Working On ");
			}
		});
	}
	
	private void initializeLogic() {
		
		
		
		
		getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
		
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
		_setToolTip(ic_cancel, "CANCEL");
		_setToolTip(ic_delete, "DELETE");
		_setToolTip(ic_save, "SAVE");
		_setToolTip(ic_share, "SHARE");
		textview2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)16, 0xFFF5F5F5));
		id = Double.parseDouble(getIntent().getStringExtra("id"));
		_loaddata();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _setToolTip (final View _view, final String _text) {
		 _view.setTooltipText(_text);
		
		/*
androidx.appcombat.widget.TooltipCompat.setTooltipText(_view, _text); 
*/
	}
	
	
	public void _loaddata () {
		map = new Gson().fromJson(FileUtil.readFile(FileUtil.getExternalStorageDir().concat("/GoogleMap/Saved Locations/".concat(String.valueOf((long)(id)).concat("/".concat("project.json"))))), new TypeToken<HashMap<String, Object>>(){}.getType());
		edittext1.setText(map.get("name").toString());
		textview2.setText(map.get("ll").toString());
		txt_time.setText(map.get("time").toString());
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