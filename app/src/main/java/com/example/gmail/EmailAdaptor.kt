package com.example.gmail
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView;
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zybooks.codepathmail.Email

public class EmailAdaptor {
    class EmailAdapter(
        private val emails:List<Email>) :RecyclerView.Adapter<EmailAdapter.ViewHolder>()

    {
        class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {


            // TODO: Create member variables for any view that will be set
            // as you render a row.
            val senderTextView:TextView
            val titleTextView:TextView
            val summaryTextView:TextView

            // We also create a constructor that accepts the entire item row
            // and does the view lookups to find each sub-view
            init {
                // TODO: Store each of the layout's views into
                // the public final member variables created above
                senderTextView = itemView.findViewById(R.id.senderTV)
                titleTextView = itemView.findViewById(R.id.titleTV)
                summaryTextView = itemView.findViewById(R.id.summaryTV)
            }
        }
        override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            // Inflate the custom layout
            val contactView = inflater.inflate(R.layout.email_item, parent, false)
            // Return a new holder instance
            return ViewHolder(contactView)
        }
        // Populate data into the item through the holder
        override fun onBindViewHolder(holder:ViewHolder, position:Int){
            // Get the data model based on position
            val email = emails.get(position)
            // Set item views based on views and data model
            holder.senderTextView.text = email.sender
            holder.titleTextView.text = email.title
            holder.summaryTextView.text = email.summary
        }
        override fun getItemCount():Int {
            return emails.size
        }
    }
}