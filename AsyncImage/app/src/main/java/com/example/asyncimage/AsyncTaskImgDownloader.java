package com.example.asyncimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskImgDownloader extends AsyncTask<String, Integer, Bitmap> {

    public static final String ASYNCTASKIMAGEDOWNLOAD = "ASYNCTASKIMAGEDOWNLOAD";
    private Activity myActivity;
    public static final int LOADING = 0;
    public static final int LOADED = 1;


    public AsyncTaskImgDownloader(Activity mainActivity) {
        this.myActivity = mainActivity;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Log.i(ASYNCTASKIMAGEDOWNLOAD, "In doInBackGround...");
        publishProgress(LOADING);
        try {
            Log.i(ASYNCTASKIMAGEDOWNLOAD,strings[0]);

            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            Log.i(ASYNCTASKIMAGEDOWNLOAD, "After open Connection");
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "con " +  con);

            if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
                Log.i(ASYNCTASKIMAGEDOWNLOAD, "Response code " + con.getResponseCode());
                Log.i(ASYNCTASKIMAGEDOWNLOAD, "Failed to connect");
                throw new Exception("Failed to connect");
            } else {
                Log.i(ASYNCTASKIMAGEDOWNLOAD, "con ok");
            }

            InputStream is = con.getInputStream();
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "After input stream");
            publishProgress(LOADED);
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "After publish progress");

            Bitmap bitmap = BitmapFactory.decodeStream(is);
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "After factory");
            is.close();
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "After close");
            if (bitmap == null){
                Log.i(ASYNCTASKIMAGEDOWNLOAD, "doInBackground bitmap null");
            }
            return bitmap;
        } catch (Exception e) {
            Log.e(ASYNCTASKIMAGEDOWNLOAD, "Failed to load image", e);
            Log.e(ASYNCTASKIMAGEDOWNLOAD, e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.i(ASYNCTASKIMAGEDOWNLOAD, "In onPostExecute...");
        ImageView iv = (ImageView) myActivity.findViewById(R.id.imageView);
        Log.i(ASYNCTASKIMAGEDOWNLOAD, "After findViewById...");
        if (iv == null){
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "iv null " + iv);
        }
        if (bitmap == null){
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "bitmap null " + bitmap);
        }
        if (iv != null && bitmap != null) {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "Bitmap found");
            iv.setImageBitmap(bitmap);
        } else {
            Log.i(ASYNCTASKIMAGEDOWNLOAD, "Problem with bitmap");
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        TextView tv = myActivity.findViewById(R.id.textView);
        if (values[0] == LOADING) {
            tv.setText("Loading...");
        } else {
            tv.setText("This is a random image!");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}
