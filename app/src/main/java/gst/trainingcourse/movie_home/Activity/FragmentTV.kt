package gst.trainingcourse.movie_home.Activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gst.trainingcourse.movie_home.R
import gst.trainingcourse.movie_home.film.*
import gst.trainingcourse.movie_home.tv.TV_Airing_Today_Fragment
import gst.trainingcourse.movie_home.tv.TV_Ontv_Fragment
import gst.trainingcourse.movie_home.tv.TV_Popular_Fragment
import gst.trainingcourse.movie_home.tv.TV_TopRated_Fragment
import kotlinx.android.synthetic.main.activity_film.*
import kotlinx.android.synthetic.main.activity_tv.*

class FragmentTV : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t_v, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterPageview = activity?.supportFragmentManager?.let { adapter_pageView(it) }
        adapterPageview?.addFragment(TV_Popular_Fragment(),"Popular TV")
        adapterPageview?.addFragment(TV_Airing_Today_Fragment(),"Airing To day")
        adapterPageview?.addFragment(TV_Ontv_Fragment(), "On TV")
        adapterPageview?.addFragment(TV_TopRated_Fragment(), "Top Rated")
        viewpager_tv?.adapter = adapterPageview
        tablayout_tv?.setupWithViewPager(viewpager_tv)
    }


    companion object {
        @JvmStatic
        fun newInstance() = FragmentTV()
    }
}