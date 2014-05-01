package com.example.location;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.location.dummy.CurrentLocationListener;
import com.example.location.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link ItemListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";
	CurrentLocationListener locationListener;
	LocationManager locationManager;
	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_item_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			TextView tv = ((TextView) rootView.findViewById(R.id.item_detail));
			locationManager = (LocationManager)getActivity().getSystemService(getActivity().LOCATION_SERVICE);
			locationListener = new CurrentLocationListener("0.0","0.0",tv, getActivity());
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,locationListener);    

			Toast.makeText(getActivity(), "hello", 4000).show();
		}

		return rootView;
	}
	@Override
	public void onResume() {
	super.onResume();
	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 1, locationListener);
	 }

}
