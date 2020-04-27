package ie.ics.sharedprefswithrecycler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import ie.ics.sharedprefswithrecycler.adapter.ToDoAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener { view ->
 /*
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show() */

            val intent = Intent(this, CreateToDoActivity::class.java)
            startActivity(intent)
        }








       /* var todos = listOf("one","two","three","four","five","six")

        layoutManager = LinearLayoutManager(this)
        recyclerViewToDo.layoutManager = layoutManager
        adapter = ToDoAdapter(todos)
        recyclerViewToDo.adapter = adapter */
    }


    override fun onResume() {
        super.onResume()
        /*
        // used for initial recycler setup

        var todos = listOf("one","two","three","four","five","six","one","two","three","four","five","six","one","two","three","four","five","six",
            "one","two","three","four","five","six","one","two","three","four","five","six","one","two","three","four","five","six","one","two","three","four","five","six","one","two","three","four","five","six")

  */

        var prefs = getSharedPreferences(
            getString(R.string.SHARED_PREFS_PACKAGE),
            Context.MODE_PRIVATE
        )

        var todos = prefs.getStringSet( getString(R.string.TODO_ITEMS), setOf())?.toMutableSet()

        todos?.forEach{ e ->   Log.i(getString(R.string.MAIN_ACTIVITY_LOG), e)}



        layoutManager = LinearLayoutManager(this)
        recyclerViewToDo.layoutManager = layoutManager
        if (todos != null) {
            Log.i(getString(R.string.MAIN_ACTIVITY_LOG), "adding todos to the adapter")
            Log.i(getString(R.string.MAIN_ACTIVITY_LOG), "Count is " + todos.count())
            todos?.forEach{ e ->   Log.i(getString(R.string.MAIN_ACTIVITY_LOG), e)}
            adapter = ToDoAdapter(todos.toList())
        }
        recyclerViewToDo.adapter = adapter

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
