package com.ascri.architecturetest.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.ascri.architecturetest.R;
import com.ascri.architecturetest.data.models.User;
import com.ascri.architecturetest.ui.adapters.ImageBaseAdapter2.ViewHolderAvatar2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ImageBaseAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> items = new ArrayList<>();
    private Context context;

    public ImageBaseAdapter2(Context context) {
        this.context = context;
    }

    public void setData(List<User> users) {
        items.addAll(users);
        notifyDataSetChanged();
    }

    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAvatar2(
                LayoutInflater.from(context)
                        .inflate(R.layout.item_image_avatar, parent, false),
                items
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context)
                .load(items.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(((ViewHolderAvatar2) holder).avatar);
        ((ViewHolderAvatar2) holder).name.setText(items.get(position).getName());
        ((ViewHolderAvatar2) holder).innerAdapter.setData(items.get(position).getItems());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class ViewHolderAvatar2 extends RecyclerView.ViewHolder {
        private List<User> data;
        private ImageView avatar;
        private TextView name;
        private RecyclerView innerImages;
        private LinearLayoutManager linearLayoutManager;
        private ImageAdapter innerAdapter;

        ViewHolderAvatar2(@NonNull View itemView, List<User> data) {
            super(itemView);
            this.data = data;
            avatar = itemView.findViewById(R.id.ivAvatar);
            name = itemView.findViewById(R.id.tvUserName);
            innerImages = itemView.findViewById(R.id.rvInnerImage2);
            linearLayoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            innerAdapter = new ImageAdapter(itemView.getContext());
            init();
        }

        private void init() {
            innerImages.setHasFixedSize(true);
            innerImages.setLayoutManager(linearLayoutManager);
            innerImages.setAdapter(innerAdapter);
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(innerImages);
        }
    }
}
