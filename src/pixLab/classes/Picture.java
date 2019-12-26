package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to set the red and green to 0 */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray: pixels)
    {
      for(Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setRed(0);
      }
    }
  }

  /** Method to set the green and blue to 0 */
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray: pixels)
    {
      for(Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
        pixelObj.setBlue(0);
      }
    }
  }

  /** Method to set the blue and red to 0 */
  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] rowArray: pixels)
    {
      for(Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setRed(0);
      }
    }
  }

  /** To negate a picture,
   * set the red value to 255 minus the current red value,
   * the green value to 255 minus the current green value and
   * the blue value to 255 minus the current blue value
   */
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(int row = 0; row < pixels.length; row++)
    {
      for(int column = 0; column < pixels[row].length; column++)
      {
        Pixel pixelObj = pixels[row][column];
        pixelObj.setBlue(255- pixelObj.getBlue());
        pixelObj.setRed(255- pixelObj.getRed());
        pixelObj.setGreen(255 - pixelObj.getGreen());
      }
    }
  }

  /** sets all the red green blue values to their average
   *  (adds the red green and blue values then divides by 3)
   */
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] row: pixels)
    {
      for(Pixel column: row)
      {
        int grayAmount = (column.getBlue()+column.getRed()
                +column.getGreen())/3;
        Color newColor = new Color(grayAmount, grayAmount, grayAmount);
        column.setColor(newColor);
      }
    }
  }

  /** method to make fish easier to see */
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for(Pixel[] row: pixels)
    {
      for(Pixel column: row)
      {
        if(column.getRed() > 23)
        {
          column.setBlue(column.getBlue()-(column.getBlue()/10));
          column.setGreen(column.getGreen()-(column.getGreen()/10));
          //column.setRed(column.getRed()+20);
        }
        //int blue = column.getBlue()/2;
        //column.setBlue(blue);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Mirror the picture from right to left */
  public void mirrorVerticalRightToLeft()
  {
    Pixel rightPixel;
    Pixel leftPixel;
    Pixel[][] pixels = this.getPixels2D();
    int half = (pixels[1].length)/2;
    for(int row = 0; row < pixels.length; row++)
    {
      for(int column = 0; column<half; column++)
      {
        if(pixels[1].length%2==0)
        {
          rightPixel = pixels[row][half-column+(half-1)];
        }
        else
        {
          rightPixel = pixels[row][half - column + half];
        }
        leftPixel = pixels[row][column];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /** mirrors a picture around the middle of the horizontal axis */
  public void mirrorHorizontalTopToBottom() {
    Pixel topPixel;
    Pixel bottomPixel;
    Pixel[][] pixels = this.getPixels2D();
    int half = pixels.length / 2;
    for (int row = 0; row < half; row++) {
      for (int column = 0; column < pixels[row].length; column++) {
        if (pixels.length % 2 == 0) {
          bottomPixel = pixels[half - row + (half - 1)][column];
        } else {
          bottomPixel = pixels[half - row + half][column];
        }
        topPixel = pixels[row][column];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  /** mirrors a picture around the middle of the horizontal axis bottom to top*/
  public void mirrorHorizontalBottomToTop() {
    Pixel topPixel;
    Pixel bottomPixel;
    Pixel[][] pixels = this.getPixels2D();
    int half = pixels.length / 2;
    for (int row = 0; row < half; row++)
    {
      for(int column = 0; column < pixels[row].length; column++)
      {
        if(pixels.length %2 ==0)
        {
          bottomPixel = pixels[half-row+(half-1)][column];
        }
        else
        {
          bottomPixel = pixels[half-row+half][column];
        }
        topPixel = pixels[row][column];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  /** method to take a square and mirror it diagonally. from bottom left to top right*/
  public void mirrorDiagonal()
  {
    Pixel topLeft ;
    Pixel bottomRight;
    Pixel[][] pixels = this.getPixels2D();
    //width and height will be the same because I want a square
    int sideLength;
    if(pixels.length <= pixels[0].length)
    {
      sideLength = pixels.length;
    }
    else
    {
      sideLength = pixels[0].length;
    }

    for(int row =0;row<sideLength;row++)
    {
      for(int column =0;column<sideLength;column++)
      {
        int half = sideLength/2;
        if(sideLength%2==0)
        {
          topLeft = pixels[half-row+(half-1)][half-column+(half-1)];
          bottomRight = pixels[half-column+(half-1)][half-row+(half-1)];
        }
        else
        {
          topLeft = pixels[half-row+half][half-column+half];
          bottomRight = pixels[half-column+half][half-row+half];
        }
        bottomRight.setColor(topLeft.getColor());
      }
    }
  }

  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();

    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {

        leftPixel = pixels[row][col];
        rightPixel = pixels[row]
                [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count += 1;
      }
    }
    //System.out.println("In the mirrorTemple method the body of the inner loop went "+count+" times");
  }

  /** makes the snowman picture have four arms */
  public void mirrorArms()
  {
    int mirrorPoint = 193; // row  // 196
    Pixel firstPixel;
    Pixel secondPixel;
    Pixel[][] pixels = this.getPixels2D();

    for(int row = 159; row < mirrorPoint; row++)
    {
      for(int column = 104; column<294;column++)
      {
        if(column <170||column>238)
        {
          firstPixel = pixels[row][column];
          secondPixel = pixels[mirrorPoint-row+mirrorPoint][column];
          secondPixel.setColor(firstPixel.getColor());
        }
      }
    }
  }
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
