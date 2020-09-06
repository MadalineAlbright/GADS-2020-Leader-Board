package com.ngonyoku.leaderboard;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Utilities {
    public static class Images {
        public static void loadImage(ImageView imageView, String imageUrl) {
            Picasso
                    .get()
                    .load(imageUrl)
                    .fit()
                    .placeholder(R.color.colorAccent)
                    .into(imageView)
            ;
        }
    }
}
