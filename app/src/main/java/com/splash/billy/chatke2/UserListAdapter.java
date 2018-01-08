package com.splash.billy.chatke2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Billy on 08/01/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UsersHolder> {

    List<User> users;
    private LayoutInflater inflater;
    private Context context;

    SharedPreferences mylocaldata;

    public UserListAdapter(Context context,List<User> users){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.users = users;

        mylocaldata = context.getSharedPreferences("mylocaldata",Context.MODE_PRIVATE);
    }
    @Override
    public UsersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.usercard,parent,false);
        UsersHolder holder = new UsersHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(UsersHolder holder, int position) {
        User current = users.get(position);
        holder.setData(current,position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView tvNama, tvTlpn ;
        CardView thisuser;

        int position;
        User current;

        public UsersHolder(View itemView) {
            super(itemView);
            this.itemView =itemView;

            thisuser = (CardView) itemView.findViewById (R.id.cvItemUser);
            tvNama= (TextView) itemView.findViewById(R.id.tv_Nama);
            tvTlpn = (TextView) itemView.findViewById(R.id.tv_tlpn);
        }

        public void setData(User current, int position) {
            tvNama.setText(current.getNama());
            tvTlpn.setText(current.getTelepon());

            this.position = position;
            this.current = current;
        }

        public void setListeners() {
        }
    }
}
