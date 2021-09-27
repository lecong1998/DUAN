package gst.trainingcourse.movie_home.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.adaptermovie
import gst.trainingcourse.movie_home.movie
import kotlinx.android.synthetic.main.fragment_t_v__airing__today_.*
import kotlinx.android.synthetic.main.fragmentpopular.*

class TV_Airing_Today_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_v__airing__today_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_recycleview_airingtoday?.layoutManager = GridLayoutManager(activity,2, GridLayoutManager.VERTICAL,false)
        var listmovie : ArrayList<movie> =  ArrayList()

        listmovie.add(movie(R.drawable.anh1,"KaTe"))
        listmovie.add(movie(R.drawable.anh2," The Subcide Squad"))
        listmovie.add(movie(R.drawable.anh3,"Paw Pattrol"))
        listmovie.add(movie(R.drawable.anh4,"Jungle Cruise"))
        listmovie.add(movie(R.drawable.anh5,"Boss Baby"))

        var adapter = adaptermovie(listmovie)
        tv_recycleview_airingtoday.adapter = adapter

    }
}