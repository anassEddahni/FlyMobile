package com.example.dit.viewpagerswipe;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.dit.adapter.ExpandableListAdapter;
import com.example.dit.com.example.dit.entities.Article;
import com.example.dit.com.example.dit.entities.Categories;
import com.example.dit.fragment.HomeFragment;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class ProduitActivity extends AppCompatActivity {

    ///////////////////////////
    private View fragment;
    private LayoutInflater layoutInflater;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private ImageView imageMenuFauteuil;
    private ImageView imageMenuCanape;
    private ImageView imageMenuAngleFixe;
    private ImageView imageMenuConvertible;
    private ImageView imageMenuAngleConvertible;


    private TextView description ;
    private TextView prixProduit ;
    private TextView prixEcoProduit ;
    // urls to load navigation header background image
    // and profile image
    private static final String urlNavHeaderBg = "https://s7g8.scene7.com/is/image/FLY//linkup?fmt=jpg&wid=781&hei=1068";
    private static final String urlProfileImg = "https://s7g8.scene7.com/is/image/FLY//logo-myfly";

    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_FAUTEUIL = "fauteuil";
    private static final String TAG_CANAPE = "canape";
    private static final String TAG_ANGLEFIXE = "angleFixe";
    private static final String TAG_CONVERTIBLE = "Convertible";
    private static final String TAG_ANGLECONVERTIBLE= "angleConvertible";
    public static String CURRENT_TAG = TAG_FAUTEUIL;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;
/////////////////////////////////////////////////////////////////////////////////


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Article>> listDataChild;
    private Categories monObjetCat;
    TextView nomProduit ;
    ImageView imageProduit;
    Bitmap bmp;
    private int lastExpandedPosition = -1;
    ImageView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);


        imageProduit = (ImageView) findViewById(R.id.image_article);
        /*expListView = (ExpandableListView) findViewById(R.id.lvExp);

        nomProduit = (TextView) findViewById(R.id.nom_produit);
        description = (TextView) findViewById(R.id.description_produit);
        prixProduit = (TextView) findViewById(R.id.prix_produit);
        prixEcoProduit = (TextView) findViewById(R.id.prix_eco_produit);
        header = (ImageView) findViewById(R.id.image_header);*/

        //get categories object

        monObjetCat= (Categories) getIntent().getSerializableExtra("maClasseCategories");
        /*Picasso.with(this).load("http://media-cdn.fly.fr/media/rubriques/780-gauche-salons2016.jpg").resize(3100,600).into(header);
        nomProduit.setText(monObjetCat.getProduit().getNom());
        description.setText(monObjetCat.getProduit().getDesc());
        prixProduit.setText(monObjetCat.getProduit().getPrix());
        prixEcoProduit.setText(monObjetCat.getProduit().getPrixEco());
        //Picasso.with(this).load(monObjetCat.getPhotoUrl()).into(imageArticle);
        ;*/
//        Picasso.with(this).load(monObjetCat.getProduit().getImageUrl()).into(imageProduit);
        // preparing list data

        //prepareListData();

     /*   //set data to expandable list
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting adapter to the list
        expListView.setAdapter(listAdapter);
        //collapse non-selected Group
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });*/

///////////////////////////////////////////////////////////////////////////////////////////

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menuNav = navigationView.getMenu();
        MenuItem fauteuilItem = menuNav.findItem(R.id.nav_fauteuil);
        //fauteuilItem.setIcon(R.drawable.camion) ;
        fab = (FloatingActionButton) findViewById(R.id.fab);
        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        txtName = (TextView) navHeader.findViewById(R.id.name);
        txtWebsite = (TextView) navHeader.findViewById(R.id.website);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);
        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        //floatActionButton listener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // load nav menu header data
        loadNavHeader();

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_FAUTEUIL;
            loadHomeFragment();
        }

/////////////////////////////////////////////////////////////////////


    }

    /***
     * Load navigation menu header information
     * like background image, profile image
     * name, website, notifications action view (dot)
     */
    private void loadNavHeader() {
        // name, website
        txtName.setText("Myfly");
        txtWebsite.setText("www.fly.fr");

        // loading header background image
        Glide.with(this).load(urlNavHeaderBg).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imgNavHeaderBg);

        // Loading profile image
        Glide.with(this).load(urlProfileImg).crossFade().thumbnail(0.5f).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgProfile);
    }

    /***
     * Returns respected fragment that user
     * selected from navigation menu
     */
    private void loadHomeFragment() {



        // selecting appropriate nav menu item
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            // show or hide the fab button
            toggleFab();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        // show or hide the fab button
        toggleFab();

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
           // case 1:
                // photos
               /* PhotosFragment photosFragment = new PhotosFragment();
                return photosFragment;
            case 2:
                // movies fragment
                MoviesFragment moviesFragment = new MoviesFragment();
                return moviesFragment;
            case 3:
                // notifications fragment
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                return notificationsFragment;

            case 4:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;*/
            default:
                return new HomeFragment();
        }
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_fauteuil:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_FAUTEUIL;
                        break;
                    case R.id.nav_canape:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_CANAPE;
                        break;
                    case R.id.nav_anglefixe:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_ANGLEFIXE;
                        break;
                    case R.id.nav_convertible:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_CONVERTIBLE;
                        break;
                    case R.id.nav_angleconvertible:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_ANGLECONVERTIBLE;
                        break;
                   /* case R.id.nav_about_us:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, AboutUsActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_privacy_policy:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, PrivacyPolicyActivity.class));
                        drawer.closeDrawers();
                        return true;*/
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_FAUTEUIL;
                loadHomeFragment();
                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       /* getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        MenuItem imageFauteuil = menu.findItem(R.id.nav_fauteuil);
        imageFauteuil.setIcon(R.drawable.camion);*/

        // Inflate the menu; this adds items to the action bar if it is present.

        // show menu only when home fragment is selected
        if (navItemIndex == 0) {
            getMenuInflater().inflate(R.menu.main, menu);
        }

        // when fragment is notifications, load the menu created for notifications
        if (navItemIndex == 3) {
            getMenuInflater().inflate(R.menu.notifications, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
            return true;
        }

        // user is in notifications fragment
        // and selected 'Mark all as Read'
        if (id == R.id.action_mark_all_read) {
            Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
        }

        // user is in notifications fragment
        // and selected 'Clear All'
        if (id == R.id.action_clear_notifications) {
            Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    // show or hide the fab
    private void toggleFab() {
        if (navItemIndex == 0)
            fab.show();
        else
            fab.hide();
    }




















/*

   //Préparation des données article
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Article>>();
        List<Article> matiere = new ArrayList<>();

        for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            listDataHeader.add(monObjetCat.getAttributList().get(i).getNom());
        }

       *//* for(int i = 0 ; i<monObjetCat.getAttributList().size();i++){
            for(int j = 0 ; j < monObjetCat.getAttributList().get(i).getArticles().size();j++){
                matiere.add(monObjetCat.getAttributList().get(i).getArticles().get(j));
            }
        }*//*


        //ajouter les données aux fils
            //matuere
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

    public void showFullScreen (View view){
        Intent intent = new Intent(this,FullScreenActivity.class);
        imageProduit.buildDrawingCache();
        bmp = imageProduit.getDrawingCache();
        byte [] mybyte ;
        mybyte =getBytes(bmp);
        intent.putExtra("Bitmap",mybyte);
        startActivity(intent);
    }*/

}
