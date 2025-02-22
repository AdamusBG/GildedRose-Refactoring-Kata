package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final int maxQuality = 50;
    public static final int minQuality = 0;
    public static final int sulfurasQuality = 80;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
          if (items[i].name.equals("Aged Brie")) {
            this.updateAgedBrie(items[i]);
          } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
            this.updateSulfuras(items[i]);
          } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            this.updateBackstagePass(items[i]);
          } else if (items[i].name.equals("Conjured")) {
            this.updateConjured(items[i]);
          } else {
            this.updateNormal(items[i]);
          }

          if (items[i].quality > this.maxQuality) {
            this.reduceToMaxQuality(items[i]);
          }

          if (items[i].quality < this.minQuality) {
            this.raiseToMinQuality(items[i]);
          }

          this.reduceSellIn(items[i]);
        }
    }

    private void updateAgedBrie(Item item) {
      if (item.sellIn > 0) {
        item.quality += 1;
      }
      if (item.sellIn <= 0) {
        item.quality += 2;
      }
    }

    private void updateSulfuras(Item item) {
      item.quality = this.sulfurasQuality;
    }

    private void updateBackstagePass(Item item) {
      if (item.sellIn >= 11) {
        item.quality += 1;
      } else if (item.sellIn >= 6) {
        item.quality += 2;
      } else if (item.sellIn >= 1) {
        item.quality += 3;
      } else {
        item.quality = 0;
      }
    }

    private void updateConjured(Item item) {
      for (int i = 0; i < 2; i++) {
        this.updateNormal(item);
      }
    }

    private void updateNormal(Item item) {
      if (item.sellIn > 0) {
        item.quality -= 1;
      }
      if (item.sellIn <= 0) {
        item.quality -= 2;
      }
    }

    private void reduceToMaxQuality(Item item) {
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.quality = this.maxQuality;
      }
    }

    private void raiseToMinQuality(Item item) {
      item.quality = this.minQuality;
    }

    private void reduceSellIn(Item item) {
      if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sellIn -= 1;
      }
    }
}
