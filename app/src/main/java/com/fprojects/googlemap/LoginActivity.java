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
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import androidx.browser.*;
import androidx.exifinterface.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class LoginActivity extends AppCompatActivity {
	
	private double num = 0;
	
	private ArrayList<String> string = new ArrayList<>();
	private ArrayList<String> count = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout container;
	private TextView textview3;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear9;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear6;
	private Spinner spinner1;
	private EditText edittext1;
	private LinearLayout linear10;
	private Button button1;
	
	private Intent i = new Intent();
	private SharedPreferences sh_num;
	private SharedPreferences sh;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		container = (LinearLayout) findViewById(R.id.container);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		button1 = (Button) findViewById(R.id.button1);
		sh_num = getSharedPreferences("sh_num", Activity.MODE_PRIVATE);
		sh = getSharedPreferences("sh", Activity.MODE_PRIVATE);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (string.get((int)(_position)).equals("مصر")) {
					edittext1.setHint("+20");
				}
				else {
					if (string.get((int)(_position)).equals("سوريا")) {
						edittext1.setHint("+263");
					}
					else {
						if (string.get((int)(_position)).equals("العراق")) {
							edittext1.setHint("+964");
						}
						else {
							if (string.get((int)(_position)).equals("اليمن")) {
								edittext1.setHint("+967");
							}
							else {
								if (string.get((int)(_position)).equals("الكويت ")) {
									edittext1.setHint("+965");
								}
								else {
									if (string.get((int)(_position)).equals("السعوديه")) {
										edittext1.setHint("+966");
									}
									else {
										if (string.get((int)(_position)).equals("قطر")) {
											edittext1.setHint("+974");
										}
										else {
											
										}
									}
								}
							}
						}
					}
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				sh.edit().putString("save_number", _charSeq).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.edit().putString("save_number_user", edittext1.getText().toString()).commit();
				sh.edit().putString("one_page_number", "a").commit();
				i.putExtra("key_save_put", edittext1.getText().toString());
				if (!edittext1.getText().toString().equals("")) {
					i.setClass(getApplicationContext(), MapsActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "الرجاء ادخال رقم الهاتف ");
				}
			}
		});
	}
	
	private void initializeLogic() {
		edittext1.setText(sh.getString("save_number", ""));
		if (sh.getString("one_page_number", "").equals("a")) {
			i.setClass(getApplicationContext(), MapsActivity.class);
			startActivity(i);
		}
		_radius_to(button1, 250, 2, "#1E1E1E");
		_county();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _radius_to (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
	
	public void _county () {
		string.add("رمز الدوله");
		string.add("مصر");
		string.add("سوريا");
		string.add("العراق");
		string.add("اليمن");
		string.add("الكويت ");
		string.add("السعوديه ");
		string.add("قطر");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, string));
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