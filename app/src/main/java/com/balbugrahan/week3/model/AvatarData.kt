package com.balbugrahan.week3.model

import com.balbugrahan.week3.R
import java.io.Serializable

data class AvatarData (var ImageId : Int):Serializable{

    var ImageId1 = ImageId

    // If we would like to call this data , it should be companion object
    companion object{
     fun ImageData() : MutableList<AvatarData> {
        ///we are creating data for list
         val avatarData = AvatarData(R.drawable.ic_avatar01)
         val avatarData1 = AvatarData(R.drawable.ic_avatar02)
         val avatarData2 = AvatarData(R.drawable.ic_avatar03)
         val avatarData3 = AvatarData(R.drawable.ic_avatar04)
         val avatarData4 = AvatarData(R.drawable.ic_avatar05)
         val avatarData5 = AvatarData(R.drawable.ic_avatar06)
         val avatarData6 = AvatarData(R.drawable.ic_avatar07)
         val avatarData7 = AvatarData(R.drawable.ic_avatar08)
         val avatarData8 = AvatarData(R.drawable.ic_avatar09)
         val avatarData9 = AvatarData(R.drawable.ic_avatar01)
         val avatarData10 = AvatarData(R.drawable.ic_avatar02)
         val avatarData11 = AvatarData(R.drawable.ic_avatar03)
         val avatarData12 = AvatarData(R.drawable.ic_avatar04)
         val avatarData13 = AvatarData(R.drawable.ic_avatar05)
         val avatarData14 = AvatarData(R.drawable.ic_avatar06)
         val avatarData15 = AvatarData(R.drawable.ic_avatar07)
         val avatarData16 = AvatarData(R.drawable.ic_avatar08)
         val avatarData17 = AvatarData(R.drawable.ic_avatar09)
         val avatarData18 = AvatarData(R.drawable.ic_avatar01)

        // Below , added some data for generating list
         val avatarList = mutableListOf<AvatarData>(
             avatarData,
             avatarData1,
             avatarData2,
             avatarData3,
             avatarData4,
             avatarData5,
             avatarData6,
             avatarData7,
             avatarData8,
             avatarData9,
             avatarData10,
             avatarData11,
             avatarData12,
             avatarData13,
             avatarData14,
             avatarData15,
             avatarData16,
             avatarData17,avatarData18
         )

         return avatarList
     }

    }



}