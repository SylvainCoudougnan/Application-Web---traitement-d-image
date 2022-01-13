package pdl.backend;
import net.imglib2.Cursor;
import net.imglib2.Dimensions;
import net.imglib2.RandomAccess;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import net.imglib2.loops.LoopBuilder;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.view.IntervalView;
import net.imglib2.view.Views;



public class Color {

	/**
	 * 
	 * @param input
	 * @return la valeur minimal pour chaque canal
	 */
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
	/**
	 * 
	 * @param input
	 * @return la valeur maximale pour chaque canal
	 */
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

	/**
	 * 
	 * @param input Convertie une image couleur en gris
	 */
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

	/**
	 * Rempli un tableau de flottant contenant les valeurs rgb converties en valeurs hsv 
	 * @param r Rouge
	 * @param g Vert
	 * @param b Bleu
	 * @param hsv
	 */
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

	/**
	 * Rempli un tableau d'entier contenant les valeurs hsv converties en valeurs rgb 
	 * @param h Teinte
	 * @param s Saturation
	 * @param v Valeur
	 * @param rgb
	 */
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

		if(hi == 0) rgb[0] = (int) v; rgb[1] = (int) n; rgb[2] = (int) l;
		if(hi == 1) rgb[0] = (int) m; rgb[1] = (int) v; rgb[2] = (int) l;
		if(hi == 2) rgb[0] = (int) l; rgb[1] = (int) v; rgb[2] = (int) n;
		if(hi == 3) rgb[0] = (int) l; rgb[1] = (int) m; rgb[2] = (int) v;
		if(hi == 4) rgb[0] = (int) n; rgb[1] = (int) l; rgb[2] = (int) v;
		if(hi == 5) rgb[0] = (int) v; rgb[1] = (int) l; rgb[2] = (int) m;
    }

	/**
	 * Modifie la teinte de l'image en fonction de la nouvelle teinte "hue" donnée en parametre
	 * @param input
	 * @param hue
	 */
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

	/**
	 * Modifie le contraste de l'image, les valeurs seront comprises entre le min et le max
	 * @param input
	 * @param min
	 * @param max
	 */
	public static void contrast(final Img<UnsignedByteType> input, int min, int max)
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

	/**
	 * Ajuste le contrast avec la methode d'équalisation d'histogramme
	 * @param input
	 */
	public static void Ehistogramme(Img<UnsignedByteType> input )
	{
		int[] table = new int[256]; // histogramme
		int[] tableC = new int[256]; // histogramme cumulé

		final IntervalView<UnsignedByteType> inputR = Views.hyperSlice(input, 2, 0);
		final IntervalView<UnsignedByteType> inputG = Views.hyperSlice(input, 2, 1);
		final IntervalView<UnsignedByteType> inputB = Views.hyperSlice(input, 2, 2);

		// Histogramme
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
	/**
	 * Augmente / diminue la luminosité de 'img' à partir du 'delta'
	 * @param img image à modifier
	 * @param delta intensité de luminosité
	 */
	public static void brightness(Img<UnsignedByteType> img, int delta){
		
		//itérateur pour parcourir tous les pixels de l'image
		final Cursor< UnsignedByteType > cursor = img.cursor();

		//tant qu'on n'a pas parcouru tous les pixels de l'image
		while ( cursor.hasNext() ) {
			cursor.fwd(); //on avance le curseur
			final UnsignedByteType actuelle = cursor.get();
			int valeurActuelle = actuelle.get();
			int nouvelleValeur = valeurActuelle + delta;
			//on vérifie que les bornes supérieures et inférieures ne sont pas dépassées
			if (nouvelleValeur > 255)
				nouvelleValeur = 255;
			if (nouvelleValeur < 0)
				nouvelleValeur = 0;

			actuelle.set(nouvelleValeur);
		}
	}

	public static int sobelMedian(final RandomAccess<UnsignedByteType> rin,int x,int y,int size,int[][] kernel,int w,int h){
		int rep=0;
		int kernelx=0;
		int kernely=0;
		for(int i=(x-(size/2));i<=(x+(size/2));i++){		
			for(int j=(y-(size/2));j<=(y+(size/2));j++){
					if(i>=0 && j>=0 && j<=h && i<=w){
						rin.setPosition(i,0);
						rin.setPosition(j,1);
						final UnsignedByteType val = rin.get();
						rep=rep+val.get()*kernel[kernelx][kernely]; //multiplie
					}
					kernely++;
			}
			kernely=0;
			kernelx++;
		}
		rep=Math.abs(rep);
		if(rep>255){
			rep=255;
		}
		return rep;
	}

	public static void sobelconvolution(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output,int[][] kernel) {
		int width=(int) input.max(0);
		int height=(int) input.max(1);
		int size=kernel.length;
		RandomAccess<UnsignedByteType> inputRand = input.randomAccess();
		RandomAccess<UnsignedByteType> rout = output.randomAccess();
		for (int x = 0; x <= width; x++) {
			for (int y = 0; y <= height; y++) {
				for(int color=0;color<3;color++){
					rout.setPosition(color,2);
					inputRand.setPosition(color,2);
					int median=sobelMedian(inputRand, x, y,size,kernel,width,height);
					rout.setPosition(x,0);
					rout.setPosition(y,1);
					rout.get().set(median);
				}
			}
		}
	}
	public static void sobel(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output){
		final ArrayImgFactory<UnsignedByteType> factory = new ArrayImgFactory<>(new UnsignedByteType());
		final Dimensions dim = input;
		final Img<UnsignedByteType> outputvert = factory.create(dim);
		final Img<UnsignedByteType> outputhori = factory.create(dim);
		int[][] kernelv = new int[][] {
			new int[] {1,0,-1},
			new int[] {2,0,-2},
			new int[] {1,0,-1},
		};
		int[][] kernelh = new int[][] {
			new int[] {1,2,1},
			new int[] {0,0,0},
			new int[] {-1,-2,-1},
		};
		sobelconvolution(input, outputhori, kernelh);
		sobelconvolution(input, outputvert, kernelv);
		final IntervalView<UnsignedByteType> outputhoriR = Views.hyperSlice(outputhori, 2, 0);
		final IntervalView<UnsignedByteType> outputhoriG = Views.hyperSlice(outputhori, 2, 1);
		final IntervalView<UnsignedByteType> outputhoriB = Views.hyperSlice(outputhori, 2, 2);
		final IntervalView<UnsignedByteType> outputvertR = Views.hyperSlice(outputvert, 2, 0);
		final IntervalView<UnsignedByteType> outputvertG = Views.hyperSlice(outputvert, 2, 1);
		final IntervalView<UnsignedByteType> outputvertB = Views.hyperSlice(outputvert, 2, 2);
		final IntervalView<UnsignedByteType> outputR = Views.hyperSlice(output, 2, 0);
		final IntervalView<UnsignedByteType> outputG = Views.hyperSlice(output, 2, 1);
		final IntervalView<UnsignedByteType> outputB = Views.hyperSlice(output, 2, 2);
		final Cursor< UnsignedByteType> horiR = outputhoriR.cursor();
        final Cursor< UnsignedByteType> horiG = outputhoriG.cursor();
		final Cursor< UnsignedByteType> horiB = outputhoriB.cursor();
		final Cursor< UnsignedByteType> vertR = outputvertR.cursor();
        final Cursor< UnsignedByteType> vertG = outputvertG.cursor();
		final Cursor< UnsignedByteType> vertB = outputvertB.cursor();
		final Cursor< UnsignedByteType> outR = outputR.cursor();
        final Cursor< UnsignedByteType> outG = outputG.cursor();
		final Cursor< UnsignedByteType> outB = outputB.cursor();
		while(horiR.hasNext() && horiG.hasNext() && horiB.hasNext() && vertR.hasNext() && vertG.hasNext() && vertB.hasNext() && outR.hasNext() && outG.hasNext() && outB.hasNext()){
				horiR.fwd();horiG.fwd();horiB.fwd();
				vertR.fwd();vertG.fwd();vertB.fwd();
				outR.fwd();outG.fwd();outB.fwd();
				double hR=horiR.get().get();
				double hG=horiG.get().get();
				double hB=horiB.get().get();
				double vR=vertR.get().get();
				double vG=vertG.get().get();
				int vB=vertB.get().get();
				int calr=(int) Math.sqrt(Math.pow(hR,2)+Math.pow(vR,2));
				int calg=(int) Math.sqrt(Math.pow(hG,2)+Math.pow(vG,2));
				int calb=(int) Math.sqrt(Math.pow(hB,2)+Math.pow(vB,2));
				if(calr>255){
					calr=255;
				}
				if(calg>255){
					calg=255;
				}
				if(calb>255){
					calb=255;
				}
				outR.get().set(calr);
				outG.get().set(calg);
				outB.get().set(calb);
		}
	}
	public static int kernelMedian(final RandomAccess<UnsignedByteType> rin,int x,int y,int size,int[][] kernel,int w,int h){
		int rep=0;
		int compt=0; //le compteur permet de connaitre par combien il faut diviser la somme des pixels pour obtenir la moyenne
		int kernelx=0;
		int kernely=0;
		for(int i=(x-(size/2));i<=(x+(size/2));i++){		
			for(int j=(y-(size/2));j<=(y+(size/2));j++){
					if(i>=0 && j>=0 && j<=h && i<=w){
						rin.setPosition(i,0);
						rin.setPosition(j,1);
						final UnsignedByteType val = rin.get();
						rep=rep+val.get()*kernel[kernelx][kernely]; //multiplie
						compt=compt+kernel[kernelx][kernely];
					}
					kernely++;
			}
			kernely=0;
			kernelx++;
		}
		if(compt!=0){
			
			return rep/compt;
		}
		else
			return -1;
	}

	/**
	 * Applique le filtre de convolution en fonction du noyau de convolution donné en parametre
	 * @param input
	 * @param output
	 * @param kernel noyau de convolution
	 */
	public static void convolution(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output,int type) {
        int[][] kernel;
        if(type==0){
                kernel = new int[][] {
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                    new int[] {1,1,1,1,1,1,1,1,1},
                };
            }
            else{
                kernel = new int[][] {
                    new int[] { 1,2,3,2,1},
                    new int[] { 2,6,8,6,8 },
                    new int[] { 3,8,10,8,3},
                    new int[] { 2,6,8,6,8 },
                    new int[] { 1,2,3,2,1 },
                  };
            }
				int width=(int) input.max(0);
				int height=(int) input.max(1);
				int size=kernel.length;
				RandomAccess<UnsignedByteType> inputRand = input.randomAccess();
				RandomAccess<UnsignedByteType> rout = output.randomAccess();
				for (int x = 0; x <= width; x++)
					for (int y = 0; y <= height; y++) {
						for(int color=0;color<3;color++){
							rout.setPosition(color,2);
							inputRand.setPosition(color,2);
							int median=kernelMedian(inputRand, x, y,size,kernel,width,height);
							rout.setPosition(x,0);
							rout.setPosition(y,1);
							rout.get().set(median);
						}					
					}
	}
}