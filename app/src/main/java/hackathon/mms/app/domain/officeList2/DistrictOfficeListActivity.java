package hackathon.mms.app.domain.officeList2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hackathon.mms.app.R;
import hackathon.mms.app.domain.officeList.DistrictOfficeListFragment;
import hackathon.mms.app.domain.officeList2.dummy.DummyContent;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * An activity representing a list of DistrictOffices. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link DistrictOfficeDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class DistrictOfficeListActivity extends AppCompatActivity implements DistrictOfficeListFragment.OnDistrictOfficeSelectedListener{

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districtoffice_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Fragment districtOfficeListFrag = DistrictOfficeListFragment.newInstance();
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.districe_office_list_container, districtOfficeListFrag)
//        .commit();



        View recyclerView = findViewById(R.id.districtoffice_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.districtoffice_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {

        GraphQLRepository repo = new GraphQLRepository();
       List<DistrictOffice> districtOffices = new ArrayList<DistrictOffice>();
        SimpleItemRecyclerViewAdapter urzedyAdapter = new SimpleItemRecyclerViewAdapter(districtOffices);
        recyclerView.setAdapter(urzedyAdapter);
        Observable<DistrictOffice> observable = repo.getDistrictOffices();
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList().subscribe(list ->
                {   districtOffices.addAll(list);
                    for(DistrictOffice doff : districtOffices){
                        Log.i("District2" , "Office: " + doff.getId()+" "+doff.getName());

                    }
                    urzedyAdapter.notifyDataSetChanged();
                },
                Throwable::printStackTrace);

    }

    @Override
    public void onDistrictOfficeSelected(DistrictOffice districtOffice) {

    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<DistrictOffice> mValues;

        public SimpleItemRecyclerViewAdapter(List<DistrictOffice> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.districtoffice_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
         //   holder.mIdView.setText(mValues.get(position).getId());
            holder.mContentView.setText(mValues.get(position).getName());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(DistrictOfficeDetailFragment.ARG_ITEM_ID, holder.mItem.getId());
                        DistrictOfficeDetailFragment fragment = new DistrictOfficeDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.districtoffice_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, DistrictOfficeDetailActivity.class);
                        intent.putExtra(DistrictOfficeDetailFragment.ARG_ITEM_ID, holder.mItem.getId());

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public DistrictOffice mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }

    }

    }

