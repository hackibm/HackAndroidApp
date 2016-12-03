package hackathon.mms.app.domain.officeList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import hackathon.mms.app.domain.officeList.DistrictOfficeListFragment.OnDistrictOfficeSelectedListener;
import hackathon.mms.app.R;
import hackathon.mms.app.shared.model.DistrictOffice;


public class DistrictOfficeRecyclerViewAdapter extends RecyclerView.Adapter<DistrictOfficeRecyclerViewAdapter.ViewHolder> {

    private final List<DistrictOffice> districtOffices;
    private final OnDistrictOfficeSelectedListener listener;

    public DistrictOfficeRecyclerViewAdapter(List<DistrictOffice> items, OnDistrictOfficeSelectedListener listener) {
        districtOffices = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_district_office_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.districtOffice = districtOffices.get(position);
       // holder.mIdView.setText(districtOffices.get(position).getId());
        holder.mContentView.setText(districtOffices.get(position).getName());
        //holder.mAddresView.setText(districtOffices.get(position).getContactInfo().getAddress());





        holder.mView.setOnClickListener(v -> {
            if (null != listener) {
                listener.onDistrictOfficeSelected(holder.districtOffice);
            }
        });
    }

    @Override
    public int getItemCount() {
        return districtOffices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        public final TextView mContentView;
        //public final TextView mAddresView;
        public DistrictOffice districtOffice;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            //mAddresView = (TextView) view.findViewById(R.id.address);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
