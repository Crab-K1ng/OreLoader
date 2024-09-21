package io.github.CrabK1ng.OreLoader;

import finalforeach.cosmicreach.blocks.Block;

public class OreList {;
   public String blockId;
   public String tagsOfBlocksToReplace;
   public int MaxElevation;
   public int MinElevation;
   public int MaxOresPerCluster;
   public int AttemptsPerColumn;

   public OreList setOre(String blockId, String tagsOfBlocksToReplace, int MaxElevation, int MinElevation, int MaxOresPerCluster, int AttemptsPerColumn) {
      this.blockId = blockId;
      this.tagsOfBlocksToReplace = tagsOfBlocksToReplace;
      this.MaxElevation = MaxElevation;
      this.MinElevation = MinElevation;
      this.MaxOresPerCluster = MaxOresPerCluster;
      this.AttemptsPerColumn = AttemptsPerColumn;
      return this;
   }

   public boolean isEmpty() {
      if (this.blockId == null) {
         return true;
      } else {
         Block block = Block.getById(blockId);
         if (block == null) {
            throw new NullPointerException("Missing block for id: " + blockId);
         }
         return false;
      }
   }
}
