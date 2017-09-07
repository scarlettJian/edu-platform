package edu.bistu.platform.authentication.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class CodeImage {

    private String codes = "";
    private String format = "";
    private String imageBase64 = "";
    private int width = 80;
    private int height = 40;
    private int lineNum = 6;
    private int codeNum = 4;
    private Random random = new Random();
    private BufferedImage image = null;
    private Graphics2D graphics2d = null;

    // 图片大小初始化
    public CodeImage(Integer width, Integer height) {
        if (width != null && width > 0)
            this.width = width;
        if (height != null && height > 0)
            this.height = height;
        this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
        this.graphics2d = image.createGraphics();
        this.graphics2d.setFont(new Font("微软雅黑", Font.BOLD, 25));
    }

    // 绘画 背景色
    private void drawBack(Color color) {
        this.graphics2d.setColor(color);
        this.graphics2d.fillRect(0, 0, this.width, this.height);
    }


    /**
     * 生成随机颜色
     * @param frontColor 前景色
     * @param backColor 背景色
     * @return Color对象，此Color对象是RGB形式的。
     */
    private Color getRandomColor(int frontColor, int backColor) {
        if (frontColor > 255)
            frontColor = 200;
        if (backColor > 255)
            backColor = 255;
        int r = frontColor + random.nextInt(backColor - frontColor);
        int g = frontColor + random.nextInt(backColor - frontColor);
        int b = frontColor + random.nextInt(backColor - frontColor);
        return new Color(r, g, b);
    }

    /**
     * 绘制干扰线
     * @param graphic Graphics2D对象，用来绘制图像
     * @param lineNum 干扰线的条数
     */
    private void drawRandomLines() {
        for (int i = 0; i < this.lineNum; i++) {
            this.graphics2d.setColor(this.getRandomColor(77, 255));
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            this.graphics2d.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 获取随机字符串， 此函数可以产生由大小写字母，汉字，数字组成的字符串
     * @param codeNum 随机字符串的长度
     * @return 随机字符串
     */
    private String drawRandomString() {
        StringBuffer codes = new StringBuffer();
        Character code;
        for (int i = 0; i < this.codeNum; i++) {
            switch (random.nextInt(5)) {
                case 1: // 生成A～Z的字母
                    code = (char) (random.nextInt(26) + 65);
                    break;
                case 2:
                    code = (char) (random.nextInt(26) + 97);
                    break;
                default:
                    code = (char) (random.nextInt(10) + 48);
                    break;
            }
            this.graphics2d.setColor(new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200)));
            // 想文字旋转一定的角度
            AffineTransform trans = new AffineTransform();
            trans.rotate(random.nextInt(10) * -3.14 / 180, 20 * i + 1, 30);
            // 缩放文字
            float scaleSize = (random.nextInt(2) + 9) / 10f;
            trans.scale(scaleSize, scaleSize);
            this.graphics2d.setTransform(trans);
            this.graphics2d.drawString(code.toString(), 5 + 20 * i, 30);
            codes.append(code);
        }
        this.codes = codes.toString();
        return codes.toString();
    }

    public void draw() throws IOException {
        this.drawBack(new Color(240, 240, 240));
        this.drawRandomLines();
        this.drawRandomString();
        this.stream();
        this.graphics2d.dispose();
    }

    public void stream() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(this.image, this.format, baos);
        String imageBase64 = Base64.encodeBase64String(baos.toByteArray());
        this.imageBase64 = imageBase64;
    }

    public String getCodes() {
        return codes;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public String getFormat() {
        return format;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
