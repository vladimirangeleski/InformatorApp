package rotaryinformatorapp.com.rotaryinformatorapp.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.model.Category;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.MyViewHolder> {

    public interface OnCategoryItemClickListener {
        void onCategoryClick(Category category, int position);
    }

    private List<Category> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private OnCategoryItemClickListener listener;

    public CategoriesRecyclerViewAdapter(Context context, List<Category> data, OnCategoryItemClickListener listener) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        int height = (int) (parent.getMeasuredHeight() / 4);
        view.setMinimumHeight(height);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Category category = data.get(position);

        holder.title.setText(category.getName());

        Drawable buttonDrawable = context.getResources().getDrawable(category.getDrawable());
        buttonDrawable.mutate();

        holder.image.setImageDrawable(buttonDrawable);
        //holder.categoryWrapper.setBackground(buttonDrawable);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onCategoryClick(category, position);
            }
        });*/

        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                View icon = v.findViewById(R.id.image);
                TextView text = (TextView) v.findViewById(R.id.title);
                Rect rect = null;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        rect = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                        icon.setSelected(true);
                        text.setTextColor(v.getContext().getResources().getColor(android.R.color.black));
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (rect != null && !rect.contains(v.getLeft() + (int) event.getX(), v.getTop() + (int) event.getY())) {
                            icon.setSelected(false);
                            text.setTextColor(v.getContext().getResources().getColor(R.color.textGray));
                        }
                        break;
                    case MotionEvent.ACTION_OUTSIDE:
                        icon.setSelected(false);
                        text.setTextColor(v.getContext().getResources().getColor(R.color.textGray));
                        break;
                    case (MotionEvent.ACTION_CANCEL):
                        icon.setSelected(false);
                        text.setTextColor(v.getContext().getResources().getColor(R.color.textGray));
                        return true;
                    case MotionEvent.ACTION_UP:
                        icon.setSelected(false);
                        text.setTextColor(v.getContext().getResources().getColor(R.color.textGray));
                        if (listener != null)
                            listener.onCategoryClick(category, position);
                        break;
                    default:
                        return false;
                }
                return false;
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView image;
        //private final LinearLayout categoryWrapper;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
            //categoryWrapper = (LinearLayout) itemView.findViewById(R.id.categoryWrapper);
        }
    }
}
