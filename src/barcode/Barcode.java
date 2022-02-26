/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barcode;

import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeScanner;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.QRCodeECL;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Barcode {

    
    public static void main(String[] args) throws IOException {
        
        // Craete Barcode
        BarcodeSettings bs = new BarcodeSettings();
        bs.setType(BarCodeType.UPCA);
        bs.setData("12345343");
        bs.setData2D("12345343");
        bs.setFontColor(Color.YELLOW);
        BarCodeGenerator bg = new BarCodeGenerator(bs);
        BufferedImage bi = bg.generateImage();
        ImageIO.write(bi, "PNG", new File("UPCA.png"));
        
        // Create QRCode
        BarcodeSettings bs2 = new BarcodeSettings();
        bs2.setType(BarCodeType.QR_Code);
        bs2.setData("12345343");
        bs2.setData2D("12345343");
        bs2.setFontColor(Color.YELLOW);
        bs2.setX(3);
        bs2.setQRCodeECL(QRCodeECL.M);
        BarCodeGenerator bg2 = new BarCodeGenerator(bs2);
        BufferedImage bi2 = bg2.generateImage();
        ImageIO.write(bi2, "PNG", new File("QRCode.png"));
        
        // Scan Barcode & QRCode
        String[] data = BarcodeScanner.scan(bi, BarCodeType.UPCA);
        System.out.println(data[0]);
    }
    
}
