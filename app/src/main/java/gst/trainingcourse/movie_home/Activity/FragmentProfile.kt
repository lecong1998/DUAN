package gst.trainingcourse.movie_home.Activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import gst.trainingcourse.movie_home.Profile.adapter_profile
import gst.trainingcourse.movie_home.Profile.item
import gst.trainingcourse.movie_home.R
import kotlinx.android.synthetic.main.fragment_profile.*

class FragmentProfile : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listtittle = ArrayList<item>()
        listtittle.add(item(R.drawable.ic_baseline_person_pin_24.toInt(),"Lê Công","Thông tin cá nhân"))
        listtittle.add(item(R.drawable.ic_baseline_home_24.toInt(),"Home",""))
        listtittle.add(item(R.drawable.ic_baseline_folder_24.toInt(),"Phim",""))
        listtittle.add(item(R.drawable.ic_baseline_desktop_windows_24.toInt(),"TV",""))
        listtittle.add(item(R.drawable.ic_baseline_search_24.toInt(),"Search",""))
        listtittle.add(item(R.drawable.ic_baseline_notifications_24.toInt(),"Thông báo",""))
        listtittle.add(item(R.drawable.ic_baseline_notification_important_24.toInt(),"Bảo Mật",""))
        listtittle.add(item(R.drawable.ic_baseline_login_24.toInt(),"Đăng xuất",""))
        val adapter = adapter_profile(listtittle)
        profile_recyclerview?.layoutManager = LinearLayoutManager(activity)
        profile_recyclerview.adapter = adapter

    }
}