package com.test.packages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер
 */
public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {

    private List<AppInfo> apps = new ArrayList<>();

    public void setApps(List<AppInfo> apps) {
        this.apps = apps;
    }

    // В этом методе мы создаем новую ячейку
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.view_item_app, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    // В этом методе мы привязываем данные к ячейке
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AppInfo appInfo = apps.get(position);

        holder.nameTv.setText(appInfo.getName());
        holder.versionTv.setText(appInfo.getVersionName());
        holder.iconIv.setImageDrawable(appInfo.getIcon());
    }

    // В этом методе мы возвращаем количество элементов списка
    @Override
    public int getItemCount() {
        return apps.size();
    }

    /**
     * View holder
     * Хранит информацию о ячейке
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iconIv;
        private final TextView nameTv;
        private final TextView versionTv;

        public ViewHolder(View itemView) {
            super(itemView);

            iconIv = itemView.findViewById(R.id.icon_iv);
            nameTv = itemView.findViewById(R.id.name_tv);
            versionTv = itemView.findViewById(R.id.version_tv);
        }
    }

}
