import org.json.*;
import com.loopj.android.http.*;
import org.apache.http.Header;
class TwitterRestClientUsage {
    public void getPublicTimeline() {
        TwitterRestClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray timeline, Header[] headers) {
                try {
                    JSONObject firstEvent = (JSONObject)timeline.get(0);
                    String tweetText = firstEvent.getString("text");

                    // Do something with the response
                    System.out.println(tweetText);
                } catch(JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}