package com.vikas.dtu.safetyfirst2.mNewsActivity.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vikas.dtu.safetyfirst2.R;
import com.vikas.dtu.safetyfirst2.mData.News;
import com.vikas.dtu.safetyfirst2.mNewsActivity.fragment.NewsListFragment;
import com.vikas.dtu.safetyfirst2.mPicasso.PicassoClient;


public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView titleView;
    public TextView bodyView;
    public ImageView mNewsImage;
    NewsListFragment.OnItemClickListener listener;

    public NewsViewHolder(View itemView,NewsListFragment.OnItemClickListener listener) {
        super(itemView);
        this.listener=listener;
        titleView = (TextView) itemView.findViewById(R.id.post_title);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);


        mNewsImage = (ImageView) itemView.findViewById(R.id.card_image);
        itemView.setOnClickListener(this);
    }

    public void bindToNews(News news,
                          // View.OnClickListener starClickListener, View.OnClickListener shareClickListener,
                            Context c) {
        titleView.setText(news.title);
        bodyView.setText(news.body);
//        share.setOnClickListener(shareClickListener);
        if(news.imgUrl!=null){
            PicassoClient.downloadImage(c, news.imgUrl, mNewsImage);
            mNewsImage.setVisibility(View.VISIBLE);
        }
        else{
            mNewsImage.setVisibility(View.GONE);

        }
//
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(view,getLayoutPosition());
    }
}
