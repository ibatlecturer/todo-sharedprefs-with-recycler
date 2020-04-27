package ie.ics.sharedprefswithrecycler.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.ics.sharedprefswithrecycler.R
import kotlinx.android.synthetic.main.todo_row.view.*

// once you add the adapter you will need to implement the members
class ToDoAdapter(var todos: List<String>) : RecyclerView.Adapter<ToDoAdapter.ToDoHolder>() {

    // Alt enter to implement members of the View.OnClickListener

    class ToDoHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        var view: View = v
        var title: String = ""

        init {

            v.setOnClickListener(this)
        }

        fun bindToDo(title: String) {

            this.title = title
            view.textView.text = title
        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
            Log.i("MAINACTIVITY", "item is clicked")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoHolder {
      // TODO("Not yet implemented")

        return ToDoHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_row, parent, false))
    }

    override fun getItemCount(): Int {
       return todos?.count()
    }

    override fun onBindViewHolder(holder: ToDoHolder, position: Int) {
       // TODO("Not yet implemented")

        var title = todos[position]
        holder.bindToDo(title)
    }

}