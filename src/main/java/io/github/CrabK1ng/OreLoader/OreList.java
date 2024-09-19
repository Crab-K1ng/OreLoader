package io.github.CrabK1ng.OreLoader;

public class OreList {;
   public String blockId;
   public int MaxElevation;
   public int MinElevation;
   public int MaxOresPerCluster;
   public int AttemptsPerColumn;

   public OreList setOre(String blockId, int MaxElevation,int MinElevation, int MaxOresPerCluster, int AttemptsPerColumn ) {
      this.blockId = blockId;
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
         return false;
      }
   }

   public String getOutput() {
      return this.blockId;
   }
}
