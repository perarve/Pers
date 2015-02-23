package com.example.pers;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener{
	public static final String INGREDIENS = "ingred";
	public static final String AMOUNT = "amount";
	public static final String UNIT = "unit";
	
	ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayList<String> ingredList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ingredList);
		ListView lv1 = (ListView)findViewById(R.id.listView1);
		lv1.setAdapter(adapter);
		lv1.setOnItemClickListener(this);
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
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void addIngrediens(View view) {
		Intent intent = new Intent(this, IngrediensAdder.class);
		startActivityForResult(intent,1);		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			String ingred = data.getStringExtra(INGREDIENS);
			String amount = data.getStringExtra(AMOUNT);
			String unit = data.getStringExtra(UNIT);
			
			String samman = ingred + " " + amount + " " +unit;
			adapter.add(samman);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String text = ((TextView)view).getText().toString();
		Toast.makeText(this,"YOU clicked " + text, Toast.LENGTH_LONG).show();
		
	}
}










