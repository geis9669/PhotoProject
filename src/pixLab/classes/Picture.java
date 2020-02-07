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
  
  /** Method to set the red to 0 */
  public void zeroRed()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray : pixels)
      {
          for (Pixel pixelObj : rowArray)
          {
              pixelObj.setRed(0);
          }
      }
  }
  
  public static final int RED = 0;
  public static final int GREEN = 1;
  public static final int BLUE = 2;
  
  public void zero(int color, int topRow, int topCol, int bottomRow, int bottomCol)
  {
      Pixel[][] pixels = this.getPixels2D();
      if(topRow<bottomRow&&topCol<bottomCol)
      {
          if(topRow>-1&&bottomRow<pixels.length&&topCol > -1 && bottomCol < pixels[0].length) 
          {
              for(int row = topRow; row< bottomRow; row++)
              {
                  for(int col = topCol; col<bottomCol; col ++)
                  {
                      if(color == RED)
                      {
                          pixels[row][col].setRed(0);
                      }
                      else if(color==GREEN)
                      {
                          pixels[row][col].setGreen(0);
                      }
                      else if(color == BLUE)
                      {
                          pixels[row][col].setBlue(0);
                      }
                  }
              }
          }
      }
  }
  
  public void zero(int color)
  {
      zero(color, 0, 0, this.getPixels2D().length, this.getPixels2D()[0].length);
  }
  
  /** Method to set the green to 0*/
  public void zeroGreen()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(int row =0;row<pixels.length; row++)
      {
          for(int col = 0; col<pixels[row].length; col++)
          {
              pixels[row][col].setGreen(0);
          }
      }
  }
  
  /**
   * zeros the green pixel for an area
   * @param topRow the top of the area you want to start
   * @param topCol where to start for the columns.
   * @param bottomRow where to end
   * @param bottomCol where to end
   */
  public void zeroGreen(int topRow, int topCol, int bottomRow, int bottomCol)
  {
      Pixel[][] pixels = this.getPixels2D();
      
      if(topRow<bottomRow && topCol < bottomCol)
      {
          if(topRow>-1&&bottomRow<pixels.length&&topCol >-1 && bottomCol< pixels[0].length)
          {
              for(int row= topRow; row< bottomRow; row++)
              {
                  for(int col = topCol; col< bottomCol; col++)
                  {
                      pixels[row][col].setGreen(0);
                  }
              }
          }
      }
  }
  
  /** Method to set the blue to max */
  public void maxBlue()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] pixelArray: pixels)
      {
          for(Pixel pixel : pixelArray)
          {
              pixel.setBlue(Integer.MAX_VALUE);
          }
      }
  }
  
  /** Method to set the red to max */
  public void maxRed()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] pixelArray: pixels)
      {
          for(Pixel pixel : pixelArray)
          {
              pixel.setRed(Integer.MAX_VALUE);
          }
      }
  }
  
  /** Method to set the green to max */
  public void maxGreen()
  {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] pixelArray: pixels)
      {
          for(Pixel pixel : pixelArray)
          {
              pixel.setGreen(Integer.MAX_VALUE);
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
          column.setBlue(column.getBlue()-50);
//        if(column.getRed() > 23)
//        {
//          column.setBlue(column.getBlue()-(column.getBlue()/10));
//          column.setGreen(column.getGreen()-(column.getGreen()/10));
//          //column.setRed(column.getRed()+20);
//        }
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
        if (pixels.length % 2 == 0) {// even 
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
  
  public void fourWayMirror()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topLeft = null;
      Pixel topRight = null;
      Pixel bottomLeft = null;
      Pixel bottomRight = null;
      
      int width = pixels[0].length;
      int height = pixels.length;
      
      for(int row = 0; row<height / 2; row ++)
      {
          for(int col = 0; col < width/2; col++)
          {
              topLeft = pixels[row][col];
              topRight = pixels[row][width-col-1];
              bottomLeft = pixels[height-row-1][col];
              bottomRight = pixels[height-row-1][width-col-1];
              
              topRight.setColor(topLeft.getColor());
              bottomLeft.setColor(topLeft.getColor());
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

  /** makes a second sea gull in the seagull.jpg */
  public void mirrorGull()
  {
    int mirrorPoint = 230; //column
    Pixel firstPixel;
    Pixel secondPixel;
    Pixel[][] pixels = this.getPixels2D();

    for(int row = 234; row< 322; row++)
    {
      for(int column = 345; column > mirrorPoint; column--)
      {
        firstPixel = pixels[row][column];
        secondPixel = pixels[row][mirrorPoint-column+mirrorPoint];
        secondPixel.setColor(firstPixel.getColor());
      }
    }

  }
  
  
  public void glitch()
  {
      Pixel[][] pixels = this.getPixels2D();
      int randomRow = (int) (Math.random()* pixels.length);
      int randomCol = (int) (Math.random()*pixels[0].length);
      
      int startRow = (int) (Math.random() * randomRow);
      int startCol = (int) (Math.random() * randomCol);
      
      for(int row = startRow; row< randomRow; row++)
      {
          for(int col = startCol; col<randomCol; col++)
          {
              int red = (int) (Math.random()* 256);
              int green = (int)(Math.random()*256);
              int blue = (int)(Math.random()*256);
              Color randomColor = new Color(red,green,blue);
              
              pixels[row][col].setColor(randomColor);
          }
      }
      
      int endRow = (int) (Math.random()*pixels.length);
      startRow = (int) (Math.random()*endRow);
      int endCol = (int) (Math.random()*pixels[0].length);
      startCol = (int) (Math.random()* endCol);
      zeroGreen(startRow,startCol,endRow,endCol);
  }
  
  public void horizontalShift()
  {
      Pixel[][] pixels = this.getPixels2D();
      Color[][] shiftPixels = new Color[pixels.length][pixels[0].length];
      
      for(int row = 0; row<pixels.length; row++)
      {
          for(int col = 0; col< pixels[0].length; col++)
          {
              Pixel current = pixels[row][col];
              shiftPixels[row][col] = new Color(current.getRed(),current.getGreen(),current.getBlue());
              //shiftPixels[row][col].setColor(pixels[row][col].getColor());          
          }
      }
      
      int shift = -300;
      
      for(int row = 0; row<shiftPixels.length; row++)
      {
          for(int  col = 0; col<shiftPixels[0].length; col++)
          {
              int nextCol = col + shift;
              if(nextCol >= pixels[0].length)
              {
                  nextCol = nextCol - pixels[0].length;
              }
              if(nextCol < 0)
              {
                  nextCol = pixels[0].length + nextCol;
              }
              pixels[row][nextCol].setColor(shiftPixels[row][col]);
              //pixels[row][col].setBlue(0);
          }
      } 
  }

    /**
     * moves pixels in the rows left or right, by the specified amount
     * @param shiftAmount the amount of pixels you want each moved
     * @param startRow what row to start on
     * @param endRow what row to end right before doing.
     */
  public void horizontalShift(int shiftAmount, int startRow, int endRow)
  {
      Pixel[][] pixels = this.getPixels2D();
      
      if(startRow < endRow && startRow>-1&&endRow<pixels.length)
      {
          if(shiftAmount < pixels[0].length && shiftAmount > pixels[0].length*-1)
          {
              
              Color[][] shiftPixels = new Color[pixels.length][pixels[0].length];
              
              for(int row = startRow; row<endRow; row++)
              {
                  for(int col = 0; col< pixels[0].length; col++)
                  {
                      Pixel current = pixels[row][col];
                      shiftPixels[row][col] = new Color(current.getRed(),current.getGreen(),current.getBlue());
                  }
              }
              
              for(int row = startRow; row<endRow; row++)
              {
                  for(int  col = 0; col<shiftPixels[0].length; col++)
                  {
                      int nextCol = col + shiftAmount;
                      if(nextCol >= pixels[0].length)
                      {
                          nextCol = nextCol - pixels[0].length;
                      }
                      if(nextCol < 0)
                      {
                          nextCol = pixels[0].length + nextCol;
                      }
                      pixels[row][nextCol].setColor(shiftPixels[row][col]);
                  }
              }                           
          }
      }
  }

    /**
     * moves a set of pixels in the rows up or down and it wraps it.
     * @param shiftAmount how many pixels to move them by
     * @param startCol where to start the pixels that will move
     * @param endCol where to end the pixels that will move, this will be one less then the number.
     */
  public void verticalShift(int shiftAmount, int startCol, int endCol)
  {
      Pixel[][] pixels = this.getPixels2D();
      
      if(startCol < endCol && startCol>-1&&endCol<pixels[0].length)
      {
          if(shiftAmount < pixels.length && shiftAmount > pixels.length*-1)
          {
              
              Color[][] shiftPixels = new Color[pixels.length][pixels[0].length];
              
              for(int row = 0; row<pixels.length; row++)
              {
                  for(int col = startCol; col< endCol; col++)
                  {
                      Pixel current = pixels[row][col];
                      shiftPixels[row][col] = new Color(current.getRed(),current.getGreen(),current.getBlue());
                  }
              }
              
              for(int col = startCol; col<endCol; col++)
              {
                  for(int row = 0; row<shiftPixels.length; row++)
                  {
                      int nextRow = row + shiftAmount;
                      if(nextRow >= pixels.length)
                      {
                          nextRow = nextRow - pixels.length;
                      }
                      if(nextRow < 0)
                      {
                          nextRow = pixels.length + nextRow;
                      }
                      pixels[nextRow][col].setColor(shiftPixels[row][col]);
                  }
              }                           
          }
      }
  }
  
  public void glitch3() {
      Pixel[][] pixels = this.getPixels2D();

      int options = 3;

      int changes = (int) (Math.random() * (100/2))+5;
      for(int time = 0; time <= changes; time++)
      {
          int randomChange = (int)(Math.random()*options);
          if(randomChange == 0)
          {
              int startRow = (int) (Math.random()*pixels.length);
              int endRow = (int) (Math.random()* (pixels.length-startRow) )+startRow;
              int shift = (int) (Math.random()* (pixels.length*2));//-pixels.length;
              horizontalShift(shift,startRow,endRow);
          }
          else if(randomChange == 1)
          {
              int startCol = (int) (Math.random()*pixels[0].length);
              int endCol = (int) (Math.random()*(pixels[0].length-startCol))+startCol;
              int shift = (int) (Math.random()*(pixels[0].length*2));
              verticalShift(shift,startCol,endCol);
          }
          else if(randomChange == 2)
          {
              mirrorDiagonal();
          }
//          int startRow = (int) (Math.random()*pixels.length);
//          int endRow = (int) (Math.random()* (pixels.length-startRow) )+startRow;
//
//          int shift = (int) (Math.random()* pixels.length*2);//-pixels.length;
      }
  }
  
  public void glitch3(int changes) {
      Pixel[][] pixels = this.getPixels2D();

      int options = 2;

      //int changes = (int) (Math.random() * (modifier))+1;
      for(int time = 0; time <= changes; time++)
      {
          int randomChange = (int)(Math.random()*options);
          if(randomChange == 0)
          {
              int startRow = (int) (Math.random()*pixels.length);
              int endRow = (int) (Math.random()* (pixels.length-startRow) )+startRow;
              int shift = (int) (Math.random()* (pixels.length*2));//-pixels.length;
              horizontalShift(shift,startRow,endRow);
          }
          else if(randomChange == 1)
          {
              int startCol = (int) (Math.random()*pixels[0].length);
              int endCol = (int) (Math.random()*(pixels[0].length-startCol))+startCol;
              int shift = (int) (Math.random()*(pixels[0].length*2));
              verticalShift(shift,startCol,endCol);
          }
//          int startRow = (int) (Math.random()*pixels.length);
//          int endRow = (int) (Math.random()* (pixels.length-startRow) )+startRow;
//
//          int shift = (int) (Math.random()* pixels.length*2);//-pixels.length;
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

  /**
   *
   * @param fromPic the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start column to copy to
   * @param startRowPic the start row to copy from
   * @param startColPic the start column to copy from
   * @param endRowPic the end row to copy from
   * @param endColPic the end column to copy from
   */
  public void copy(Picture fromPic, int startRow, int startCol,
                   int startRowPic, int startColPic, int endRowPic, int endColPic)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] fromPixels = fromPic.getPixels2D();
    Pixel[][] toPixels = this.getPixels2D();
    for(int fromRow = startRowPic, toRow = startRow;
    fromRow <= endRowPic && fromRow < fromPixels.length && toRow < toPixels.length;
    fromRow++, toRow++)
    {
      for(int fromCol = startColPic, toCol = startCol;
      fromCol<=endColPic && fromCol<fromPixels[0].length && toCol<toPixels[0].length;
      fromCol++, toCol++)
      {
        fromPixel =fromPixels[fromRow][fromCol];
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

  /** Method to crate a collage of several pictures that greg made */
  public void createMyCollage()
  {
    // mirroring and two other manipulations
    // three pictures
    Picture beach = new Picture( "beach.jpg");
    Pixel[][] beachPixels = beach.getPixels2D();
    Picture beachSquare = new Picture(beachPixels.length,beachPixels.length);
    beachSquare.copy(beach, 0,0);
    beachSquare = beachSquare.scale(0.5,0.5);
    beachSquare.mirrorDiagonal();

    Picture whiteFlower = new Picture("whiteFlower.jpg");
    whiteFlower = whiteFlower.scale(0.50,0.669);
    int flowerSize = (beachPixels.length/2)/2;
    Picture flowers = new Picture(flowerSize,flowerSize);
    flowers.copy(whiteFlower, 0, 0,47,130,1000,1000);
    flowers.zeroBlue();

    this.copy(beachSquare,0,0);
    this.copy(flowers,0,0);
    this.mirrorHorizontalTopToBottom();
    this.mirrorVertical();
    this.write("myCollage.jpg");
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

  /**
   * Method to show large changes in color both left to right and up and down.
   * @param edgeDistance the distance for finding edges
   */
  public void edgeDetection2(int edgeDistance)
  {
    Pixel leftPixel;
    Pixel rightPixel;
    Pixel downPixel;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor;
    Color downColor;
    for(int row=0; row<pixels.length-1;row++)
    {
      for(int column=0; column<pixels[row].length-1; column++)
      {
        leftPixel = pixels[row][column];
        rightPixel = pixels[row][column+1];
        downPixel = pixels[row+1][column];
        rightColor = rightPixel.getColor();
        downColor = downPixel.getColor();
        if(leftPixel.colorDistance(rightColor) > edgeDistance
                || leftPixel.colorDistance(downColor) > edgeDistance)
          leftPixel.setColor(Color.black);
        else
          leftPixel.setColor(Color.white);
      }
    }
  }

  /**
   * Method to find edges from top to bottom
   * @param edgeDistance the distance for finding the edges
   */
  public void edgeDetection3(int edgeDistance)
  {
    Pixel currentPixel;
    Pixel nextPixel;
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = this.getPixels2D().clone();
    Color nextColor;
//    for (int row = 0; row < pixels.length; row++)
//    {
//      for (int col = 0;
//           col < pixels[0].length-1; col++)
//      {
//        currentPixel = pixels[row][col];
//        nextPixel = pixels[row][col+1];
//        nextColor = nextPixel.getColor();
//        if (currentPixel.colorDistance(nextColor) >
//                edgeDistance)
//          currentPixel.setColor(Color.BLACK);
//        else
//          currentPixel.setColor(Color.WHITE);
//      }
//    }
    for(int col = 0; col < pixels2[0].length; col++)
    {
      for(int row = 0; row< pixels2.length-1; row++)
      {
        currentPixel = pixels2[row][col];
        nextPixel = pixels2[row+1][col];
        nextColor =nextPixel.getColor();
        if(currentPixel.colorDistance(nextColor)> edgeDistance)
          pixels[row][col].setColor(Color.black);
        else
          pixels[row][col].setColor(Color.white);
      }
    }
  }

    /**
     * replaces the back ground of the current picture with a different picture
     * @param backGround the picture to put behind the top picture. needs to be as big as the picture this is called on
     * @param backGroundColor the color to look for in the picture
     * @param howClose how close the color its looking at is to the color you specified
     */
  public void chromakey(Picture backGround, Color backGroundColor, int howClose)
  {
      chromakey(backGround, backGroundColor, howClose, 0,0);
  }

    /**
     * replaces the back ground of the current picture with a different picture
     * @param background the picture to put behind the top picture. needs to be as big as the picture this is called on
     * @param backGroundColor the color to look for in the picture
     * @param howClose how close the color its looking at is to the color you specified
     * @param rowOffset what row to start copying from the background
     * @param colOffset what col to start copying from the background
     */
  public void chromakey(Picture background, Color backGroundColor, int howClose, int rowOffset, int colOffset)
  {
      Pixel[][] pixelsForeground = this.getPixels2D();
      Pixel[][] pixelsBackground = background.getPixels2D();
      
      if(pixelsForeground.length <= pixelsBackground.length-rowOffset && pixelsForeground[0].length <= pixelsBackground[0].length-colOffset)
      {
          for(int row = 0; row<pixelsForeground.length; row++)
          {
              for(int col = 0; col<pixelsForeground[0].length; col++)
              {   
                  if(pixelsForeground[row][col].colorDistance(backGroundColor) <= howClose)
                  {
                      pixelsForeground[row][col].setColor(pixelsBackground[row+rowOffset][col+colOffset].getColor());
                  }
                  
                  
              }
          }
      }
      
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
//  public static void main(String[] args) 
//  {
//    Picture beach = new Picture("whiteFlower.jpg");
//    beach.explore();
//    beach.zeroBlue();
//    beach.explore();
//  }
  
} // this } is the end of class Picture, put all new methods before this
