package com.example.nimblecarddemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nimblecarddemo.arch.NimbleCard;
import com.example.nimblecarddemo.arch.ViewHolderT;
import com.example.nimblecarddemo.arch.model.TakoMixFeed;
import java.util.List;

/**
 * create by colin.yu
 */

public class NimbleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TakoMixFeed> datas;
    private Context mContext;
    private LayoutInflater mLiLayoutInflater;

    public NimbleAdapter(List<TakoMixFeed> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
        this.mLiLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType >= 1000) {
            return new NimbleCard<TakoMixFeed>(viewType,
                    mLiLayoutInflater.inflate(R.layout.nimble_card_container, parent, false));
        } else {
            return new ViewHolderT(mLiLayoutInflater.inflate(R.layout.item_linear, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderT) {
            ((ViewHolderT)holder).bindData(datas.get(position));
        } else if (holder instanceof NimbleCard) {
            ((NimbleCard)holder).bindData(datas.get(position));
        }
    }

    @Override
    public int getItemViewType(final int position) {
        if (datas.get(position).getCardType() >= 1000) {
            return datas.get(position).getCardType();
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}
