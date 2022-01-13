package com.example.dicerollerapplication

import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
  fun generates_number() {
      val dice = Dice(6)
      val rollResult = dice.roll()
      assertTrue("The rolled number was not in the range of the dice!", rollResult in 1..6)
  }
}