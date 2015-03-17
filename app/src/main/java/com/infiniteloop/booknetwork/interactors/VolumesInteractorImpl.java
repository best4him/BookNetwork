package com.infiniteloop.booknetwork.interactors;

import android.content.Context;

import com.infiniteloop.booknetwork.R;
import com.infiniteloop.booknetwork.callBacks.OnVolumesChanged;
import com.infiniteloop.booknetwork.models.ImageLinks;
import com.infiniteloop.booknetwork.models.Volume;
import com.infiniteloop.booknetwork.models.VolumeInfo;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import utils.NetworkUtils;


/**
 * Created by Gherasim on 1/9/2015.
 */
public class VolumesInteractorImpl implements VolumesInteractor {

    ArrayList<Volume> mVolumes;


    private static VolumesInteractorImpl staticInstance;
    public static VolumesInteractorImpl staticInstance(){
        if(staticInstance == null){
            staticInstance = new VolumesInteractorImpl();
        }
        
        return staticInstance;
    }


    @Override
    public void get(Context context, final OnVolumesChanged listener, GetVolumesType type) {

    	switch (type) {
			case GetVolumesType_Default:
				
				break;
			case GetVolumesType_Reload:
				
				mVolumes = null;
				break;
	
		}
    	
    	if(mVolumes != null) {
    		
    		listener.onVolumesChanged(mVolumes);
    		return;
    	}
    	
    	if(!NetworkUtils.isOnline(context)){

    		listener.onVolumesRequestFailed(context.getResources().getString(R.string.no_internet_connection));
            return;
        }

        AsyncHttpClient request = new AsyncHttpClient();

        request.get("https://www.googleapis.com/books/v1/volumes?q=search+terms", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int status, Header[] headers, byte[] bytes) {

                try {
                    JSONObject response = new JSONObject(new String(bytes));

                    JSONArray items = response.getJSONArray("items");

                    for(int i = 0; i < items.length(); i++) {

                        if(mVolumes == null) mVolumes = new ArrayList<Volume>();

//                        ObjectMapper mapper = new ObjectMapper();
//                        Volume volume = mapper.readValue(items.getJSONObject(i).toString(), Volume.class);

                        JSONObject volumeJson = items.getJSONObject(i);
                        Volume volume = new Volume();

                        volume.setKind(volumeJson.optString("kind"));
                        volume.setId(volumeJson.optString("id"));
                        volume.setEtag(volumeJson.optString("etag"));
                        volume.setSelfLink(volumeJson.optString("selfLink"));

                        JSONObject volumeInfoJson = volumeJson.optJSONObject("volumeInfo");

                        VolumeInfo volumeInfo = new VolumeInfo();

                        if(volumeJson != null) {

                            volumeInfo.setTitle(volumeInfoJson.optString("title"));
                            volumeInfo.setSubtitle(volumeInfoJson.optString("subtitle"));
                            JSONArray authorsJson = volumeInfoJson.optJSONArray("authors");
                            if(authorsJson != null) {

                                ArrayList<String> authors = new ArrayList<String>();
                                for(int j = 0; j < authorsJson.length(); j++) {
                                    authors.add(authorsJson.getString(j));
                                }
                                volumeInfo.setAuthors(authors);
                            }


                            volumeInfo.setPublisher(volumeInfoJson.optString("publisher"));
                            volumeInfo.setPublishedDate(volumeInfoJson.optString("publishedDate"));
                            volumeInfo.setDescription(volumeInfoJson.optString("description"));

                            volumeInfo.setRatingsCount(volumeInfoJson.optInt("ratingsCount"));
                            volumeInfo.setAverageRating(volumeInfoJson.optDouble("averageRating"));

                            JSONObject imageLinksJson = volumeInfoJson.optJSONObject("imageLinks");

                            ImageLinks imageLinks = new ImageLinks();

                            if(imageLinksJson != null) {
                                imageLinks.setSmallThumbnail(imageLinksJson.optString("smallThumbnail"));
                                imageLinks.setThumbnail(imageLinksJson.optString("thumbnail"));
                            }

                            volumeInfo.setImageLinks(imageLinks);

                        }

                        volume.setVolumeInfo(volumeInfo);

                        mVolumes.add(volume);

                    }

                    listener.onVolumesChanged(mVolumes);

                } catch (JSONException e) {
                    listener.onVolumesRequestFailed("Json error!");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

                listener.onVolumesRequestFailed("Unknown error!");
            }
        });





//        final ServerRequest eventsRequest = new ServerRequest(ServerRequest.ServerRequestCall.PMServerRequestType_ModelVolumes, context, new ServerRequestHandler() {
//
//			@Override
//			public void onRequestCompleted(JSONObject result) {
//
//				if(result == null) {
//
//					listener.onVolumesRequestFailed("An error occured while getting Volumes");
//					return;
//				}
//
//				JSONObject data = result.optJSONObject("data");
//
//				if(data == null) {
//					listener.onVolumesRequestFailed("An error occured while getting Volumes");
//					return;
//				}
//
//				JSONArray modelVolumes = data.optJSONArray("model_Volumes");
//
//				if(modelVolumes == null) {
//					listener.onVolumesRequestFailed("An error occured while getting Volumes");
//					return;
//				}
//
//				mVolumes = new ArrayList<Volume>();
//
//
//				for(int i = 0; i < modelVolumes.length(); i++) {
//
//					Volume Volume = new Volume();
//
//					try{
//						JSONObject opportunityJson = modelVolumes.getJSONObject(i);
//						opportunity.setName(opportunityJson.getString("ue_name"));
//						opportunity.setAddress(opportunityJson.getString("ue_street_address"));
//						opportunity.setActive(opportunityJson.getString("ue_status").equals("Active"));
//						opportunity.setAddress(opportunityJson.getString("ue_street_address"));
//						Calendar startDate = Calendar.getInstance();
//						startDate.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(opportunityJson.getString("ue_start_date")));
//						opportunity.setStartDate(startDate);
//
//					}catch(JSONException e) {
//						e.printStackTrace();
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//
//					mVolumes.add(opportunity);
//				}
//
//				listener.onVolumesChanged(mVolumes);
//
//			}
//
//
//		});
//
//        eventsRequest.get(false);

    }
}
