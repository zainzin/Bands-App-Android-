package com.example.lister;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String [] arr = {"Metallica","Megadeth","Trivium","Machine head","Black Label Society"};
		ArrayAdapter<String> arrList = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,arr);
		ListView l = (ListView) findViewById(R.id.listView);
		
		l.setAdapter(arrList);
		
		l.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast t = Toast.makeText(getApplicationContext(), "You clicked on " + arr[position], Toast.LENGTH_LONG);
				t.setGravity(Gravity.TOP | Gravity.END, 0, 0);
				t.show();
				ImageView imageBand = (ImageView) findViewById(R.id.image_view);
				switch (position) {
				case 0:
					imageBand.setBackgroundResource(R.drawable.a);
					break;
				case 1:
					imageBand.setBackgroundResource(R.drawable.b);
					break;
				case 2:
					imageBand.setBackgroundResource(R.drawable.c);
					break;
				case 3:
					imageBand.setBackgroundResource(R.drawable.d);
					break;
				case 4:
					imageBand.setBackgroundResource(R.drawable.e);
				default:
					break;
				}
				
			}
			
			
			
		});
		
		
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			Toast t = Toast.makeText(getApplicationContext(), "Landscape", Toast.LENGTH_LONG);
			t.setGravity(Gravity.TOP, 0, 0);
			t.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.exit_app){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
}
