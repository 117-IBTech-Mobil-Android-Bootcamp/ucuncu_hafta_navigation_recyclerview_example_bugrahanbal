package com.balbugrahan.week3.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.balbugrahan.week3.R
import com.balbugrahan.week3.model.AvatarData

class Adapter(avatarList: MutableList<AvatarData>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){



    //Position for checking
    var checkedItemPosition = -1
    var lastItemCheckedPosition = -1

    //Companion object because it will be calling in FragmentProfileDetails Page
    companion object {
        var AVATAR_ROW = 1234
        var TITLE_ROW = 123
    }
    var checkedPosition = 0
    var avatarList1 = avatarList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        //Created for Viewholder to present avatars row
        if(viewType == AVATAR_ROW) { return  avatarRowViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_avatar, parent, false))
    }else{
        //Title Row
        return titleRowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_title, parent,
                false))
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //Avatar Row Bind
      if(holder is avatarRowViewHolder){
        var avatars = this.avatarList1[position]
        (holder as avatarRowViewHolder).apply {
            holder.setData(avatars) // retrive data

            if(position == checkedItemPosition)
                holder.checkboxChecked() //check func call
            else
                holder.checkboxUnchecked() //uncheck func call
        }//Title row bind
      }else if (holder is titleRowViewHolder){

      }
    }

    override fun getItemViewType(position: Int): Int {
        // View type for different two types
        return if(position==0) TITLE_ROW else AVATAR_ROW
        //One of them title row , other avatar
    }

    override fun getItemCount(): Int {
        return avatarList1.size // count for recyler's row
    }


   // Viewholder for avatars
 inner   class avatarRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //we are matching view
        var avatar2: ImageView = itemView.findViewById(R.id.imageViewAvatar)

        //created func for retreive data
        fun setData(avatar: AvatarData) {
            avatar2.setImageResource(avatar.ImageId)
        }

       //created box for checking under the all avatars
        private val checkBox: ImageView = itemView.findViewById(R.id.imageViewUnCheck)


         fun checkboxChecked() {  //check func created
         checkBox.setImageResource(R.drawable.ic_checked)
        }

         fun checkboxUnchecked() { //uncheck func created
         checkBox.setImageResource(R.drawable.ic_unchecked)
         }
       //item click for checking or unchecking
         init {
             itemView.setOnClickListener {
             checkedItemPosition = adapterPosition
             if(lastItemCheckedPosition == -1)
                 lastItemCheckedPosition = checkedItemPosition
             else {
                 notifyItemChanged(lastItemCheckedPosition)
                 lastItemCheckedPosition = checkedItemPosition
             }
             notifyItemChanged(checkedItemPosition)
             }
        }


    }

 // View Holder for title
inner  class titleRowViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var titleImageView : ImageView = itemView.findViewById(R.id.imageViewTitle)
    }

}




