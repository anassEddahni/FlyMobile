package com.example.dit.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dit.adapter.ExpandableListAdapter;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.com.example.dit.entities.Programme;
import com.example.dit.viewpagerswipe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CanapeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CanapeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanapeFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    private Categories monObjetCat;
    TextView nomProduit ;
    ImageView imageProduit;
    Bitmap bmp;
    private Programme monObjetProg;
    private int lastExpandedPosition = -1;
    ImageView header;
    private TextView description ;
    private TextView prixProduit ;
    private TextView prixEcoProduit ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CanapeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CanapeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CanapeFragment newInstance(String param1, String param2) {
        CanapeFragment fragment = new CanapeFragment();
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
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        expListView = (ExpandableListView)view.findViewById(R.id.lvExp);
        imageProduit = (ImageView) view.findViewById(R.id.image_article);
        nomProduit = (TextView) view.findViewById(R.id.nom_produit);
        description = (TextView) view.findViewById(R.id.description_produit);
        prixProduit = (TextView) view.findViewById(R.id.prix_produit);
        prixEcoProduit = (TextView) view.findViewById(R.id.prix_eco_produit);
        header = (ImageView) view.findViewById(R.id.image_header);
        //get categories object
        getActivity().getIntent().getExtras().getString("image");
        monObjetCat= (Categories) getActivity().getIntent().getSerializableExtra("maClasseCategories");
        monObjetProg = (Programme) getActivity().getIntent().getSerializableExtra("maClasseProgramme");
        Log.d("====================",":"+monObjetCat.toString());
        Picasso.with(getActivity()).load("http://media-cdn.fly.fr/media/rubriques/780-gauche-salons2016.jpg").resize(3100,600).into(header);
        nomProduit.setText(monObjetProg.getCategories().get(1).getProduit().getNom());
        description.setText(monObjetProg.getCategories().get(1).getProduit().getDesc());
        prixProduit.setText(monObjetProg.getCategories().get(1).getProduit().getPrix());
        prixEcoProduit.setText(monObjetProg.getCategories().get(1).getProduit().getPrixEco());
        //Picasso.with(this).load(monObjetCat.getPhotoUrl()).into(imageArticle);
        Picasso.with(getActivity()).load(monObjetProg.getCategories().get(1).getProduit().getImageUrl()).into(imageProduit);

        // preparing list data
        prepareListData();
        //set data to expandable list
        //listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting adapter to the list
        //expListView.setAdapter(listAdapter);
        //collapse non-selected Group
       /* expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });*/

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
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    //Préparation des données article
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();
        List<Article> matiere = new ArrayList<>();

        for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            listDataHeader.add(monObjetCat.getAttributList().get(i).getNom());
        }

       /* for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            for(int j = 0 ; j < monObjetCat.getAttributList().get(i).getArticles().size();j++){
                matiere.add(monObjetCat.getAttributList().get(i).getArticles().get(j));
            }
        }*/

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
