package gst.trainingcourse.movie_home.film

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.adaptermovie
import gst.trainingcourse.movie_home.movie
import kotlinx.android.synthetic.main.fragmentnowplaying.*
import kotlinx.android.synthetic.main.fragmentpopular.*

class FragmentNowPlaying : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentnowplaying,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycleview_nowplaying?.layoutManager = GridLayoutManager(activity,2, GridLayoutManager.VERTICAL,false)
        var listmovie : ArrayList<movie> =  ArrayList()

        listmovie.add(movie(R.drawable.anh1,"KaTe"))
        listmovie.add(movie(R.drawable.anh2," The Subcide Squad"))
        listmovie.add(movie(R.drawable.anh3,"Paw Pattrol"))
        listmovie.add(movie(R.drawable.anh4,"Jungle Cruise"))
        listmovie.add(movie(R.drawable.anh5,"Boss Baby"))

        var adapter = adaptermovie(listmovie)
        recycleview_nowplaying.adapter = adapter

    }
}