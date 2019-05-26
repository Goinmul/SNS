package com.example.sns.Post;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sns.Comment.CommentList;
import com.example.sns.DB.GetData;
import com.example.sns.DB.SetData;
import com.example.sns.Model.Comment;
import com.example.sns.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by JKPC on 2019-05-14.
 */

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.CustomViewHolder> {
    private ArrayList<CommentList> mList;
    private Context mContext;
    private CustomAdapter.ItemClick itemClick;
    SetData setData = new SetData();
    GetData getData = new GetData() ;
    ArrayList<Comment> dbcomment = new ArrayList<Comment>() ;
    /*public interface ItemClick{
        public void onClick(View view, int position) ;
    }
    public void setItemClick(CustomAdapter.ItemClick itemClick){
        this.itemClick = itemClick ;
    }
*/

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        protected TextView name;
        protected TextView contents;
        protected Button like ;
        View view;

        public CustomViewHolder(View view) {
            super(view);
            this.view = view;
            this.name = (TextView) view.findViewById(R.id.textview_recyclerview_name);
            this.contents = (TextView) view.findViewById(R.id.textview_recyclerview_contents);
            this.like = (Button) view.findViewById(R.id.textView3) ;
            view.setOnCreateContextMenuListener(this);

        }
        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = contextMenu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = contextMenu.add(Menu.NONE, 1002, 2, "삭제");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
        }
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                getData.resultComment(dbcomment);
                switch (item.getItemId()) {
                    case 1001:
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                        // 다이얼로그를 보여주기 위해 edit_box.xml 파일을 사용합니다.

                        View view = LayoutInflater.from(mContext)
                                .inflate(R.layout.edit_box, null, false);
                        builder.setView(view);
                        final Button ButtonSubmit = (Button) view.findViewById(R.id.button_dialog_submit);
                        final EditText editTextContents = (EditText) view.findViewById(R.id.edittext_dialog_contents);

                        editTextContents.setText(mList.get(getAdapterPosition()).getContents());

                        final AlertDialog dialog = builder.create();
                        ButtonSubmit.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                String strContents = editTextContents.getText().toString();
                                String strName = mList.get(getAdapterPosition()).getName() ;
                                for(int i = 0 ; i<dbcomment.size();i++){
                                    if(dbcomment.get(i).getUser_id().equalsIgnoreCase(mList.get(getAdapterPosition()).getName())&&
                                            dbcomment.get(i).getContent().equalsIgnoreCase(mList.get(getAdapterPosition()).getContents())){
                                        setData.editComment(strContents, dbcomment.get(i).getIndex());
                                        Toast.makeText(mContext, "수정", Toast.LENGTH_SHORT).show() ;
                                    }
                                }
                                CommentList com = new CommentList(strName, strContents);
                                mList.set(getAdapterPosition(), com);
                                notifyItemChanged(getAdapterPosition());
                                dialog.dismiss();
                            }
                        });
                        dialog.show() ;
                        break;

                    case 1002:
                        for(int i = 0 ; i<dbcomment.size();i++){
                            if(dbcomment.get(i).getUser_id().equalsIgnoreCase(mList.get(getAdapterPosition()).getName())&&
                                    dbcomment.get(i).getContent().equalsIgnoreCase(mList.get(getAdapterPosition()).getContents())){
                                setData.deleteComment(dbcomment.get(i).getIndex());
                                Toast.makeText(mContext, "삭제", Toast.LENGTH_SHORT).show() ;
                            }
                        }
                        mList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), mList.size());

                        break;

                }
                return true;
            }
        };

    }


    public CustomAdapter2(Context context, ArrayList<CommentList> list) {
        mContext = context ;
        mList = list;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.comment_item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder viewholder, final int position) {
        getData.resultComment(dbcomment);
        viewholder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewholder.contents.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewholder.like.setTextSize(TypedValue.COMPLEX_UNIT_SP, 6);

        viewholder.like.setGravity(Gravity.CENTER);

        viewholder.name.setText(mList.get(position).getName());
        viewholder.contents.setText(mList.get(position).getContents());

        viewholder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0 ; i<dbcomment.size();i++){
                    if(dbcomment.get(i).getUser_id().equalsIgnoreCase(mList.get(position).getName())&&
                            dbcomment.get(i).getContent().equalsIgnoreCase(mList.get(position).getContents())){
                        setData.likeComment(dbcomment.get(i).getIndex());
                        Toast.makeText(mContext, "좋아요를 눌렀습니다.", Toast.LENGTH_SHORT).show() ;
                    }
                }

            }
        });
       /* viewholder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClick != null){
                    itemClick.onClick(v, Position);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
