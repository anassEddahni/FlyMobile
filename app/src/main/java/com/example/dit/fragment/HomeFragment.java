package com.example.dit.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dit.adapter.CustomPageAdapterTypes;
import com.example.dit.adapter.HorizontalAdapter;
import com.example.dit.adapter.HorizontalAdapterChild;
import com.example.dit.adapter.RecyclerTouchListener;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.CommandeActivity;
import com.example.dit.viewpagerswipe.R;
import com.mancj.slideup.SlideUp;
import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment implements HorizontalAdapterChild.RecyclerItemClickListener{

    @BindView(R.id.details) ViewPager pager;
    @BindView(R.id.indicator) CircleIndicator indicator;
    @BindView(R.id.horizontal_recycler_view) RecyclerView horizontal_recycler_view;
    @BindView(R.id.horizontal_recycler_view_child) RecyclerView horizontal_recycler_view_child;
    @BindView(R.id.image_article) ImageView imageProduit;
    //@BindView(R.id.image_header) ImageView header;
    @Nullable
    @BindView(R.id.lvExp) ExpandableListView expListView;
    @BindView(R.id.bouton_commander) Button buttonCommander;

    private SlideUp slideUp;
    @BindView(R.id.rl_sliding)
    View slidingLayout;
    @BindView(R.id.btn_swipe)Button hideShow;

    public Context context;
    ArrayList<String> horizontalList;
    HorizontalAdapter horizontalAdapter;
    HorizontalAdapterChild horizontalAdapterchild;
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    Programme monObjetProg;
    Categories monObjetCat;
    List<Article> horizontalListchild =new ArrayList<>();

    LinearLayoutManager horizontalLayoutManagaer;

   // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        //get categories object


        slideUp = new SlideUp.Builder(slidingLayout)
                .withStartGravity(Gravity.BOTTOM)
                .withLoggingEnabled(true)
                .withGesturesEnabled(true)
                .withStartState(SlideUp.State.HIDDEN)
                .build();


        getActivity().getIntent().getExtras().getString("image");
        monObjetCat= (Categories) getActivity().getIntent().getSerializableExtra("maClasseCategories");
        monObjetProg = (Programme) getActivity().getIntent().getSerializableExtra("maClasseProgramme");
        Log.d("mon objeeet","" + monObjetProg.getCategories().get(0).getProduit().getNom());
        //set Adapter viewPager
        CustomPageAdapterTypes mCustomPagerAdapterTypes = new CustomPageAdapterTypes(getActivity(),monObjetProg);
        pager.setAdapter(mCustomPagerAdapterTypes);
        // SET indicator for view pager
        indicator.setViewPager(pager);
        //add parent list
        horizontalList=new ArrayList<>();
        horizontalList.add("Matiere");
        horizontalList.add("couleur");
        horizontalList.add("accoudoirs et pieds");
        horizontalList.add("confort");
        horizontalAdapter=new HorizontalAdapter(horizontalList);
        horizontalLayoutManagaer
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
        //add child list
        horizontal_recycler_view.addItemDecoration(new VerticalDividerItemDecoration.Builder(getActivity()).sizeResId(R.dimen.divider).build());

        horizontal_recycler_view.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), horizontal_recycler_view, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                horizontalListchild.clear();
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(0));
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(1));
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(2));
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(3));
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(4));
                horizontalListchild.add(monObjetCat.getAttributList().get(position).getArticles().get(5));

                Log.d("============","SEL"+horizontalListchild.toString());
                horizontalAdapterchild=new HorizontalAdapterChild(horizontalListchild,getContext(),HomeFragment.this);
                LinearLayoutManager horizontalLayoutManagaerChild = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                horizontal_recycler_view_child.setLayoutManager(horizontalLayoutManagaerChild);
                horizontal_recycler_view_child.setAdapter(horizontalAdapterchild);
                Log.d("============","SELECTEEEEEEEEEEEDDDDDDDDDD");
                horizontalLayoutManagaer.scrollToPositionWithOffset(position,0);

            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        //Picasso.with(getActivity()).load("http://media-cdn.fly.fr/media/rubriques/780-gauche-salons2016.jpg").resize(3100,600).into(header);
        Picasso.with(getActivity()).load(monObjetProg.getCategories().get(0).getProduit().getImageUrl()).into(imageProduit);

        buttonCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CommandeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void itemClicked(int position) {
        for(Article article :horizontalListchild){
            article.setChecked(false);
        }

        horizontalListchild.get(position).setChecked(true);
        horizontalAdapterchild.notifyDataSetChanged();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @OnClick(R.id.btn_swipe)
    public void openClose() {

        if (slideUp.isVisible()) {
            hideShow.setText("PERSONNALISER");
            slideUp.hide();
        } else {
            hideShow.setText("CONFIRMER");
            slideUp.show();
        }
    }


}







/*//Préparation des données article
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();

        for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            listDataHeader.add(monObjetCat.getAttributList().get(i).getNom());
        }
        //ajouter les données aux fils
        //matiere
        List<Article> matiere = new ArrayList<>();
        matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(0));
        matiere.add(monObjetCat.getAttributList().get(0).getArticles().get(1));

        //couleur
        List<Article> couleur = new ArrayList<>();
        couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(0));
        couleur.add(monObjetCat.getAttributList().get(1).getArticles().get(1));

        //accoudoir
        List<Article> accoudoir = new ArrayList<>();
        accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(0));
        accoudoir.add(monObjetCat.getAttributList().get(2).getArticles().get(1));

        //confort
        List<Article> confort = new ArrayList<>();
        confort.add(monObjetCat.getAttributList().get(3).getArticles().get(0));
        confort.add(monObjetCat.getAttributList().get(3).getArticles().get(1));

        //attribuer les données de fils à leurs headers
        listDataChild.put(listDataHeader.get(0), matiere); // Header, Child data
        listDataChild.put(listDataHeader.get(1), couleur);
        listDataChild.put(listDataHeader.get(2), accoudoir);
        listDataChild.put(listDataHeader.get(3), confort);
    }*/