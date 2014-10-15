package cn.edu.gdmec.s07131040.contextmenudemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;
    TextView myTv;
    EditText myEt;

    @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	myEt.setText("你点击了菜单"+item.getTitle()+"  ");
    	switch (item.getItemId()) {
		case CONTEXT_MENU_1:
			myTv.setText("你选择了第一个自选项");
			break;
		case CONTEXT_MENU_2:
			myTv.setText("你选择了第二个自选项");
			break;
		case CONTEXT_MENU_3:
			myTv.setText("你选择了第三个自选项");
			break;
		}

		return super.onContextItemSelected(item);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		menu.setHeaderTitle("快捷菜单标题 ");
	    menu.add(0,CONTEXT_MENU_1,0,"快捷菜单项1");
	    menu.add(0,CONTEXT_MENU_2,1,"快捷菜单项2");
	    menu.add(0,CONTEXT_MENU_3,2,"快捷菜单项3");

		super.onCreateContextMenu(menu, v, menuInfo);
	}


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTv=(TextView)findViewById(R.id.textView1);
        myEt=(EditText) findViewById(R.id.editText1);
        registerForContextMenu(myTv);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
