package com.maad.kidsstoriesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val titles = arrayOf(
        "The bee and the grasshopper", "Chicken Little", "The hungry cat",
        "The ugly duckling"
    )
    val sounds = arrayOf(R.raw.bee, R.raw.chicken, R.raw.cat, R.raw.duck)
    val pictures = arrayOf(R.drawable.bee, R.drawable.chicken, R.drawable.cat, R.drawable.duck)
    val stories = arrayOf(
        """
                One day in summer a bee meets a grasshopper. 
                - Buzz, buzz, - says the bee. 
                - Let's make a little house. I can gather honey and carry it to the house. You gather honey and carry it to the house. When winter comes we shall have it to eat. How happy we shall be. 
                - Winter and the cold days are far away, - says the grasshopper. 
                - I don't want to gather honey. I want to play, and be happy. Now, good bye, little Bee, good bye! 
                All summer the bee is busy gathering honey. 
                All summer the grasshopper plays. 
                One day in autumn the grasshopper meets the bee. 
                - The cold days are here now, little Bee, - he says. - Let us make a home. Let us carry your honey to the house. Then we shall have some honey to eat. How happy we shall be! 
                - No, no, - says the little Bee. - It is too late now. Summer is the time to make a house. Summer is the time to gather honey for the winter. I will not live with you. Good bye, grasshopper, good bye! 
                """.trimIndent(),
        """
                Chicken Little likes to walk in the woods. She likes to look at the trees. She likes to smell the flowers. She likes to listen to the birds singing. 
                One day while she is walking an acorn falls from a tree, and hits the top of her little head. 
                - My, oh, my, the sky is falling. I must run and tell the lion about it, - says Chicken Little and begins to run. 
                She runs and runs. By and by she meets the hen. 
                - Where are you going? - asks the hen. 
                - Oh, Henny Penny, the sky is falling and I am going to the lion to tell him about it. 
                - How do you know it? - asks Henny Penny. 
                - It hit me on the head, so I know it must be so, - says Chicken Little. 
                - Let me go with you! - says Henny Penny. - Run, run. 
                So the two run and run until they meet Ducky Lucky. 
                - The sky is falling, - says Henny Penny. - We are going to the lion to tell him about it. 
                - How do you know that? - asks Ducky Lucky. 
                - It hit Chicken Little on the head, - says Henny Penny. 
                - May I come with you? - asks Ducky Lucky. 
                - Come, - says Henny Penny. 
                So all three of them run on and on until they meet Foxey Loxey. 
                - Where are you going? - asks Foxey Loxey. 
                - The sky is falling and we are going to the lion to tell him about it, - says Ducky Lucky. 
                - Do you know where he lives? - asks the fox. 
                - I don't, - says Chicken Little. 
                - I don't, - says Henny Penny. 
                - I don't, - says Ducky Lucky. 
                - I do, - says Foxey Loxey. - Come with me and I can show you the way. 
                He walks on and on until he comes to his den. 
                - Come right in, - says Foxey Loxey. 
                They all go in, but they never, never come out again. 
                """.trimIndent(),
        """
                A hungry cat is looking for something to eat. She sees a little grey mouse sitting near his house. 
                - I want to catch that little mouse, - says the hungry cat. 
                She sits down and begins to cry "mew, mew, mew". 
                The little grey mouse jumps up to run into his house, but the cat sits still and mews again. 
                - She is sitting still, - thinks the mouse. 
                - She doesn't want to catch me. I shall not run away. 
                - Mew, mew, mew, - says the cat again. 
                - Why are you crying? - asks the mouse. 
                - See, I have a penny in my hand. 
                - Good, you are lucky. That's nothing to cry about, - says the mouse. 
                The hungry cat comes nearer. 
                - Oh, little mouse, I shall get some meat with the penny. I shall cook it and have it for supper. 
                - Good, you are lucky. That's nothing to cry about. 
                The hungry cat comes nearer and nearer. 
                - There lives a hungry dog in this house. He will eat all the meat. 
                - Poor Pussy, - says the mouse. - What will you eat then? 
                - You, - cries the cat and jumps at the little grey mouse. 
                But the mouse is too quick. He jumps into his little house before the cat can say another "mew". 
                - No, no, sly Pussy, - says the mouse. - You will not eat me. You must first catch me. 
                """.trimIndent(),
        """It is a beautiful summer day. The sun shines warmly on an old house near a river. Behind the house a mother duck is sitting on ten eggs. "Tchick." One by one all the eggs break open. 
All except one. This one is the biggest egg of all. 
Mother duck sits and sits on the big egg. At last it breaks open, "Tchick, tchick!" 
Out jumps the last baby duck. It looks big and strong. It is grey and ugly. 
The next day mother duck takes all her little ducks to the river. She jumps into it. All her baby ducks jump in. The big ugly duckling jumps in too. 
They all swim and play together. The ugly duckling swims better than all the other ducklings. 
- Quack, quack! Come with me to the farm yard! - says mother duck to her baby ducks and they all follow her there. The farm yard is very noisy. The poor duckling is so unhappy there. The hens peck him, the rooster flies at him, the ducks bite him, the farmer kicks him. 
At last one day he runs away. He comes to a river. He sees many beautiful big birds swimming there. Their feathers are so white, their necks so long, their wings so pretty. The little duckling looks and looks at them. He wants to be with them. He wants to stay and watch them. He knows they are swans. Oh, how he wants to be beautiful like them. 
Now it is winter. Everything is white with snow. The river is covered with ice. The ugly duckling is very cold and unhappy. 
Spring comes once again. The sun shines warmly. Everything is fresh and green. 
One morning the ugly duckling sees the beautiful swans again. He knows them. He wants so much to swim with them in the river. But he is afraid of them. He wants to die. So he runs into the river. He looks into the water. There in the water he sees a beautiful swan. It is he! He is no more an ugly duckling. He is a beautiful white swan.
""".trimIndent()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, titles)
        val list: ListView = findViewById(R.id.lv)
        list.adapter = adapter

        list.setOnItemClickListener { _, _, position, _ ->

            val i = Intent(this, StoryActivity::class.java)
            i.putExtra("title", titles[position])
            i.putExtra("picture", pictures[position])
            i.putExtra("story", stories[position])
            i.putExtra("sound", sounds[position])
            startActivity(i)
        }

    }

    fun openSettings(view: View) {
        val i = Intent(this, SettingsActivity::class.java)
        startActivity(i)
    }

}