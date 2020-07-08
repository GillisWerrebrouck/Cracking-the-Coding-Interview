/**
 * Algorithm to draw a horizontal line on a monochromatic screen.
 * 
 * @author Gillis Werrebrouck
 */

public class Draw_Line {
    public static void main(final String args[]) {
        int width = 4;
        int height = 16;
        byte[] screen = new byte[width * height];
        drawLine(screen, width*8, 2, 12, 2);
        drawLine(screen, width*8, 8, 24, 8);
        renderScreen(screen, width*8);
    }

	public static int computeByteNum(int width, int x, int y) {
		return (width * y + x) / 8;
    }
    
    public static void renderByte(byte b) {
		for (int i = 7; 0 <= i; i--) {
			if(((b >> i) & 1) == 1) {
                System.out.print("_");
            } else {
                System.out.print(" ");
            }
		}
	}

    private static void renderScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
            System.out.print("|");
			for (int c = 0; c < width; c+=8) {
				renderByte(screen[(width * r + c) / 8]);
			}
			System.out.println("|");
        }
    }

    private static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
		int firstFullByte = x1 / 8;
		if (startOffset != 0)
			firstFullByte++;
		
		int endOffset = x2 % 8;
		int lastFullByte = x2 / 8;
		if (endOffset != 7)
			lastFullByte--;
		
		// set full bytes of line
		for (int b = firstFullByte; b <= lastFullByte; b++) {
			screen[(width / 8) * y + b] = (byte) 255;
		}
		
		byte startMask = (byte) (255 >> startOffset);
		byte endMask = (byte) ~(255 >> (endOffset + 1));
		
		// set start and end of line
		if ((x1 / 8) == (x2 / 8)) {
			byte mask = (byte) (startMask & endMask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (startOffset != 0) {
				int byteNumber = (width / 8) * y + firstFullByte - 1;
				screen[byteNumber] |= startMask;
			}
			if (endOffset != 7) {
				int byteNumber = (width / 8) * y + lastFullByte + 1;
				screen[byteNumber] |= endMask;
			} 
		}
    }
}
