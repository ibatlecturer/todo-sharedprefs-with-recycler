package ie.ics.sharedprefswithrecycler

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_create_to_do.*

class CreateToDoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        buttonSaveToDo.setOnClickListener {

            var title = ""
            if (cbImportant.isChecked) {
                title = "❗️" + editText.text.toString()

            } else {
                title = editText.text.toString()

            }

            Log.i(getString(R.string.MAIN_ACTIVITY_LOG), title)

            var prefs = getSharedPreferences(
                getString(R.string.SHARED_PREFS_PACKAGE),
                Context.MODE_PRIVATE
            )

            var todos = prefs.getStringSet(getString(R.string.TODO_ITEMS), setOf())?.toMutableSet()
            todos?.add(title)
            prefs.edit().putStringSet(getString(R.string.TODO_ITEMS), todos).apply()

            finish()


        }
    }
}
