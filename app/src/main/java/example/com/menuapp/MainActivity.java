package example.com.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String contacts[]={"Sam","Tom","Den","Christie","Nichol"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.File:
                Toast.makeText(getApplicationContext(), "File Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Edit:
                Toast.makeText(getApplicationContext(), "Edit Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.View:
                Toast.makeText(getApplicationContext(), "View Menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

      @Override
     public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
      {
          super.onCreateContextMenu(menu, v, menuInfo);
          MenuInflater inflater = getMenuInflater();
          inflater.inflate(R.menu.context_menu, menu);
          menu.setHeaderTitle("Context Menu");
            menu.add(Menu.NONE,Menu.NONE,1,"watsapp");
          menu.add(Menu.NONE,Menu.NONE,0,"watsappcall");
      }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.call){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sms){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}
