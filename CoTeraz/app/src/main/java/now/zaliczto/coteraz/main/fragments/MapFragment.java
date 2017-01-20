package now.zaliczto.coteraz.main.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import now.zaliczto.coteraz.R;
import now.zaliczto.coteraz.main.models.News;
import now.zaliczto.coteraz.main.onFragmentClick;
import now.zaliczto.coteraz.main.retrofit.Rest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static now.zaliczto.coteraz.main.addons.Tools.showErrorToast;
import static now.zaliczto.coteraz.main.fragments.MenuFragment.choose;

/**
 * Created by zeno on 2016-12-09.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback ,GoogleMap.OnInfoWindowClickListener{

    //private GoogleMap mMap;
    private View view;
    News news;
    List<News> pobrane;
    HashMap<Marker, News> mapa = new HashMap<Marker, News>();

    private Marker marker;
   // private GoogleMap mMap;
    private GoogleMap mMap;
    onFragmentClick mapListener;

    public static MapFragment newInstance() {

        Bundle args=new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
       try {
           view = inflater.inflate(R.layout.map, container, false);
       }catch (Exception e){}
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onFragmentClick) {
            mapListener = (onFragmentClick) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnActivityClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mapListener = null;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mMap == null) {
            final SupportMapFragment fragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
            fragment.getMapAsync(this);
            switch (choose){
                case 1:
                    loadDatanudy();
                    break;
                case 2:
                    loadDatazakupy();
                    break;
                case 3:
                    loadDatazmeczenie();
                    break;
                case 4:
                    loadDataglod();
                    break;
                case 5:
                    loadDatanaprawa();
                    break;
                case 6:
                    loadDatapieniadze();
                    break;
            }



         //   if(choose==1){
             //-   loadDatanudy();
      //      }
        }
        else {
            mMap.setMyLocationEnabled(true);


            LocationManager loctionManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = loctionManager.getBestProvider(criteria,true);
            Location location = loctionManager.getLastKnownLocation(provider);


            LocationListener lisenerLok = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //  drawMarker(location);



                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };
            if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            loctionManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,100, lisenerLok);
            loctionManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,100, lisenerLok);
        }

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;
        if (mMap != null) {
         //   loadDatanudy();
            Log.v("Po danych","Tutaj");

            mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                @Override
                public void onMapLoaded() {
                    if (mMap != null) {
                        if (pobrane != null) {
                           // Log.v("Newsss",news.info);
                            for (News station : pobrane) {
                                LatLng point = new LatLng(station.getLat(), station.getLng());
                                marker = mMap.addMarker(new MarkerOptions()
                                        .position(point)
                                        .title(station.name)
                                        .snippet(station.adres)
                                        .icon(getMarkerIcon()));

                                 goToLocationZoom(station.getLat(), station.getLng(), 12);
                                mapa.put(marker, station);
                            }
                        } else {
                            Toast.makeText(getActivity(), "Czekaj na internet", Toast.LENGTH_LONG);
                        }

                    }
                }
            });
            mMap.setOnInfoWindowClickListener(this);
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    goToLocationZoom(marker.getPosition().latitude + 0.005, marker.getPosition().longitude, 13);
                    return false;
                }
            });
            if (mMap != null) mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {

                    View v = LayoutInflater.from(getActivity()).inflate(R.layout.windowlayout, null);
                    TextView tvLocality = (TextView) v.findViewById(R.id.tvlocality);
                    ImageView info_ic = (ImageView) v.findViewById(R.id.info_icon);
                    tvLocality.setText(marker.getTitle());
                    return v;
                }

            });
        }
        }

    @Override
    public void onInfoWindowClick(Marker marker) {

        Bundle bundle = new Bundle();
        News station = mapa.get(marker);
        if (station != null) {
            bundle.putParcelable("News", station);
        }
        if (mMap != null) {
            mapListener.navigatetoMarkerDetails(bundle);
        }
    }
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


    private void goToLocationZoom(double lat, double lng, float zoom) {



        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);

    }
    private BitmapDescriptor getMarkerIcon() {

        if (choose==1) {
            return BitmapDescriptorFactory.fromResource(R.drawable.bored);
        } else if (choose==2) {
            return BitmapDescriptorFactory.fromResource(R.drawable.shop);
        } else if (choose==3) {
           return BitmapDescriptorFactory.fromResource(R.drawable.tired);
        }else if (choose==4){
            return BitmapDescriptorFactory.fromResource(R.drawable.hungry);

        }else if(choose==5){
            return BitmapDescriptorFactory.fromResource(R.drawable.repair);

        }else {
            return BitmapDescriptorFactory.fromResource(R.drawable.money);

        }


    }
    public void loadDataglod(){
        
    
        Rest.getCityService().loadDataglod().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();

                pobrane =response.body();
             //   for (News c : pobrane) 
                    
                
//                Picasso.with(getActivity().getApplicationContext())
//                        .load("http://x3.cdn03.imgwykop.pl/c3201142/comment_LhwU2c5Bbqvvgn1KJZUNpnvPqvOcwdNN,w400.jpg")
//                        .into(impic);
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });

    }
    public void loadDatazmeczenie(){


        Rest.getCityService().loadDatazmeczenie().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();
                pobrane =response.body();
      


            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    public void loadDatazakupy(){


        Rest.getCityService().loadDatazakupy().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();
                pobrane =response.body();
    


            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    public void loadDatanudy(){


        Rest.getCityService().loadDatanuda().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();

                pobrane =response.body();

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    public void loadDatapieniadze(){


        Rest.getCityService().loadDatapieniadze().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();

                pobrane =response.body();

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
    public void loadDatanaprawa(){


        Rest.getCityService().loadDatanaprawa().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                pobrane = new ArrayList<News>();

                pobrane =response.body();

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                showErrorToast();
                Toast.makeText(getContext(),"FAILED", Toast.LENGTH_SHORT).show();;

            }
        });
    }
}
