package ee.shanel.yogatimerexample

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val activityIntent = Intent(this, TimerActivity::class.java)
            val seconds = parseSeconds()
            if (seconds > 5) {
                activityIntent.putExtra("seconds", seconds)
                startActivity(activityIntent)
            }
            else {
                Snackbar.make(view, "Please enter a number of seconds greater than 5", Snackbar.LENGTH_LONG)
                    .show()
            }

        }
    }

    private fun parseSeconds(): Long {
        if (seconds?.text != null && !seconds?.text.toString().isEmpty()) {
            return seconds.text.toString().toLong()
        }
        return 0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
