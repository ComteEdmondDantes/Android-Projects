package com.hdu.journal;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RecommendFragment extends Fragment {
    public static RecommendFragment newInstance(String param1) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public RecommendFragment() {

    }
    private String[] noticeData = {"\n推荐内容\n", "\n推荐内容\n", "\n推荐内容\n", "\n推荐内容\n", "\n推荐内容\n"};
    private ListView list;
    private ArrayList<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        TextView tv = view.findViewById(R.id.container);
        tv.setText(agrs1);



        list = view.findViewById(R.id.recommend_listview);
        for(int i = 0; i < noticeData.length; i ++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("data", noticeData[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),mData,android.R.layout.simple_expandable_list_item_1,
                new String[]{"data"},new int[]{android.R.id.text1});
        list.setAdapter(adapter);

        return view;
    }
}
