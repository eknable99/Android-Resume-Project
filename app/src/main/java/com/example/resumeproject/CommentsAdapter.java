package com.example.resumeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumeproject.Comment;
import com.example.resumeproject.R;

import java.util.List;

public class CommentsAdapter extends
        RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView commentTextView;

        public ViewHolder(View itemView){
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.user_name);
            commentTextView = (TextView) itemView.findViewById(R.id.user_comment);
        }
    }

    private List<Comment> mComments;

    public CommentsAdapter(List<Comment> comments){
        mComments = comments;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View commentView = inflater.inflate(R.layout.item_comment, parent, false);

        return new ViewHolder(commentView);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder holder, int position){
        Comment comment = mComments.get(position);

        TextView textViewName = holder.nameTextView;
        textViewName.setText(comment.getName());
        TextView textViewComment = holder.commentTextView;
        textViewComment.setText(comment.getComment());
    }

    @Override
    public int getItemCount(){
        return mComments.size();
    }
}
