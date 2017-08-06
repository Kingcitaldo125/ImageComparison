package imagespitter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.util.ArrayList;

public class ImageSpitter
{
    public ImageSpitter()
    {
        
    }
    
    public static ArrayList processImage(BufferedImage jimage)
    {
        System.out.println("Pixel Data: ");
            
        int w,h;
        w = jimage.getWidth();
        h = jimage.getHeight();
        ArrayList data = new ArrayList();

        int i,j;
        
        for(i=0; i<w; ++i)
        {
            for(j=0; j<h; ++j)
            {
                Color imageOneColor = new Color(jimage.getRGB(i, j), true);
                int r,g,b;
                int[] sRGBData = new int[3];
                r = imageOneColor.getRed();
                g = imageOneColor.getGreen();
                b = imageOneColor.getBlue();
                
                sRGBData[0] = r;
                sRGBData[1] = g;
                sRGBData[2] = b;
                
//                System.out.print(" RED: ");
//                System.out.print(r);
//                System.out.print(" GREEN: ");
//                System.out.print(g);
//                System.out.print(" BLUE: ");
//                System.out.print(b);
//                System.out.println();
                
                data.add(sRGBData);
            }
        }
        return data;
    }
    
    public static void main(String[] args)
    {
        try
        {
            BufferedImage bim = ImageIO.read(new File("im.png"));
            BufferedImage jim = ImageIO.read(new File("jm.png"));
            
            ArrayList imageOneData = processImage(jim);
            ArrayList imageTwoData = processImage(jim);
            
            boolean uImgOne = true;
            if((bim.getWidth() * bim.getHeight()) > (jim.getWidth() * jim.getHeight()))
            {
                uImgOne = false;
                System.out.print(bim);
                System.out.print(" > ");
                System.out.println(jim);
            }
            
            boolean difference = false;
            
            int k,f,g;
            if(uImgOne)
            {
                for(k=0; k<imageOneData.size(); ++k)
                {
                    int[] oo = (int[])imageOneData.get(k);
                    for(f=0; f<oo.length; ++f)
                    {
                        System.out.println(oo[f]);
                    }
                }
            }
            else
            {
                for(k=0; k<imageTwoData.size(); ++k)
                {
                    int[] oo = (int[])imageTwoData.get(k);
                    for(f=0; f<oo.length; ++f)
                    {
                        System.out.println(oo[f]);
                    }
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
    }
    
}
