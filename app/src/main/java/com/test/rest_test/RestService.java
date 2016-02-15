package com.test.rest_test;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by poo on 2/15/2016.
 */
public class RestService
{
    private static String BASE_URL = "http://jsonplaceholder.typicode.com";
    private static String POSTS = "posts";

    private static String SLASH = "/";

    private static String GET = "GET";
    private static String POST = "POST";
    private static String PUT = "PUT";


    public static String getPost(String postId)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String post = null;

        try
        {
            URL url = new URL(BASE_URL + SLASH + POSTS + SLASH + postId);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod(GET);
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null)
            {
                // Nothing to do.
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null)
            {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0)
            {
                // Stream was empty.  No point in parsing.
                return null;
            }
            post = buffer.toString();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (final IOException e)
                {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }
        return post;
    }
}
