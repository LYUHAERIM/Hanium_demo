package com.example.registerloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Frag4 extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag4, container, false);

        RecyclerView mMainRecyclerView = view.findViewById(R.id.main_recycler_view);
        view.findViewById(R.id.main_write_button).setOnClickListener(this);

        List<Board> mBoardList = new ArrayList<>();
        mBoardList.add(new Board(null,"지금 시간 새벽 4시", null,"주바킴"));
        mBoardList.add(new Board(null,"자고싶다", null,"민서"));
        mBoardList.add(new Board(null,"반갑습니다 여러분", null,"android"));
        mBoardList.add(new Board(null,"안녕", null,"Server"));
        mBoardList.add(new Board(null,"Hello", null,"Java"));
        mBoardList.add(new Board(null,"Hi", null,"php"));
        mBoardList.add(new Board(null,"ㅋㅋ", null,"Python"));

        MainAdapter mAdapter = new MainAdapter(mBoardList);
        mMainRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onClick(View v){
        startActivity(new Intent(getContext(), WriteActivity.class));
    }

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{

        private List<Board> mBoardList;

        public MainAdapter(List<Board> mBoardList) {
            this.mBoardList = mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = mBoardList.get(position);
            holder.mTitleTextView.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{

            private TextView mTitleTextView;
            private TextView mNameTextView;
            public MainViewHolder(View itemView) {
                super(itemView);

                mTitleTextView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);
            }
        }
    }
}
