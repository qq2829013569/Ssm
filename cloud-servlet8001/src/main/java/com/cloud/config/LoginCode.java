package com.cloud.config;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LoginCode {

    private int width = 100;
    private int heigt = 50;
    private Integer size = 4;
    private int lines = 3;
    private int  fsize = 40;

    public  Object[] creteImage(){
        //生成一个空白的背景
        BufferedImage bufferedImage = new BufferedImage(width,heigt,BufferedImage.TYPE_3BYTE_BGR);
        //获取图片画笔
        Graphics2D grap = bufferedImage.createGraphics();
        grap.setColor(Color.WHITE);
        //绘制矩形背景
        grap.fillRect(0,0,width,heigt);

        Random random = new Random();
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuffer sb = new StringBuffer();
        int w = width/(size+1);
        int y = heigt*3/4;
        for(int i=0;i<size;i++){
            grap.setColor(getRandomColor());
            Font font = new Font("宋体",Font.ITALIC,fsize);
            grap.setFont(font);
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            int x = (i*w)+(w/2);
            sb.append(ch);
            grap.drawString(String.valueOf(ch),x,y);
        }
        for(int i=0;i<lines;i++){
            grap.setColor(getRandomColor());
            int w1 = random.nextInt(width);
            int h1 = random.nextInt(heigt);
            int w2 = random.nextInt(width);
            int h2 = random.nextInt(heigt);
            grap.drawLine(w1,h1,w2,h2);
        }
    return new Object[]{sb.toString(),bufferedImage};
    }
    public Color getRandomColor(){
        Random random = new Random();
        int r = random.nextInt(255);
        Color color = new Color(r,r,r);
        return color;
    }
}
