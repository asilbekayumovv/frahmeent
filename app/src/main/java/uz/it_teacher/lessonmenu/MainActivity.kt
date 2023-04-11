package uz.it_teacher.lessonmenu


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawer = findViewById<View>(R.id.drawer) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer,R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener {
         when(it.itemId){
             R.id.nav_camera->{
                 Toast.makeText(this,"Camera click", Toast.LENGTH_SHORT).show()
                 true
             }
             else -> {
                 true
             }
         }
        }

    }
}