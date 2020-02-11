package pixLab.classes;

import java.awt.Color;

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
  
  /** Method to test zeroRed*/
  public static void testZeroRed(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.zeroRed();
      picture.explore();
  }
  
  /** Method to test zeroGreen*/
  public static void testZeroGreen(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.zeroGreen();
      picture.explore();
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
  
  /** Method to test MaxBlue */
  public static void testMaxBlue(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.maxBlue();
      picture.explore();
  }
  
  /** Method to test MaxRed */
  public static void testMaxRed(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.maxRed();
      picture.explore();
  }

  /** Method to test MaxGreen */
  public static void testMaxGreen(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.maxGreen();
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

  /** Method to test mirrorHorizontalBottomToTop */
  public static void testMirrorHorizontalBottomToTop(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.mirrorHorizontalBottomToTop();
    picture.explore();
  }

  /** Method to test mirrorDiagonal */
  public static void testMirrorDiagonal(String pictureName)
  {
    Picture picture = new Picture(pictureName);
    picture.explore();
    picture.mirrorDiagonal();
    picture.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }

  /** Method to test the Copy that takes more parameters */
  public static void testCopy()
  {
    Picture kitten = new Picture("kitten2.jpg");
    Picture cumberlandIsland = new Picture("CumberlandIsland.jpg");
    cumberlandIsland.copy(kitten,457,206,
            87,124,212,342);
    //kitten.explore();
    cumberlandIsland.explore();
    // row 87 to 212 column 124 to 342 kitten size column 218 row 125
    // column 431 2, row 575 6 startRow 457 startColumn 206
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  /** Method to test my collage method */
  public static void testMyCollage()
  {
    Picture canvas = new Picture(480,480);
    canvas.setTitle("myCollage");
    //canvas.explore();
    canvas.createMyCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  /** Method to test edgeDetection2 */
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection2(10);
    swan.explore();
  }

  public static void testEdgeDetection3()
  {
    Picture swan = new Picture( "swan.jpg");
    swan.explore();
    swan.edgeDetection3(10);
    swan.explore();
  }
  
  public static void testZeroColor(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.keepOnlyBlue();
      picture.zeroBlue();
      picture.explore();
  }
  
  public static void testGlitch(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.glitch();
      picture.explore();
  }
  
  public static void testGlitch3(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.glitch3(50);
      picture.explore();
      picture.write("GregoryGlitch");
      picture.edgeDetection2(30);
      picture.explore();
      picture.write("GregoryGlitchEdgeDetection");
  }
  
  public static void testZero(String pictureName)
  {
      Picture zeroGreen = new Picture(pictureName);
      Picture zeroBlue = new Picture(pictureName);
      Picture zeroRed = new Picture(pictureName);
      
      zeroGreen.explore();
      
      zeroGreen.zero(Picture.GREEN, 0, 0, 100, 100);
      zeroGreen.explore();
      zeroBlue.zero(Picture.BLUE,  0, 0, 100, 100);
      zeroBlue.explore();
      zeroRed.zero(Picture.RED, 0, 0, 325, 213);
      zeroRed.explore();
      
  }
  
  public static void testChromakey(String pictureName, String pictureNameBackGround)
  {
      Picture foreground = new Picture(pictureName);
      Picture background = new Picture(pictureNameBackGround);
      
      foreground.explore();
      background.explore();
      
      foreground.chromakey(background, new Color(16,30,50), 30);
      foreground.explore();
  }
  
  public static void chromakeyPictureGood()
  {
      Picture foreground = new Picture("");
      Picture background = new Picture("");
      
      foreground.explore();
      background.explore();
      
      foreground.chromakey(background, new Color(8, 19,50), 30);
      foreground.explore();
  }
  
  public static void testVerticalShift(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.verticalShift(200, 5, 232);
      picture.explore();
  }

  public static void testHorizontalShift(String pictureName)
  {
      Picture picture = new Picture(pictureName);
      picture.explore();
      picture.horizontalShift(200, 5, 232);
      picture.explore();
  }
  
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//      String picture = "blue-mark.jpg";//beach.jpg";
      String picture = "beach.jpg";
      String picture2 = "moon-surface.jpg";
//    testZeroBlue("koala.jpg");
//    testZeroRed("koala.jpg"); // greg
//    testZeroGreen("koala.jpg");// greg
      
//      testMaxBlue(picture); // greg
//      testMaxRed(picture);// greg
//      testMaxGreen(picture);// greg
//    testKeepOnlyBlue(picture); // greg
//    testKeepOnlyRed(picture);//greg
//    testKeepOnlyGreen(picture);//greg
//    testNegate(picture);// greg
//    testGrayscale(picture); // greg
//    testFixUnderwater("water.jpg");//greg not done confused
//    testMirrorVertical();
//    testMirrorVerticalLeftToRight("water.jpg"); //greg
//    testMirrorHorizontalTopToBottom("redMotorcycle.jpg");
//    testMirrorHorizontalBottomToTop("redMotorcycle.jpg"); //greg
//    testMirrorDiagonal("beach.jpg");
//    testMirrorTemple();
//    testMirrorArms(); //greg
//    testMirrorGull(); //greg
//    testCopy();
//    testCollage();
//    testMyCollage();
//    testEdgeDetection();
//    testEdgeDetection2();// greg
//    testEdgeDetection3(); //greg
    
//    testZeroColor(picture);
    
//    testChromakey(picture, picture2); //greg
      
//    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
      
//      testGlitch(picture);
      testGlitch3(picture);
//      testZero(picture);
      
//      testVerticalShift(picture);
//      testHorizontalShift(picture);
      
  }
}