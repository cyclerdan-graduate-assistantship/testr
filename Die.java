//********************************************************************
//  Die.java       Author: Lewis/Loftus, modified by P.M.J.
//                 Date:   October 2017
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and 6.
//********************************************************************

public class Die {
   private final int MAX = 6;       // maximum face value constant
   private final int DEFAULT = 1;   // default face value constant
   
   private int faceValue;           // current value showing on the die

   private int next = 0;
   private int[] fv = {4,3,3,1,4,4,3,1,4,3,4,2,2,4,1,5,4,3,6,6,1,1,5,4,3,2,5,3,4,4,1,1};
   //private int[] fv = {5,1,2,3,5,2,1,2,4,3,3,3,3,5,6,3,5,5,6,3,3,2,5,5,1};
   //-----------------------------------------------------------------
   //  Constructor: Sets the initial face value.
   //-----------------------------------------------------------------
   public Die() {
      faceValue = DEFAULT;
   }

   //-----------------------------------------------------------------
   //  Mutator: Rolls the Die thus changing its state and face value.
   //-----------------------------------------------------------------
   public void roll() {
      //faceValue = (int)(Math.random() * MAX) + 1;
      if(next == fv.length) {
         next = 0;
      }
      faceValue = fv[next];
      next = next + 1;
   }

   //-----------------------------------------------------------------
   //  Mutator: Sets the Die's face value to the given value.
   //-----------------------------------------------------------------
   public void setFaceValue (int value) {
      if((value < 1) || (value > MAX)) {
         throw new IllegalArgumentException("Invalid Die face value");
      } 
      else {
         faceValue = value;
      }
   }

   //-----------------------------------------------------------------
   //  Accessor: Returns the current face value.
   //-----------------------------------------------------------------
   public int getFaceValue() {
      return faceValue;
   }

   //-----------------------------------------------------------------
   //  Returns a string representation of this die.
   //-----------------------------------------------------------------
   public String toString() {
      return "[" + faceValue + "]";
   }
}
