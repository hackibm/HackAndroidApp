package hackathon.mms.app.domain.officeList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackathon.mms.app.shared.model.HackAndroidApp;
import hackathon.mms.app.R;
import hackathon.mms.app.shared.model.DistrictOffice;
import hackathon.mms.app.infrastructure.repository.GraphQLRepository;


public class DistrictOfficeListFragment extends Fragment implements DistrictOfficeListContract.DistrictOfficeListView {


    private OnDistrictOfficeSelectedListener officeSelectedListener;

    private DistrictOfficeListContract.DistrictOfficeListPresenter presenter;

    private DistrictOfficeRecyclerViewAdapter adapter;


    public static DistrictOfficeListFragment newInstance() {
        DistrictOfficeListFragment fragment = new DistrictOfficeListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GraphQLRepository repository = ((HackAndroidApp)getActivity()
                .getApplication())
                .getRepository();

        presenter = new DistrictOfficeListPresenterImpl(this, repository);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_district_office_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            List<DistrictOffice> districtOffices = presenter.getOfficeList(null);



            adapter = new DistrictOfficeRecyclerViewAdapter(districtOffices, officeSelectedListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDistrictOfficeSelectedListener) {
            officeSelectedListener = (OnDistrictOfficeSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDistrictOfficeSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        officeSelectedListener = null;
    }

    @Override
    public void notifyDataChange() {
        adapter.notifyDataSetChanged();

    }

    public interface OnDistrictOfficeSelectedListener {
        void onDistrictOfficeSelected(DistrictOffice districtOffice);
    }
}
