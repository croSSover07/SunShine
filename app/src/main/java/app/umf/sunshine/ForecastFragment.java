package app.umf.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            FetchWeatherTask weatherTask=new FetchWeatherTask();
            weatherTask.execute("94043");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] data={
                "Mon 6/23 - Sunny - 31/17",
                                     "Tue 6/24 - Foggy - 21/8",
                                    "Wed 6/25 - Cloudy - 22/17",
                                    "Thurs 6/26 - Rainy - 18/11",
                                     "Fri 6/27 - Foggy - 21/10",
                                     "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
                                     "Sun 6/29 - Sunny - 20/7"
        };
        List<String> weekForecast=new ArrayList<String>(Arrays.asList(data));
        ArrayAdapter mForecastAdapter=new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast,
                R.id.list_item_forecast_textview,
                weekForecast);
        View rootview=inflater.inflate(R.layout.fragment_main,container,false);
        ListView listView=(ListView) rootview.findViewById(R.id.listView_forecast);
        listView.setAdapter(mForecastAdapter);
        return rootview;
    }

}



