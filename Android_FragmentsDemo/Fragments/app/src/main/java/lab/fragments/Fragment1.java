package lab.fragments;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Dhwani on 2/25/2016.
 */
public class Fragment1 extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
            //----inflate the layout for this fragment --
            return inflater.inflate(R.layout.fragment1,container, false);
    }
}