package com.example.pers;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class EditIngrediens extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ingrediens);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_ingrediens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void spara(View view) {
        EditText et1 = (EditText)findViewById(R.id.editText1);
        String ingred = et1.getText().toString();
        if(ingred.length() == 0) {
            TextView tv1 = (TextView)findViewById(R.id.textView1);
            tv1.setText("Ingrediens saknas");
            Toast t = Toast.makeText(this, "Ingrediens saknas", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        EditText et2 = (EditText)findViewById(R.id.editText2);
        String amount = et2.getText().toString();
        EditText et3 = (EditText)findViewById(R.id.editText3);
        String unit = et3.getText().toString();

        Intent data = new Intent();
        data.putExtra(MainActivity.INGREDIENS, ingred);
        data.putExtra(MainActivity.AMOUNT, amount);
        data.putExtra(MainActivity.UNIT, unit);

        setResult(RESULT_OK,data);
        finish();
    }

    public void delete(View view) {

    }

}
