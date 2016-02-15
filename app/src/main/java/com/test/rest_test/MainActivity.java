package com.test.rest_test;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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

    public void getPost(View view)
    {
        new AsyncTask<Void, Void, Void>()
        {
            private String text;

            @Override
            protected Void doInBackground(Void... params)
            {
                text = JsonPlaceHolderService.getPost("1");
                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                TextView textView = (TextView) findViewById(R.id.get_text_view);

                if(text != null)
                {
                    textView.setText(text);
                }
                else
                {
                    textView.setText("Post was null!");
                }
            }
        }.execute();
    }

    public void postPost(View view)
    {
        new AsyncTask<Void, Void, Void>()
        {
            private String resultText;

            @Override
            protected Void doInBackground(Void... params)
            {
                resultText = JsonPlaceHolderService.postPost("test title", "this is a post", "1");
                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                TextView textView = (TextView) findViewById(R.id.post_text_view);

                if(resultText != null)
                {
                    textView.setText(resultText);
                }
                else
                {
                    textView.setText("Post was null!");
                }
            }
        }.execute();
    }

    public void putPost(View view)
    {
        new AsyncTask<Void, Void, Void>()
        {
            private String resultText;

            @Override
            protected Void doInBackground(Void... params)
            {
                resultText = JsonPlaceHolderService.putPost("1",
                        "test title 2",
                        "this is a post 2",
                        "1");
                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                TextView textView = (TextView) findViewById(R.id.put_text_view);

                if(resultText != null)
                {
                    textView.setText(resultText);
                }
                else
                {
                    textView.setText("Post was null!");
                }
            }
        }.execute();
    }

    public void deletePost(View view)
    {
        new AsyncTask<Void, Void, Void>()
        {
            private String resultText;

            @Override
            protected Void doInBackground(Void... params)
            {
                resultText = JsonPlaceHolderService.deletePost("1");
                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                TextView textView = (TextView) findViewById(R.id.delete_text_view);

                if(resultText != null)
                {
                    textView.setText(resultText);
                }
                else
                {
                    textView.setText("Post was null!");
                }
            }
        }.execute();
    }
}
