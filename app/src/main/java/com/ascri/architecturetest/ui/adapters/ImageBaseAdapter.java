package com.ascri.architecturetest.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascri.architecturetest.R;
import com.ascri.architecturetest.data.models.User;
import com.ascri.architecturetest.ui.adapters.ImageBaseAdapter.ViewHolderAvatar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ImageBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> items = new ArrayList<>();
    private Context context;

    public ImageBaseAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<User> users) {
        items.addAll(users);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAvatar(
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
                .into(((ViewHolderAvatar) holder).avatar);
        ((ViewHolderAvatar) holder).name.setText(items.get(position).getName());
        ((ViewHolderAvatar) holder).innerAdapter.setData(items.get(position).getItems());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolderAvatar extends RecyclerView.ViewHolder {
        private List<User> data;
        private ImageView avatar;
        private TextView name;
        private RecyclerView innerImages;
        private GridLayoutManager gridLayoutManager;
        private ImageAdapter innerAdapter;

        ViewHolderAvatar(@NonNull View itemView, List<User> data) {
            super(itemView);
            this.data = data;
            avatar = itemView.findViewById(R.id.ivAvatar);
            name = itemView.findViewById(R.id.tvUserName);
            innerImages = itemView.findViewById(R.id.rvInnerImage);
            gridLayoutManager = new GridLayoutManager(itemView.getContext(), 2);
            innerAdapter = new ImageAdapter(itemView.getContext());
            init();
        }

        private void init() {
            innerImages.setHasFixedSize(true);
            innerImages.setLayoutManager(gridLayoutManager);
            GridLayoutManager.SpanSizeLookup value = new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 0 && data.get(getAdapterPosition()).getItems().size() % 2 != 0) {
                        return 2;
                    } else return 1;
                }
            };
            gridLayoutManager.setSpanSizeLookup(value);
            innerImages.setAdapter(innerAdapter);
        }
    }
}
