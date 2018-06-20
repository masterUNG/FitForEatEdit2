package fitforeat.fitforeat_2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class FoodList_1 extends BaseAdapter {

    //Explicit
    private Context objContext;
    private String[] titleStrings, detailStrings, numCalString, CalString;
    private int[] iconInts;


    public FoodList_1(Context objContext, String[] titleStrings, String[] detailStrings, int[] iconInts) {
        this.objContext = objContext;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.iconInts = iconInts;

    }   // Constructor

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.food_list_1, viewGroup, false);

        //Setup Title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.txtTitle);
        titleTextView.setText(titleStrings[i]);

        //Setup Detail
        TextView detailTextView = (TextView) objView1.findViewById(R.id.txtDetail);
        //detailTextView.setText(detailStrings[i]);
        detailTextView.setText(detailStrings[i]+"cal" );
        //Setup Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvIcon);
        iconImageView.setImageResource(iconInts[i]);


        return objView1;
    }
}   // Main Class
