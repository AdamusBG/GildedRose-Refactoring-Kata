package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

class GildedRoseTest {

    // Normal item (no special name) tests
    @Test
    void normDecreasesQualityBy1WhenSellInAbove0() {
        Item[] items = new Item[] { new Item("Normal", 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);
    }
    @Test
    void normDecreasesQualityBy2WhenSellInAt0() {
        Item[] items = new Item[] { new Item("Normal", 0, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }
    @Test
    void normDecreasesQualityBy2WhenSellInBelow0() {
        Item[] items = new Item[] { new Item("Normal", -10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Normal", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }
    @Test
    void normMinQualityIs0() {
        Item[] items = new Item[] { new Item("Normal", -10, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 10; i++) {
          app.updateQuality();
        }
        assertEquals("Normal", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }

    // Aged Brie tests
    @Test
    void agedBrieIncreasesQualityBy1WhenSellInAbove0() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void agedBrieIncreasesQualityBy2WhenSellInAt0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void agedBrieIncreasesQualityBy2WhenSellInBelow0() {
        Item[] items = new Item[] { new Item("Aged Brie", -10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void agedBrieMaxQualityIs50() {
        Item[] items = new Item[] { new Item("Aged Brie", -10, 40) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 10; i++) {
          app.updateQuality();
        }
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(50, app.items[0].quality);
    }

    // Sulfuras Hand of Ragnaros tests
    @Test
    void sulfurasNotAffectedByAnyUpdates() {
      Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
      GildedRose app = new GildedRose(items);
      for (int i = 0; i < 10; i++) {
          app.updateQuality();
      }
      assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
      assertEquals(10, app.items[0].sellIn);
      assertEquals(80, app.items[0].quality);
    }

    // Backstage passes to a TAFKAL80ETC concert tests
    @Test
    void passesIncreasesQualityBy1WhenSellInAbove10() {
        int startingSellIn = this.getRandomNumberInRangeInclusive(11, 50);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals((startingSellIn - 1), app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }
    @Test
    void passesIncreasesQualityBy2WhenSellIn6To10() {
        int startingSellIn = this.getRandomNumberInRangeInclusive(6, 10);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals((startingSellIn - 1), app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }
    @Test
    void passesIncreasesQualityBy3WhenSellIn1To5() {
        int startingSellIn = this.getRandomNumberInRangeInclusive(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals((startingSellIn - 1), app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }
    @Test
    void passesReducedTo0QualityWhenSellIn0AndBelow() {
        int startingSellIn = this.getRandomNumberInRangeInclusive(-50, 0);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals((startingSellIn - 1), app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    @Test
    void passesMaxQualityIs50() {
        int startingSellIn = this.getRandomNumberInRangeInclusive(1, 5);
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 45) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 4; i++) {
          app.updateQuality();
        }
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(50, app.items[0].quality);
    }

    // Conjured tests
    @Test
    void conjuredDecreasesQualityBy2WhenSellInAbove0() {
        Item[] items = new Item[] { new Item("Conjured", 10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }
    @Test
    void conjuredDecreasesQualityBy4WhenSellInAt0() {
        Item[] items = new Item[] { new Item("Conjured", 0, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }
    @Test
    void conjuredDecreasesQualityBy4WhenSellInBelow0() {
        Item[] items = new Item[] { new Item("Conjured", -10, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured", app.items[0].name);
        assertEquals(-11, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }
    @Test
    void conjuredMinQualityIs0() {
        Item[] items = new Item[] { new Item("Conjured", -10, 10) };
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 10; i++) {
          app.updateQuality();
        }
        assertEquals("Conjured", app.items[0].name);
        assertEquals(0, app.items[0].quality);
    }

    // Test helper methods
    private static int getRandomNumberInRangeInclusive(int min, int max) {
      Random r = new Random();
      return r.nextInt((max - min) + 1) + min;
    }
}
