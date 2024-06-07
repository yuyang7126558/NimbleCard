package com.example.nimblecarddemo.arch;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nimblecarddemo.R;
import com.example.nimblecarddemo.arch.model.TakoMixFeed;

public class ViewHolderT extends RecyclerView.ViewHolder {

    TextView tv_title;
    ImageView img;
    LinearLayout ll_item, ll_hidden;

    public ViewHolderT(View itemView) {
        super(itemView);
        tv_title = itemView.findViewById(R.id.tv_title);
        img = itemView.findViewById(R.id.img);

        ll_item = itemView.findViewById(R.id.ll_item);
        ll_hidden = itemView.findViewById(R.id.ll_hidden);
    }

    public void bindData(TakoMixFeed data) {
        tv_title.setText(data.getText());
        img.setImageResource(data.getImage());
    }
}