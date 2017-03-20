package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import java.io.*;
import org.apache.commons.io.FileUtils;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final TextView textview = (TextView) findViewById(R.id.textView);
		
		final File current = new File("/sdcard/Android/data/org.xbmc.kodi/files/.kodi/userdata/playercorefactory.xml");
		
		final File master = new File("/sdcard/AppProjects/kodicast/app/playercorefactory.xml");
		
		if(current.exists()){
			textview.setText("LocalCast");
		}else{
			textview.setText("Kodi");
		}

		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
					if(current.exists()) {
						current.delete();
						textview.setText("Kodi");
					}else {
					try
					{
						FileUtils.copyFile(master, current);
					}
					catch (IOException e)
					{Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_LONG).show();}
					textview.setText("LocalCast");
					}
				}
		});
		
    }
}

