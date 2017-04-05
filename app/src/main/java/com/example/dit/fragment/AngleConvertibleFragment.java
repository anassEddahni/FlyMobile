package com.example.dit.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AngleConvertibleFragment extends Fragment {
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    private Categories monObjetCat;
    @BindView(R.id.image_article) ImageView imageProduit;
    @BindView(R.id.image_header)ImageView header;
    Programme monObjetProg;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AngleConvertibleFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static AngleConvertibleFragment newInstance(String param1, String param2) {
        AngleConvertibleFragment fragment = new AngleConvertibleFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        //get categories object
        getActivity().getIntent().getExtras().getString("image");
        monObjetCat= (Categories) getActivity().getIntent().getSerializableExtra("maClasseCategories");
        monObjetProg = (Programme) getActivity().getIntent().getSerializableExtra("maClasseProgramme");
        Log.d("====================",":"+monObjetCat.toString());
        Picasso.with(getActivity()).load("http://media-cdn.fly.fr/media/rubriques/780-gauche-salons2016.jpg").resize(3100,600).into(header);
        Picasso.with(getActivity()).load(monObjetProg.getCategories().get(4).getProduit().getImageUrl()).into(imageProduit);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();
        List<Article> matiere = new ArrayList<>();

        for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            listDataHeader.add(monObjetCat.getAttributList().get(i).getNom());
        }
        //ajouter les données aux fils
        //matiere
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

    }
}
