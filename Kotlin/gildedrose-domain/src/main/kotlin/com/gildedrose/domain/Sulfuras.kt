package com.gildedrose.domain

class Sulfuras(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}