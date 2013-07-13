package com.beewhy.SleepyPassenger;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.beewhy.SleepyPassenger.model.Route;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Spinner;

public class MyActivity extends Activity {
	
	private String routeId;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadRoutesTask().execute();
        } else {
        	//no network
        }
        Spinner spinner_route = (Spinner) findViewById(R.id.spinner_route);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
        //here add settings button to the actionbar
    }
    
    private class DownloadRoutesTask extends AsyncTask<Void, Void, Route[]> {
    	private Route[] routes;
    	
    	private Route[] downloadUrl(String url_str)
    	{
    		try {
    			URL url = new URL(url_str);
    			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    			try {
    				InputStream in = new BufferedInputStream(urlConnection.getInputStream());
    				//readStream(in);
    				finally {
    					urlConnection.disconnect();
    				}
    			}
    		} catch (MalformedURLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		return routes;
    	}
    	
        @Override
        protected Route[] doInBackground(Void... params) {
              
            // params comes from the execute() call: params[0] is the url.
            try {
                return []; //downloadUrl("http://transicast.appspot.com/ws/V1/routes?agency=CTA&appid=sample522are2");
            } catch (IOException e) {
                return []; // "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(Route[] result) {
        	
        }

    }
}
