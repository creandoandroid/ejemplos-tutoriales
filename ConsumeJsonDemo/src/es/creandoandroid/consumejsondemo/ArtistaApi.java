package es.creandoandroid.consumejsondemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class ArtistaApi {

	Context c;
	public ArtistaApi(Context c){
		this.c = c;
	}

	@SuppressWarnings("finally")
	public Artista buscarArtista(final String nombreArtista){
		FutureTask<Artista> future = 
				new FutureTask<Artista>(
						new Callable<Artista>() {
							@Override
							public Artista call() throws Exception {
								Artista artista = null;

								String respStr = requestGET("http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist="+nombreArtista+"&api_key=74915715bead533968da6f59b2b54a65&format=json");

								JSONObject respJSON = new JSONObject(respStr);								
								try {
									JSONObject artist = respJSON.getJSONObject("artist");

									String nombre = artist.getString("name");
									String descripcion = artist.getJSONObject("bio").getString("content");
									artista = new Artista(nombre, descripcion);


								} catch (JSONException e) {
									e.printStackTrace();
								}
								return artista;
							}
						});
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(future);
		Artista artista = new Artista();

		try {
			artista = future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
			return  artista;
		}
	}

	public static String requestGET(String url){

		String respStr="";

		HttpClient httpClient = new DefaultHttpClient();

		HttpGet get = new HttpGet(url);

		get.setHeader("content-type", "application/json");

		try {
			HttpResponse resp = httpClient.execute(get);
			respStr = EntityUtils.toString(resp.getEntity());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return respStr;

	}


}
