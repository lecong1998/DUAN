package gst.trainingcourse.movie_home.Activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.adaptermovie
import gst.trainingcourse.movie_home.movie
import kotlinx.android.synthetic.main.activity_main.*

class FragmentHome : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home_viewflipper?.isAutoStart = true
        home_viewflipper?.flipInterval = 3000
        home_viewflipper?.startFlipping()

        var listmovie : ArrayList<movie> =  ArrayList()

        listmovie.add(movie(R.drawable.anh1,"KaTe"))
        listmovie.add(movie(R.drawable.anh2," The Subcide Squad"))
        listmovie.add(movie(R.drawable.anh3,"Paw Pattrol"))
        listmovie.add(movie(R.drawable.anh4,"Jungle Cruise"))
        listmovie.add(movie(R.drawable.anh5,"Boss Baby"))

        var adapter = adaptermovie(listmovie)

        home_recyclerview_popuplar?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        home_recyclerview_nowplaying?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        home_recyclerview_toprated?.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)

        home_recyclerview_popuplar.adapter = adapter
        home_recyclerview_nowplaying.adapter = adapter
        home_recyclerview_toprated.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentHome()
    }
}