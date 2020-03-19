package com.maruiz.composeworkshop.presentation.extensions

import com.maruiz.composeworkshop.R

fun String.convertToResource(): Int =
    when (this) {
        "anna_karenina" -> R.drawable.anna_karenina
        "to_kill_a_mockingbird" -> R.drawable.to_kill_a_mockingbird
        "the_great_gatsby" -> R.drawable.the_great_gatsby
        "in_search_of_lost_time" -> R.drawable.in_search_of_lost_time
        "don_quixote" -> R.drawable.don_quixote
        "ulysses" -> R.drawable.ulysses
        "moby_dick" -> R.drawable.moby_dick
        "hamlet" -> R.drawable.hamlet
        "war_and_peace" -> R.drawable.war_and_peace
        "the_odyssey" -> R.drawable.the_odyssey
        else -> R.drawable.war_and_peace
    }