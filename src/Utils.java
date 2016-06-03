

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.net.URL;

public class Utils
{
	public static Font createFont() throws Exception
	{
		URL fontUrl = new URL("http://www.jpdesigns316.com/Chalkboard.ttf");
        
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        font = font.deriveFont(Font.PLAIN,24);
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
				return font;
	}

}
