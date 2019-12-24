package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue(String pictureName)
  {
    Picture beach = new Picture(pictureName);
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue(String pictureName)
  {
    Picture beach = new Picture(pictureName);
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }

  /** Method to test keepOnlyRed */
  public static void testKeepOnlyRed(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.keepOnlyRed();
    picture.explore();
  }

  /** Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.keepOnlyGreen();
    picture.explore();
  }

  /** Method to test negate */
  public static void testNegate(String pictureName)
  {
    Picture beach = new Picture(pictureName);
    beach.explore();
    beach.negate();
    beach.explore();
  }

  /** Method to test grayscale*/
  public static void testGrayscale(String pictureName)
  {
    Picture beach = new Picture(pictureName);
    beach.explore();
    beach.grayscale();
    beach.explore();
  }

  /** Method to test fixUnderwater*/
  public static void testFixUnderwater(String pictureName)
  {
    Picture sea = new Picture(pictureName);
    sea.explore();
    sea.fixUnderwater();
    sea.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  /** method to test mirrorVerticalLeftToRight*/
  public static void testMirrorVerticalLeftToRight(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.mirrorVerticalRightToLeft();
    picture.explore();
  }

  /** Method to test mirrorHorizontalTopToBottom */
  public static void testMirrorHorizontalTopToBottom(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.mirrorHorizontalTopToBottom();
    picture.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue("water.jpg");
    //testKeepOnlyBlue("water.jpg"); // greg
    //testKeepOnlyRed("water.jpg");//greg
    //testKeepOnlyGreen("water.jpg");//greg
    //testNegate("water.jpg");// greg
    //testGrayscale("water.jpg"); // greg
    //testFixUnderwater("water.jpg");//greg not done confused
    //testMirrorVertical();
    //testMirrorTemple();
    testMirrorVerticalLeftToRight("water.jpg"); //greg
    testMirrorHorizontalTopToBottom("redMotorcycle.jpg");
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}