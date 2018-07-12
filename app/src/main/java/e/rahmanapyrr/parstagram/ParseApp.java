package e.rahmanapyrr.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import e.rahmanapyrr.parstagram.model.Post;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        final Parse.Configuration configuration = new Parse.Configuration.Builder(this)
                .applicationId("Rahmanapyrr")
                .clientKey("quiero?19")
                .server("http://rahmanapyrr-parse.herokuapp.com/parse")
                .build();

        Parse.initialize(configuration);
    }
}
