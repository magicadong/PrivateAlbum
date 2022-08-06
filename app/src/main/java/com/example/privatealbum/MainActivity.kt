package com.example.privatealbum

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.privatealbum.databinding.ActivityMainBinding
import com.example.privatealbum.db.ALBUM_TYPE_IMAGE
import com.example.privatealbum.db.ALBUM_TYPE_VIDEO
import com.example.privatealbum.db.SharedViewModel
import com.example.privatealbum.home.ClickEvents

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    private val model:SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.model = model
        binding.clickEvent = ClickEvents()
        binding.lifecycleOwner = this

        //去掉BottomNavigationView的背景
        binding.bottomNavigationView.background = null
        //让第二个menuitem不能被点击
        binding.bottomNavigationView.menu.getItem(1).isEnabled = false
        //给BottomNavigationView设置navController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.navController)

        //监听选项的点击事件
        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.imageAlbumFragment){
                model.type = ALBUM_TYPE_IMAGE
            }else{
                model.type = ALBUM_TYPE_VIDEO
            }
            true
        }
    }

    fun showBottomNavigationView(){
        if (binding.bottomAppBar.alpha.equals(0f)){
            binding.bottomAppBar.alpha = 1f
            ObjectAnimator.ofFloat(
                binding.bottomAppBar,
                "translationY",
                binding.bottomAppBar.height.toFloat(),
                0f
            ).apply {
                duration = 500
                start()
            }

            ObjectAnimator.ofFloat(
                binding.floatingActionButton,
                "alpha",
                1f
            ).apply {
                duration = 500
                start()
            }
        }
    }

    fun hideBottomNavigationView(){

        ObjectAnimator.ofFloat(
            binding.bottomAppBar,
            "translationY",
            0f,
            binding.bottomAppBar.height.toFloat()
        ).apply {
            duration = 500
            start()
        }


        ObjectAnimator.ofFloat(
            binding.floatingActionButton,
            "alpha",
            1f,0f
        ).apply {
            duration = 500
            start()
        }
    }
}

















