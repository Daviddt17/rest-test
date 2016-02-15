package com.test.rest_test;

import android.net.Uri;

/**
 * Created by poo on 2/15/2016.
 */
public class JsonPlaceHolderService {
    private static String BASE_URL = "http://jsonplaceholder.typicode.com";
    private static String POSTS = "posts";
    private static String SLASH = "/";

    public static String getPost(String postId) {
        return RestService.getPost(BASE_URL + SLASH + POSTS + SLASH + postId);
    }

    public static String postPost(String title, String body, String userId) {
        Uri.Builder builder = new Uri.Builder()
                .appendQueryParameter("title", title)
                .appendQueryParameter("body", body)
                .appendQueryParameter("userId", userId);
        String query = builder.build().getEncodedQuery();

        return RestService.postPost(BASE_URL + SLASH + POSTS, query);
    }

    public static String putPost(String postId, String title, String body, String userId)
    {
        Uri.Builder builder = new Uri.Builder()
                .appendQueryParameter("id", postId)
                .appendQueryParameter("title", title)
                .appendQueryParameter("body", body)
                .appendQueryParameter("userId", userId);
        String query = builder.build().getEncodedQuery();

        return RestService.putPost(BASE_URL + SLASH + POSTS + SLASH + postId, query);
    }

    public static String deletePost(String postId)
    {
        return RestService.deletePost(BASE_URL + SLASH + POSTS + SLASH + postId);
    }
}
