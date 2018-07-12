package e.rahmanapyrr.parstagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;



import e.rahmanapyrr.parstagram.R;
//import e.rahmanapyrr.parstagram.model.MyApp
import e.rahmanapyrr.parstagram.model.GlideApp;
import e.rahmanapyrr.parstagram.model.Post;

public class InstaAdapter extends RecyclerView.Adapter<InstaAdapter.ViewHolder> {

    private List<Post> Posts;
    Context context;
    public InstaAdapter(List<Post> posts){ Posts = posts; }

    @Override
    public InstaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_post, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InstaAdapter.ViewHolder holder, int position) {
        // get data
        Post post = Posts.get(position);

        //holder.createdAt.setText(getRelativeTimeAgo(tweet.createdAt));


        GlideApp.with(context)
                .load(post.getImage().getUrl())
                .into(holder.Picture);
        // populate


    }

    @Override
    public int getItemCount() {
        return Posts.size();
    }

    public String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView Picture;


        public ViewHolder(View itemView){
            super(itemView);

            Picture = (ImageView)itemView.findViewById(R.id.insta_pic);
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        Posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        Posts.addAll(list);
        notifyDataSetChanged();
    }

}

