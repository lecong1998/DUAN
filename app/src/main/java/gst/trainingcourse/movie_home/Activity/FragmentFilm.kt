package gst.trainingcourse.movie_home.Activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.film.*
import kotlinx.android.synthetic.main.activity_film.*

class FragmentFilm : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterPageview = activity?.supportFragmentManager?.let { adapter_pageView(it) }
        adapterPageview?.addFragment(FragmentPopular(),"Popular Movie")
        adapterPageview?.addFragment(FragmentNowPlaying(),"Now Playing Movie")
        adapterPageview?.addFragment(FragmentTopRated(), "Top Rated")
        adapterPageview?.addFragment(FragmentUpcoming(), "Up Comming")
        viewpager?.adapter = adapterPageview
        tablayout?.setupWithViewPager(viewpager)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentFilm()

    }
}