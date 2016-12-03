package hackathon.mms.app.domain.officeList2;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import hackathon.mms.app.domain.officeList2.dummy.DummyContent;

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
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DistrictOfficeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments().containsKey(ARG_ITEM_ID)) {
//            // Load the dummy content specified by the fragment
//            // arguments. In a real-world scenario, use a Loader
//            // to load content from a content provider.
//            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
//
//            Activity activity = this.getActivity();
//            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
//            if (appBarLayout != null) {
//                appBarLayout.setTitle(mItem.content);
//            }
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.districtoffice_detail, container, false);
//
//        // Show the dummy content as text in a TextView.
//        if (mItem != null) {
//            ((TextView) rootView.findViewById(R.id.districtoffice_detail)).setText(mItem.details);
//        }
//
//        return rootView;
//    }
    }
}
