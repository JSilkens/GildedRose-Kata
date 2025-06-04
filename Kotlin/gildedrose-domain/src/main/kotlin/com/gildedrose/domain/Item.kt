package com.gildedrose.domain

open class Item(
    var name: String,
    var sellIn: Int,
    var quality: Int,
) {
    override fun toString(): String = "$name, $sellIn, $quality"
}