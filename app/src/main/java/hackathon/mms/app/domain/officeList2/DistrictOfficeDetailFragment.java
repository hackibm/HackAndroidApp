package hackathon.mms.app.domain.officeList2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hackathon.mms.app.domain.officeList2.dummy.DummyContent;
import hackathon.mms.app.R;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;
import hackathon.mms.app.shared.model.DistrictOffice;

/**
 * A fragment representing a single DistrictOffice detail screen.
 * This fragment is either contained in a {@link DistrictOfficeListActivity}
 * in two-pane mode (on tablets) or a {@link DistrictOfficeDetailActivity}
 * on handsets.
 */
public class DistrictOfficeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DistrictOffice mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DistrictOfficeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.

            GraphQLRepository respository = new GraphQLRepository();
            //repository.

            mItem = new DistrictOffice(getArguments().getString(ARG_ITEM_ID), "Nazwaxxxx", null, null);//DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Log.i("ID--->", getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.districtoffice_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.districtoffice_detail)).setText(mItem.getName());
        }

        return rootView;
    }
}
