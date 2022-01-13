package imageProcessing;
import net.imglib2.Dimensions;

import net.imglib2.Cursor;
import net.imglib2.RandomAccess;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import io.scif.img.ImgIOException;
import io.scif.img.ImgOpener;
import io.scif.img.ImgSaver;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.exception.IncompatibleTypeException;
import java.io.File;
import net.imglib2.view.Views;
import net.imglib2.view.IntervalView;
import net.imglib2.loops.LoopBuilder;

public class Color {

    public static int[] getPxMin(Img<UnsignedByteType> input){
		int minR = 255, minG = 255, minB = 255;
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

		final Cursor<UnsignedByteType> cR = inputR.cursor();
		final Cursor<UnsignedByteType> cG = inputG.cursor();
        final Cursor<UnsignedByteType> cB = inputB.cursor();

		while (cR.hasNext() && cG.hasNext() && cB.hasNext() ) {	
			cR.fwd();
			cG.fwd();
            cB.fwd();
			
			if(cR.get().get() < minR)
				minR = cR.get().get();
			if(cG.get().get() < minG)
				minG = cG.get().get();
			if(cB.get().get() < minB)
				minB = cB.get().get();
        }
		int[] min = {minR, minG, minB };
		return min;
	}
	public static int[] getPxMax(Img<UnsignedByteType> input){
		int maxR = 0, maxG = 0, maxB = 0;
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

		final Cursor<UnsignedByteType> cR = inputR.cursor();
		final Cursor<UnsignedByteType> cG = inputG.cursor();
        final Cursor<UnsignedByteType> cB = inputB.cursor();

		while (cR.hasNext() && cG.hasNext() && cB.hasNext() ) {	
			cR.fwd();
			cG.fwd();
            cB.fwd();
			
			if(cR.get().get() > maxR)
				maxR = cR.get().get();
			if(cG.get().get() > maxG)
				maxG = cG.get().get();
			if(cB.get().get() > maxB)
				maxB = cB.get().get();
        }
		int[] max = {maxR, maxG, maxB };
		return max;
	}


	// Methode loopbuilder
	public static void ColorToGray(final Img<UnsignedByteType> input )
	{
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);
   
        LoopBuilder.setImages(inputR, inputG, inputB).forEachPixel(
            (r, g, b) -> { 
				int newcolor = (int)(r.get()*0.3 + g.get()*0.59 + b.get()*0.11 );
                r.set(newcolor);
				g.set(newcolor);
				b.set(newcolor);
            }  
        );
    }

	public static void RgbToHsv(int r, int g, int b, float[] hsv)
	{
		// Calcul Min / Max
		float max = 0, min = 0; 

		if(r >= g && g >= b) {
			max = r;
			min = b;
		} else if(r >= b && b >= g) {
			max = r;
			min = g;
		}
			
		if(g >= r && r >= b) {
			max = g;
			min = b;
		} else if(g >= b && b >= r) {
			max = g;
			min = r;
		}

		if(b >= g && g >= r) {
			max = b;
			min = r;
		} else if(b >= r && r >= g) {
			max = b;
			min = g;
		}
		/* Applique la formule wikipedia */
		// Hue
		float hue = 0;
		if(max != min)
		{
			if(max == r)
				hue  = (float)((60 * ((g - b)/(max-min)) + 360 )%360) ;

			else if(max == g)
				hue  = 60 * ((b - r)/(max-min)) + 120 ;

			else if(max == b)
				hue  = 60 * ((r - g)/(max-min)) + 240 ;
		}
		// Saturation
		float saturation = 0;
		if(max != 0)
			saturation = (1 - (min / max)) * 100;

		hsv[0] = hue;
		hsv[1] = saturation;
		hsv[2] = max ;
    }

	public static void HsvToRgb(float h, float s, float v, int[] rgb)
	{
		s = s / 100; v = (v/100); // intervalle [0,1]
		/* Applique la formule wikipedia */
		int hi = (int)(h/60) % 6 ;
		float f =  (h / 60) - hi ;
		float l = v * (1 - s);
		float m = v * (1 - f * s);
		float n = v * (1 - (1 - f ) * s);

		// On remet les valeurs sur 100
		l *= 100; v *= 100; n *= 100; m *= 100;
		if(hi == 0){
			rgb[0] = (int) v; rgb[1] = (int) n; rgb[2] = (int) l;
		}
		if(hi == 1){
			rgb[0] = (int) m; rgb[1] = (int) v; rgb[2] = (int) l;
		}
		if(hi == 2){
			rgb[0] = (int) l; rgb[1] = (int) v; rgb[2] = (int) n;
		}
		if(hi == 3){
			rgb[0] = (int) l; rgb[1] = (int) m; rgb[2] = (int) v;
		}
		if(hi == 4){
			rgb[0] = (int) n; rgb[1] = (int) l; rgb[2] = (int) v;
		}
		if(hi == 5){
			rgb[0] = (int) v; rgb[1] = (int) l; rgb[2] = (int) m;
		}
    }

	public static void HueFilter(final Img<UnsignedByteType> input, float hue)
	{
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

		float[] hsv = new float[3];
        int[] 	rgb = new int[3];
		
        LoopBuilder.setImages(inputR, inputG, inputB ).forEachPixel(
            (r, g, b) -> { 
				RgbToHsv(r.get(), g.get(),b.get(), hsv);
				HsvToRgb(hue, hsv[1], hsv[2], rgb); // Change la Hue
			
                r.set(rgb[0]);
				g.set(rgb[1]);
				b.set(rgb[2]);
            }  
        );
	}

	// Methode en grisant l'image
	public static void contrast2(final Img<UnsignedByteType> input, int min, int max)
	{
		int[] pixelMax =  getPxMax(input);
		int[] pixelMin =  getPxMin(input);

		int GrayPixelmin = (int) (pixelMin[0] * 0.3 + pixelMin[1] * 0.59 + pixelMin[2] * 0.11);
		int GrayPixelmax = (int) (pixelMax[0] * 0.3 + pixelMax[1] * 0.59 + pixelMax[2] * 0.11);

		int[] LUT = new int[256];
		for(int ng = 0; ng < 256; ng ++)
		{
			int color = ((max - min) * (ng - GrayPixelmin )) / (GrayPixelmax - GrayPixelmin) + min;
			if(color > 255)	color = 255;
			if(color < 0)	color = 0;

			LUT[ng] = color; 
		}
		
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

        LoopBuilder.setImages(inputR, inputG, inputB ).forEachPixel(
            (r, g, b) -> { 
                r.set(LUT[r.get()]);
				g.set(LUT[g.get()]);
				b.set(LUT[b.get()]);
            }  
        );
	}


	public static void contrast3(Img<UnsignedByteType> input, int min, int max ) // 3.3
	{
		float[] tabHSV = new float[3];

		final IntervalView<UnsignedByteType> inputR1 = Views.hyperSlice(input, 2, 0); // vue canal rouge
		final IntervalView<UnsignedByteType> inputG1 = Views.hyperSlice(input, 2, 1); // vue canal vert
        final IntervalView<UnsignedByteType> inputB1 = Views.hyperSlice(input, 2, 2); // vue canal bleu

		final Cursor<UnsignedByteType> cR = inputR1.cursor();
		final Cursor<UnsignedByteType> cG = inputG1.cursor();
        final Cursor<UnsignedByteType> cB = inputB1.cursor();

		int pixelMax = 0; int pixelMin = 0;
		//obtenir le max et le min (en conversion valeur grise de l'image)
		while(cR.hasNext()){
            cR.fwd(); cB.fwd(); cG.fwd();
            RgbToHsv(cR.get().get(), cG.get().get(), cB.get().get(), tabHSV);
			if ((int)tabHSV[2] < pixelMin)
				pixelMin = (int)tabHSV[2];
			if ((int)tabHSV[2]> pixelMax)
				pixelMax = (int)tabHSV[2];
		}

		// LOOKUP Table
		int[] LUT = new int[256];
		for(int ng = 0; ng < 256; ng ++)
		{
			LUT[ng] = ((max - min) * (ng - pixelMin)) / (pixelMax - pixelMin) + min;
		}
		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0); // vue canal rouge
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1); // vue canal vert
        final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2); // vue canal bleu
		LoopBuilder.setImages(inputR, inputG, inputB ).forEachPixel(
            (r, g, b) -> { 
				float[] hsv = new float[3]; 
				RgbToHsv(r.get(), g.get(), b.get(), hsv);

				int[] rgb = new int[3];
				HsvToRgb(hsv[0], hsv[1], LUT[(int)hsv[2]], rgb);
				
				r.set(rgb[0]); 
				g.set(rgb[1]);
				b.set(rgb[2]);
            }  
        );
	}

	public static void Ehistogramme(Img<UnsignedByteType> input )
	{
		int[] table = new int[256]; // histogramme
		int[] tableC = new int[256]; // histogramme cumulé

		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

		// histogramme
		LoopBuilder.setImages(inputR, inputG, inputB ).forEachPixel(
            (r, g, b) -> { 
				float[] hsv = new float[3]; 
				RgbToHsv(r.get(), g.get(), b.get(), hsv);

				float v = hsv[2];
				table[(int) v] += 1; 
            }  
        );

		// Histogramme cumulé
		tableC[0] = table[0];
		for(int i = 1; i < 256; i ++){
			tableC[i] = tableC[i - 1] + table[i];
		}

		float[] hsv = new float[3];
        int[] 	rgb = new int[3];
		
        LoopBuilder.setImages(inputR, inputG, inputB ).forEachPixel(
            (r, g, b) -> { 
				RgbToHsv(r.get(), g.get(),b.get(), hsv);
				long newv = (tableC[(int)hsv[2]] * 255) / (input.max(0) * input.max(1) + 1);
				HsvToRgb(hsv[0], hsv[1], newv, rgb);
			
                r.set(rgb[0]);
				g.set(rgb[1]);
				b.set(rgb[2]);
            }  
        );
	}

    public static void main(final String[] args) throws ImgIOException, IncompatibleTypeException {
			// load image
			if (args.length < 2) {
				System.out.println("missing input or output image filename");
				System.exit(-1);
			}
			final String filename = args[0];
			final ArrayImgFactory<UnsignedByteType> factory = new ArrayImgFactory<>(new UnsignedByteType());
			final ImgOpener imgOpener = new ImgOpener();
			final Img<UnsignedByteType> input = (Img<UnsignedByteType>) imgOpener.openImgs(filename, factory).get(0);
			imgOpener.context().dispose();
	
			// output image of same dimensions
			// final Dimensions dim = input;
			// final Img<UnsignedByteType> output = factory.create(dim);
			
			// ---------- 3) Conversion couleur / niveaux de gris ----------
			System.out.println("----------------- Launching ColorToGray CURSOR -----------------");
			long bTime = System.currentTimeMillis();
			// ColorToGray(input);
			long endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));
			System.out.println("----------------- Launching ColorToGray LOOPBUILDER-----------------");
			bTime = System.currentTimeMillis();
			// ColorToGray2(input);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));

			// ---------- 3) Conversion Conversion RGB / HSV ----------
			System.out.println("----------------- Launching RgbToHsv -----------------");
			bTime = System.currentTimeMillis();
			float[] hsv = new float[3];
			// RgbToHsv(64, 209, 200, hsv);
			// System.out.println("Hue :" + hsv[0] + " Saturation :" + hsv[1] + " Value :" + hsv[2]);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));
			
			System.out.println("----------------- Launching HsvToRgb-----------------");
			bTime = System.currentTimeMillis();
			int[] rgb = new int[3];
			// HsvToRgb(hsv[0], hsv[1], hsv[2], rgb);
			// System.out.println("Red :" + rgb[0] + " Green :" + rgb[1] + " Blue :" + rgb[2]);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));
			
			System.out.println("----------------- Launching ColorImg-----------------");
			bTime = System.currentTimeMillis();
			// HueFilter(input, 270);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));

			System.out.println("----------------- Launching Contrast-----------------");
			bTime = System.currentTimeMillis();
			contrast3(input, 0, 100);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));

			System.out.println("----------------- Launching Egalisation d'histogramme -----------------");
			bTime = System.currentTimeMillis();
			// Ehistogramme(input);
			endTime = System.currentTimeMillis();
			System.out.println("    -- Time taken : " + (endTime - bTime));
			

			final String outPath = args[1];
			File path = new File(outPath);
			if (path.exists()) {
				path.delete();
			}
			ImgSaver imgSaver = new ImgSaver();
			imgSaver.saveImg(outPath, input);
			imgSaver.context().dispose();
			System.out.println("Image saved in: " + outPath);
	
			System.exit(0);	
    }
}
