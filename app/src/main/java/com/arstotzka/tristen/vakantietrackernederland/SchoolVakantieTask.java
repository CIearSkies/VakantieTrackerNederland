package com.arstotzka.tristen.vakantietrackernederland;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by Tristen on 4-6-2017.
 */

public class SchoolVakantieTask extends AsyncTask<String, Void, String>{

    private VakantieTaskListener listener;

    public SchoolVakantieTask(VakantieTaskListener listener){this.listener = listener;}

    @Override
    protected String doInBackground(String... params) {
        InputStream inputStream = null;
        BufferedReader reader = null;
        String urlString = "";
        String response = "";

        try {
            URL url = new URL(params[0]);
            URLConnection connection = url.openConnection();

            reader = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            response = reader.readLine().toString();
            String line;
            while ((line = reader.readLine()) != null) {
                response += line;
            }
        } catch (MalformedURLException e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } catch (IOException e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } catch (Exception e) {
            Log.e("TAG", e.getLocalizedMessage());
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e("TAG", e.getLocalizedMessage());
                    return null;
                }
            }
        }
        return response;
    }

    protected void onProgressUpdate(Integer... progress){Log.i(TAG,progress.toString());}

    protected void onPostExecute(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray vakanties = jsonObject.getJSONArray("content").getJSONObject(0).getJSONArray("vacations");
            for(int idx = 0; idx < vakanties.length(); idx ++){
                String name = vakanties.getJSONObject(idx).getString("type");

                Boolean compulsory = Boolean.getBoolean(vakanties.getJSONObject(idx).getString("compulsorydates"));

                JSONArray regions = vakanties.getJSONObject(idx).getJSONArray("regions");

                ArrayList<Tijdvak> tijdVakken = new ArrayList<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

                try {
                    for(int i = 0; i <regions.length(); i++){
                        String regio = regions.getJSONObject(i).getString("region");
                        Date startdate = dateFormat.parse(regions.getJSONObject(i).getString("startdate"));
                        Date enddate = dateFormat.parse(regions.getJSONObject(i).getString("enddate"));

                        Tijdvak tv = new Tijdvak(regio, startdate, enddate);

                        tijdVakken.add(tv);
                    }
                }catch (ParseException ex){
                    Log.e(TAG, ex.getLocalizedMessage());
                }
                this.listener.onVakantieItemAvailable(new VakantieItem(name, compulsory, tijdVakken));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
